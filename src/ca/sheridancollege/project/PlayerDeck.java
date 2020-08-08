package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * @author OtherUser
 */
public class PlayerDeck extends WarGroupOfCards {

    private ArrayList<Card> playerDeck = new ArrayList(26);
    private String nameOfDeck;

    public PlayerDeck(int size, String nameOfDeck) {
        super(size);
        this.nameOfDeck = nameOfDeck;
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

    /**
     * 
     * @return 
     */
    public String getNameOfDeck() {
        return this.nameOfDeck;
    }

    /**
     *
     * @param nameOfDeck
     */
    public void setNameOfDeck(String nameOfDeck) {
        this.nameOfDeck = nameOfDeck;
    }
    
    /**
     * 
     * 
     */
    public void addCardsToPlayerDeck(Card card) {
        this.playerDeck.add(card);
    }
    
    public String toString() {
        return this.getNameOfDeck() + "";
    }
    
}
