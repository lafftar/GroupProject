
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class models the GroupOfCards for the game War, it extends the
 * GroupOfCards class and adds the ability to assemble cards from the Suit and
 * Rank enums and also deal cards to each player.
 *
 * @author Bryan Acorda
 */
public class WarGroupOfCards extends GroupOfCards {

    /**
    * This constructor creates a WarGroupOfCards object with 52 WarCards.
    * It is assembled with WarCards and then shuffled.
    */
    public WarGroupOfCards() {
        super(52);
        this.assembleCards();
        super.shuffle();
    }

    // assembleCards() method is private because it shouldn't be used elsewhere
    private void assembleCards() { 
        
        // Create a reference for WarCard
        WarCard card;
        
        // Assembling the deck from the cards created in the Card class
        for (Suit suit : Suit.values()) {
            
            for (Rank rank : Rank.values()) {
                // initialized the card variable
                card = new WarCard(suit, rank);
                
                // adds new WarCard to the deck
                this.getCards().add(card);
            }
        }
    }

    /**
     * This method deals the mainDeck to the player's deck.
     *
     * @param players array list of each player
     *
     */
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
