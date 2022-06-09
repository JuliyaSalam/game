package ru.netology;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Game {
  /*  public HashMap<String, Player> playerHashMap() {

        return new HashMap<>();
    }*/

    private Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        this.players.add(player);
    }

    public Collection<Player> findAll() {
        return players;
    }

  /*  public void deleteById(int id) {
        this.players.removeIf(element -> element.getId() == id);
    }*/

    public int round(String playerName1, String playerName2) {
        var player1 = findByName(playerName1);
        var player2 = findByName(playerName2);
        if (player1 == null || player2 == null) {
            throw new NotFoundException("Один из игроков с именами " + playerName1 + ", " + playerName2 + " не зарегистрирован!!!");
        } else {
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            }
            if (player1.getStrength() < player2.getStrength()) {
                return 2;
            } else {
                return 0;
            }
        }
    }

    public Player findByName(String player1) {
        for (Player player : players) {
            if (player.getName().equals(player1)) {
                return player;
            }
        }
        return null;
    }
}
