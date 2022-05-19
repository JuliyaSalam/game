package ru.netology;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

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
        var player1 = findByName1(playerName1);
        var player2 = findByName2(playerName2);
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

    public Player findByName1(String playerName1) {
        for (Player player : players) {
            if (player.getName() == playerName1) {
                return player;
            }
        }
        return null;
    }

    public Player findByName2(String playerName2) {
        for (Player player : players) {
            if (player.getName() == playerName2) {
                return player;
            }
        }
        return null;
    }
}
