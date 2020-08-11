
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author OtherUser
 */
public class WarGroupOfCards extends GroupOfCards {

    /**
    * Creates a WarGroupOfCards object with 52 WarCards.
    * It is assembled with WarCards and shuffled.
    */
    public WarGroupOfCards() {
        super(52);
        this.assembleCards();
        super.shuffle();
    }

    // assembleCards() method is private because it shouldn't be used elsewhere - TJ
    private void assembleCards() { 
        
        // Create a reference for WarCard. -Bryan
        WarCard card;
        
        // Assembling the deck from the cards created in the Card class
        for (Suit suit : Suit.values()) {
            
            for (Rank rank : Rank.values()) {
                // initialized the card variable here -Bryan
                card = new WarCard(suit, rank);
                
                // would make sense to put the reference outside the for loop for performance sake - TJ
                this.getCards().add(card);
            }
        }
    }

    /**
     * This method deals the mainDeck to the player's deck.
     *
     * @param players
     *
     */
    // I just removed the main deck param, because it's always taking from its own deck
    public void dealToPlayerDeck(ArrayList<WarPlayer> players) {
        ArrayList<WarCard> allCards = this.getCards(); // reduces calls to the .getCards() method
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 26; j++) {
                // grabs the first player deck, adds a card from allCards to that player deck. 26 cards per deck
                players.get(i).getDeck().addCardToPlayerDeck(allCards.get(j));
            }
            // removes all the cards we just added to the player deck, from allCards
            allCards.removeAll(players.get(i).getDeck().getCards());
        }
    }

}
