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
public class main {

    public static void main(String[] args) {

        try {
            WarDeck deck = new WarDeck(52);
            deck.getCards();

//        for (Card cards : deck.getCards()) {
//            System.out.println(cards);
//        }
            PlayerDeck p1 = new PlayerDeck(26);
            PlayerDeck p2 = new PlayerDeck(26);

            p1.setPlayerDeck(deck.getCards());
            p2.setPlayerDeck(deck.getCards());

            System.out.println("Player 1: ");
            for (Card card : p1.getPlayerDeck()) {
                System.out.println(card);
            }

            System.out.println("");

            System.out.println("Player 2: ");
            for (Card card : p2.getPlayerDeck()) {
                System.out.println(card);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
