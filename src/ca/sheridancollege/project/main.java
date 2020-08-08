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

        WarDeck deck = new WarDeck(52);

        PlayerDeck p1 = new PlayerDeck(26);
        PlayerDeck p2 = new PlayerDeck(26);

        for (int i = 0; i < p1.getSize(); i++) {
            p1.addCardsToPlayerDeck(deck.getCards().get(i));
            deck.getCards().remove(0);
        }
        
//        for (int i = 0; i < p1.getSize(); i++) {
//            p2.addCards(deck.getCards().get(i));
//            deck.getCards().remove(i);
//        }
        
        System.out.println("Player 1 Deck: ");
        for (Card card : p1.getPlayerDeck()) {
            System.out.println(card);
        }
        
//        System.out.println("\n\n");
//        System.out.println("Player 2 Deck: ");
//        for (Card card : p2.getPlayerDeck()) {
//            System.out.println(card);
//        }
        
        

       
        
        System.out.println("\nNumber of cards in main Deck: ");
        System.out.println(deck.getCards().size());
        
        System.out.println("\nNumber of cards in player1 deck:");
        System.out.println(p1.getPlayerDeck().size());
        
        System.out.println("\nNumber of cards in player2 deck:");
        System.out.println(p2.getPlayerDeck().size());
    }
}
