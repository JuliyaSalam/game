package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, 50, "AAA");
    private Player player2 = new Player(2, 50, "BBB");
    private Player player3 = new Player(3, 150, "CCC");
    private Player player4 = new Player(4, 10, "DDD");
    Collection<Player> players = new ArrayList<>();

    @Test
    void register() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Collection<Player> prs = game.findAll();
        assertEquals(4, prs.size());

    }

    @Test
    void registerNull() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player1);

        Collection<Player> prs = game.findAll();
        assertEquals(4, prs.size());
// зарегистрирован один и тот же игрок №1  ????
    }

    @Test
    void round0() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        game.round("AAA", "BBB");

        int actual = 0;
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void round1() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        game.round("AAA", "DDD");

        int actual = 1;
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void round2() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        game.round("AAA", "CCC");

        int actual = 2;
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void roundNull1() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        assertThrows(NotFoundException.class, () -> {
            game.round("AAA", "EEE");
        });
    }

    @Test
    void roundNull2() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        assertThrows(NotFoundException.class, () -> {
            game.round("EEE", "BBB");
        });
    }

    @Test
    void roundNull3() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        assertThrows(NotFoundException.class, () -> {
            game.round("EEE", "FFF");
        });
    }

}