/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author OtherUser
 */
public class WarGroupOfCards extends GroupOfCards {

    public WarGroupOfCards(int size) {
        super(size);
        assembleCards();
//        shuffle();
    }

    public void assembleCards() {
        // Assembling the deck from the cards created in the Card class 
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.getCards().add(new WarCard(suit, rank));
            }
        }
    }

    /**
     * This removes card from the index of
     *
     */
    public void removeCardsFromDeck(ArrayList<Card> deck) {
        deck.remove(0);
    }

    /**
     * This method deals the mainDeck to the player's deck.
     * 
     * @param mainDeck
     * @param p 
     */
    public void dealToPlayerDeck(ArrayList<Card> mainDeck, PlayerDeck p) {
        // Add 26 cards to player deck
        for (int i = 0; i < p.getSize(); i++) {
            p.addCardToPlayerDeck(this.getCards().get(i));
        }

        // Remove the same 26 cards from main deck
        for (int i = 0; i < p.getSize(); i++) {
            removeCardsFromDeck(mainDeck);
        }
    }

}