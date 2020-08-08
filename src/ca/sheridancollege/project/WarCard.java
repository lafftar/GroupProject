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
public class WarCard extends Card {
    
    private Suit suit;
    private Rank rank;

    public WarCard(Rank r, Suit s) {
        rank = r;
        suit = s;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }   
   
    @Override
    public String toString() {
        return this.getRank() + " of " + this.getSuit();
    }
}
