/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author OtherUser
 */
public class WarGroupOfCards extends GroupOfCards {

    public WarGroupOfCards() {
        super(52);
        this.assembleCards();
        super.shuffle();
    }

    private void assembleCards() { // changed to private because it shouldn't be used elsewhere - TJ
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

    // ashley - added back the removeCards() method because i need it in 
    // WarGame class play() and edit to take from index
    /**
     * This removes card from the index.
     *
     * @param deck
     * @param index
     */
    public void removeCardsFromDeck(ArrayList<WarCard> deck, int index) {
        deck.remove(index);
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
