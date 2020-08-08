/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author lafftar
 */
public class WarGroupOfCards extends GroupOfCards {

    public WarGroupOfCards(int size) {
        super(size);
    }

    public void generateCards() {
        ArrayList<Card> cards = super.getCards(); // reference to all the cards in group of cards
        for (Suit suit : Suit.values()) {
            cards.add(String.format("Ace %s", suit));
            System.out.println(String.format("Ace %s", suit));
            for (int i = 2; i <= 10; i++) {
                System.out.println(String.format("%d %s", i, suit));
            }
            System.out.println(String.format("King %s", suit));
            System.out.println(String.format("Queen %s", suit));
            System.out.println(String.format("Jack %s", suit));
            System.out.println("-------------------------------------------------------------");
        }
    }
}
