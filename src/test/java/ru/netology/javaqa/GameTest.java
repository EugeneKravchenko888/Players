package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void testRoundFirstWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Harald", 800);
        Player player2 = new Player(2, "Astrid", 500);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Harald", "Astrid");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundSecondWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Harald", 80);
        Player player2 = new Player(2, "Astrid", 500);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Harald", "Astrid");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundNoOneWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Harald", 80);
        Player player2 = new Player(2, "Astrid", 80);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Harald", "Astrid");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundNoPlayer2() {
        Game game = new Game();
        Player player1 = new Player(1, "Harald", 80);
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Harald", "Astrid");
        });
    }

    @Test
    public void testRoundNoPlayer1() {
        Game game = new Game();
        Player player2 = new Player(2, "Astrid", 80);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Harald", "Astrid");
        });
    }

    @Test
    public void testRoundNoPlayers() {
        Game game = new Game();
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Harald", "Astrid");
        });
    }
}