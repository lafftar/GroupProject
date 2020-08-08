package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * @author OtherUser
 */
public class PlayerDeck extends WarGroupOfCards {

    private ArrayList<Card> playerDeck = new ArrayList(26);
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

    /**
     * 
     * @return 
     */
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
    
    /**
     * 
     * 
     */
    public void addCardsToPlayerDeck(Card card) {
        this.playerDeck.add(card);
    }
    
    
}
