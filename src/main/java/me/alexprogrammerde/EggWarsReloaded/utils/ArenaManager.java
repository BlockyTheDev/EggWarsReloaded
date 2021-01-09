package me.alexprogrammerde.EggWarsReloaded.utils;

import me.alexprogrammerde.EggWarsReloaded.EggWarsReloaded;
import me.alexprogrammerde.EggWarsReloaded.game.collection.TeamColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.IOException;
import java.util.List;

public class ArenaManager {
    public static FileConfiguration getArenas() {
        return EggWarsReloaded.get().getArenas();
    }

    public static void setArenaWorld(String arenaName, String world) {
        getArenas().set(arenaName + ".world", world);

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static String getArenaWorld(String arenaName) {
        return getArenas().getString(arenaName + ".world");
    }

    public static void addArena(String arenaName) {
        getArenas().createSection(arenaName);
        getArenas().set(arenaName + ".size", 1);

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void setMainLobby(String arenaName, Location location) {
        getArenas().set(arenaName + ".mainlobby", UtilCore.convertString(location));

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void setWaitingLobby(String arenaName, Location location) {
        getArenas().set(arenaName + ".waitinglobby", UtilCore.convertString(location));

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void setSpectator(String arenaName, Location location) {
        getArenas().set(arenaName + ".spectator", UtilCore.convertString(location));

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static Location getMainLobby(String arenaName) {
        return UtilCore.convertLocation(getArenas().getString(arenaName + ".mainlobby"));
    }

    public static Location getWaitingLobby(String arenaName) {
        return UtilCore.convertLocation(getArenas().getString(arenaName + ".waitinglobby"));
    }

    public static Location getSpectator(String arenaName) {
        return UtilCore.convertLocation(getArenas().getString(arenaName + ".spectator"));
    }

    public static void setArenaRegistered(String arenaName, boolean register, List<TeamColor> teams) {
        getArenas().set(arenaName + ".registered", register);
        getArenas().set(arenaName + ".registeredteams", teams);

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void setTeamSize(String arenaName, Integer size) {
        getArenas().set(arenaName + ".size", size);

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static int getTeamSize(String arenaName) {
        FileConfiguration arenas = getArenas();

        return arenas.getInt(arenaName + ".size");
    }

    public static boolean isArenaRegistered(String arenaName) {
        return getArenas().getBoolean(arenaName + ".registered");
    }

    public static void setTeamRegistered(String arenaName, TeamColor teamName, boolean register) {
        getArenas().set(arenaName + ".team." + teamName + ".registered", register);

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void setArenaPos1(String arenaName, Location pos1) {
        getArenas().set(arenaName + ".pos1", UtilCore.convertString(pos1));

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void setArenaPos2(String arenaName, Location pos2) {
        getArenas().set(arenaName + ".pos2", UtilCore.convertString(pos2));

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void deleteArena(String arenaName) {
        getArenas().set(arenaName, null);

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void setEgg(String arenaName, TeamColor teamName, Location eggLocation) {
        getArenas().set(arenaName + ".team." + teamName + ".egg", UtilCore.convertString(eggLocation));

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void setShop(String arenaName, TeamColor teamName, String uuid, Location location) {
        FileConfiguration arenas = ArenaManager.getArenas();

        if (uuid == null || location == null) {
            arenas.set(arenaName + ".team." + teamName + ".shop", null);
        } else {
            arenas.set(arenaName + ".team." + teamName + ".shop.uuid", uuid);
            arenas.set(arenaName + ".team." + teamName + ".shop.location", UtilCore.convertString(location));
        }

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void setFirstSpawn(String arenaName, TeamColor teamName, Location location) {
        getArenas().set(arenaName + ".team." + teamName + ".spawn", UtilCore.convertString(location));

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static void setRespawn(String arenaName, TeamColor teamName, Location location) {
        getArenas().set(arenaName + ".team." + teamName + ".respawn", UtilCore.convertString(location));

        try {
            getArenas().save(EggWarsReloaded.get().getArenasFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        EggWarsReloaded.get().reloadArenas();
    }

    public static Location getRespawn(String arenaName, TeamColor team) {
        return UtilCore.convertLocation(getArenas().getString(arenaName + ".team." + team.toString() + ".respawn"));
    }

    public static boolean isTeamRegistered(String arenaName, TeamColor team) {
        return getArenas().getBoolean(arenaName + ".team." + team.toString() + ".registered");
    }

    public static boolean isArenaReady(String arenaName) {
        // TODO: Add checks

        return true;
    }

    public static boolean isTeamReady(String arenaName, TeamColor teamName) {
        FileConfiguration arenas = ArenaManager.getArenas();

        return arenas.contains(arenaName + ".team." + teamName + ".egg")
                && arenas.contains(arenaName + ".team." + teamName + ".shop")
                && arenas.contains(arenaName + ".team." + teamName + ".spawn")
                && arenas.contains(arenaName + ".team." + teamName + ".respawn");
    }
}
