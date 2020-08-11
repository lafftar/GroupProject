package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author OtherUser
 */
public class PlayerDeck extends GroupOfCards {

    /**
    * Constructs a GroupOfCards with 26 WarCards.
    */
    public PlayerDeck() {
        super(26);
    }

    public PlayerDeck(int size) {
        super(size);
    }

    /**
    * Returns the cards of the PlayerDeck.
    */
    public ArrayList<WarCard> getPlayerDeck() {
        return super.getCards();
    }

    /**
    * Removes all cards from the player's deck.
    */
    public void wipePlayerDeck() {
        ArrayList<WarCard> playerDeckCards = this.getPlayerDeck();
        Iterator<WarCard> iterator = playerDeckCards.iterator();
        while (iterator.hasNext()) {
            WarCard check = iterator.next();
            iterator.remove();
        }

    }

    //removed the commented out setPlayerDeck(ArrayList<WarCard> playerDeck)
  
    /**
     * Adds a specified WarCard to the player deck.
     *
     * @param card
     */
    public void addCardToPlayerDeck(WarCard card) {
        super.getCards().add(card);
    }

    /**
     * Returns the card at the specific index
     *
     * @param cardIndex
     * @return the specific war card
     */
    public WarCard getCardFromDeck(int cardIndex) {
        return super.getCards().get(cardIndex);
    }

    @Override
    public int getSize() {
        return super.getCards().size();
    }

}
