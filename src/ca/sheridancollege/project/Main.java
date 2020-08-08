/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import ca.sheridancollege.project.Rank;

/**
 *
 * @author lafftar
 */
public class Main {

    public static void main(String[] args) {
//        WarGroupOfCards allCards = new WarGroupOfCards(52);
        GroupOfCards allCards = new GroupOfCards(52);
        ArrayList<Card> cards = allCards.getCards();
//        System.out.println(cards);
        System.out.println(Rank.EIGHT);
//        cards.add(Card(1));
//        System.out.println(allCards.getCards());
//        for (Suit suit : Suit.values()) {
//            System.out.println(String.format("Ace %s", suit));
//            for (int i = 2; i <= 10; i++) {
//                System.out.println(String.format("%d %s", i, suit));
//            }
//            System.out.println(String.format("King %s", suit));
//            System.out.println(String.format("Queen %s", suit));
//            System.out.println(String.format("Jack %s", suit));
//            System.out.println("-------------------------------------------------------------");
//        }

    }

}
