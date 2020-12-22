package me.alexprogrammerde.EggWarsReloaded.game.listeners;

import me.alexprogrammerde.EggWarsReloaded.game.Game;
import me.alexprogrammerde.EggWarsReloaded.game.GameControl;
import me.alexprogrammerde.EggWarsReloaded.game.collection.GameState;
import me.alexprogrammerde.EggWarsReloaded.game.guis.Shop;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ShopListener implements Listener {
    private final Game game;

    public ShopListener(Game game) {
        this.game = game;
    }

    @EventHandler
    public void onClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();

        if (GameControl.isInGame(player) && game.state == GameState.RUNNING) {
            if (event.getRightClicked().getType() == EntityType.VILLAGER) {
                Shop.setupShopMenu(game.arenaName, game.matchmaker.getTeamOfPlayer(player), player);
            }
        }
    }
}