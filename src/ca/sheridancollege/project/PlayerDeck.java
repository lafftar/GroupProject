package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * @author OtherUser
 */
public class PlayerDeck extends GroupOfCards {

    int playerDeckSize = 26;
    private ArrayList<Card> playerDeck;
    private String nameOfDeck;

    public PlayerDeck(int size) {
        super(size);
    }
   
    public ArrayList<Card> getPlayerDeck() {
        return this.playerDeck;
    }

    /**
     *
     * @param playerDeck
     */
    public void setPlayerDeck(ArrayList<Card> playerDeck) {
        this.playerDeck = playerDeck;
    }

    public String getNameOfDeck() {
        return this.nameOfDeck;
    }

    /**
     *
     * @param njameOfDeck
     */
    public void setNameOfDeck(String njameOfDeck) {
        this.nameOfDeck = njameOfDeck;
    }

}
