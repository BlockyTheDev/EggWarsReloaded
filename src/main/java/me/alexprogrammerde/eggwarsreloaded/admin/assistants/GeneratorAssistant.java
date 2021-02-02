package me.alexprogrammerde.eggwarsreloaded.admin.assistants;

import me.alexprogrammerde.eggwarsreloaded.EggWarsReloaded;
import me.alexprogrammerde.eggwarsreloaded.utils.UtilCore;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class GeneratorAssistant implements Listener {
    public static final String prefix = ChatColor.GOLD + "[" + ChatColor.DARK_PURPLE + "GeneratorAssistant" + ChatColor.GOLD + "] ";
    private static final HashMap<Player, GeneratorAssistant> assistants = new HashMap<>();
    private final Player player;
    private final String arenaName;
    private final EggWarsReloaded plugin;

    public GeneratorAssistant(Player player, String arenaName, EggWarsReloaded plugin) {
        assistants.put(player, this);

        this.player = player;
        this.arenaName = arenaName;
        this.plugin = plugin;

        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public static boolean isAdding(Player player) {
        return assistants.containsKey(player);
    }

    public static void removePlayer(Player player) {
        HandlerList.unregisterAll(assistants.get(player));

        assistants.remove(player);
    }

    @EventHandler
    public void onBlockInteract(BlockBreakEvent event) {
        FileConfiguration arenas = plugin.getArenaConfig();
        Player player = event.getPlayer();
        Block block = event.getBlock();
        String blockLocationString = UtilCore.convertString(block.getLocation());

        if (player == this.player && isAdding(player)) {
            if (block.getType() == Material.IRON_BLOCK) {
                event.setCancelled(true);
                List<String> generators = arenas.getStringList(arenaName + ".iron");

                if (generators.contains(blockLocationString)) {
                    player.sendMessage(prefix + "This block is already added!");
                } else {
                    generators.add(blockLocationString);
                    arenas.set(arenaName + ".iron", generators);
                    player.sendMessage(prefix + "Added iron block: " + blockLocationString);
                }
            } else if (block.getType() == Material.GOLD_BLOCK) {
                event.setCancelled(true);
                List<String> generators = arenas.getStringList(arenaName + ".gold");

                if (generators.contains(blockLocationString)) {
                    player.sendMessage(prefix + "This block is already added!");
                } else {
                    generators.add(blockLocationString);
                    arenas.set(arenaName + ".gold", generators);
                    player.sendMessage(prefix + "Added gold block: " + blockLocationString);
                }
            } else if (block.getType() == Material.DIAMOND_BLOCK) {
                event.setCancelled(true);
                List<String> generators = arenas.getStringList(arenaName + ".diamond");

                if (generators.contains(blockLocationString)) {
                    player.sendMessage(prefix + "This block is already added!");
                } else {
                    generators.add(blockLocationString);
                    arenas.set(arenaName + ".diamond", generators);
                    player.sendMessage(prefix + "Added diamond block: " + blockLocationString);
                }
            }

            try {
                plugin.getArenaConfig().save(plugin.getArenasFile());
            } catch (IOException e) {
                e.printStackTrace();
            }

            plugin.loadConfig();
        }
    }
}