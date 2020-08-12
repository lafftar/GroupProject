package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This models the each individual player deck which store cards in an array.
 * The PlayerDeck class has the ability to add cards, get cards from a specific 
 * index  and remove all cards from the deck.
 * 
 * @author Bryan Acorda
 */
public class PlayerDeck extends GroupOfCards {

    /**
    * Constructs a PlayerDeck object with 26 cards of type WarCard.
    *
    */
    public PlayerDeck() {
        super(26);
    }

    /**
    * Constructs a Playerdeck arrayList with a programmer-specified size.
    *
    * @param size of arrayList
    */
    public PlayerDeck(int size) {
        super(size);
    }

    /**
    * Returns the cards of the PlayerDeck.
    * 
    * @return the super class getCards()
    */
    public ArrayList<WarCard> getPlayerDeck() {
        return super.getCards();
    }

    /**
    * Removes all cards from the player's deck.
    *
    */
    public void wipePlayerDeck() {
        ArrayList<WarCard> playerDeckCards = this.getPlayerDeck();
        Iterator<WarCard> iterator = playerDeckCards.iterator();
        while (iterator.hasNext()) {
            WarCard check = iterator.next();
            iterator.remove();
        }

    }

  
    /**
     * Adds a specified WarCard to the player deck.
     *
     * @param WaraCard card
     */
    public void addCardToPlayerDeck(WarCard card) {
        super.getCards().add(card);
    }

    /**
     * Returns the card at the specific index.
     *
     * @param cardIndex
     * @return the specific war card
     */
    public WarCard getCardFromDeck(int cardIndex) {
        return super.getCards().get(cardIndex);
    }

    /**
    * Retrieves the size of the player's deck.
    *
    * @return size of deck
    */
    @Override
    public int getSize() {
        return super.getCards().size();
    }

}
