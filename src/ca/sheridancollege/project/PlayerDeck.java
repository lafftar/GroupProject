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
     * @param card
     */
    public void addCardToPlayerDeck(Card card) {
        this.playerDeck.add(card);
    }

    /**
     * Returns the card at the specific index
     *
     * @param cardIndex
     * @return the specific war card
     */
    public Card getCardFromDeck(int cardIndex) {
        return this.playerDeck.get(cardIndex);
    }

}
