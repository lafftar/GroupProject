package ca.sheridancollege.project;

import java.util.*;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 *
 * the Game constructor is protected so it can only be instantiated by it's
 * child class, WarGame
 * @author Ashley Sun, Aug 2020
 *
 */
public abstract class Game {

    private final String name;
    /**
     * the title of the game
     */
    private Collection<Player> players;

    public String getName() {
        return this.name;
    }

    public Collection<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    /**
     * the players of the game
     *
     * @param name
     */
    protected Game(String name) {
        // TODO - implement Game.Game
        throw new UnsupportedOperationException();
    }

    /**
     * Play the game. This might be one method or many method calls depending on
     * your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();

}
