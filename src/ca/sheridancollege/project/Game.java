/**
 * SYST 17796 Project Base code.
 * 
 * Date: 06-09-2020
 * @Author Bryan Acorda
 * Group 3
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 * 
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * 
 * the Game constructor is protected so it can only be instantiated by it's child class, WarGame
 * @author Ashley Sun, Aug 2020
 *  
 */
public abstract class Game {

    private final String name;//the title of the game
    private ArrayList<Player> players;/**
     * the players of the game
     * @param name
     */

    protected Game(String name) {
        this.name = name;
        players = new ArrayList();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

}//end class
