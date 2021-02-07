package net.pistonmaster.eggwarsreloaded.game;

import net.pistonmaster.eggwarsreloaded.game.collection.TeamColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameLogics {
    private final Game game;

    public GameLogics(Game game) {
        this.game = game;
    }

    public boolean isOnlyOneTeamLeft() {
        List<TeamColor> teams = new ArrayList<>();

        for (Player player : game.matchmaker.playerInTeam.keySet()) {
            if (game.livingPlayers.contains(player)) {
                teams.add(game.matchmaker.playerInTeam.get(player));
            }
        }

        return teams.size() == 1;
    }

    public TeamColor getLastTeam() {
        List<TeamColor> teams = new ArrayList<>();

        for (Player player : game.matchmaker.playerInTeam.keySet()) {
            if (game.livingPlayers.contains(player)) {
                teams.add(game.matchmaker.playerInTeam.get(player));
            }
        }

        return teams.get(0);
    }

    public boolean isTeamDead(TeamColor team) {
        List<Player> players = new ArrayList<>();

        for (Player player : game.matchmaker.getPlayersInTeam(team)) {
            if (game.livingPlayers.contains(player)) {
                players.add(player);
            }
        }

        return players.isEmpty();
    }
}