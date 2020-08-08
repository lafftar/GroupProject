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

        // Create a main playing deck
        WarGroupOfCards deck = new WarGroupOfCards(52);
        // shuffle
        
        System.out.println("This is the main deck");
        System.out.println("The main deck has " + deck.getCards().size() + " cards");
        System.out.println("");
        
        for (Card card : deck.getCards()) {
            System.out.println(card);
        }

        System.out.println("\n\nNow we are going to evenly distribute those cards"
                + "to each player\n");
        
        // Create objects of both players
        String name1 = "Player1";
        String name2 = "Player12";
        PlayerDeck p1 = new PlayerDeck(26, name1);
        PlayerDeck p2 = new PlayerDeck(26, name2);
        
        deck.dealToPlayerDeck(deck.getCards(), p1);
        deck.dealToPlayerDeck(deck.getCards(), p2);

        
        System.out.println("Player 1 Deck: ");
        for (Card card : p1.getPlayerDeck()) {
            System.out.println(card);
        }
        
        System.out.println("\n\n");
        
        System.out.println("Player 2 Deck: ");
        for (Card card : p2.getPlayerDeck()) {
            System.out.println(card);
        }
        
        

       
        
        System.out.println("\nNumber of cards in main Deck: ");
        System.out.println(deck.getCards().size());
        
        System.out.println("\nNumber of cards in player1 deck:");
        System.out.println(p1.getPlayerDeck().size());
        
        System.out.println("\nNumber of cards in player2 deck:");
        System.out.println(p2.getPlayerDeck().size());
    }
}
