/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author OtherUser
 */
public final class WarDeck extends GroupOfCards {
    
    public WarDeck(int size) {
        super(size);
        assembleCards();
    }
    
    public void assembleCards() {
        // Assembling the deck from the cards created in the Card class 
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.getCards().add(new WarCard(rank, suit));
            }
        }
    }
    
}
