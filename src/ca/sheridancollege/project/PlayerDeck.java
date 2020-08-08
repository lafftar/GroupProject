package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * @author OtherUser
 */
public class PlayerDeck extends WarDeck {

    private ArrayList<Card> playerDeck;
    private String nameOfDeck;

    public PlayerDeck(int size) {
        super(size);
        playerDeck = new ArrayList(this.getSize());
    }
   
    public ArrayList<Card> getPlayerDeck() {
        return this.playerDeck;
    }
    
    /**
     *
     * @param playerDeck
     */
    public void setPlayerDeck(ArrayList<Card> cards) {
        
        for (Card card : cards) {
            playerDeck.add(card);
            cards.remove(card);
        }
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
