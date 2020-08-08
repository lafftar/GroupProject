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

        GroupOfCards deck = new GroupOfCards(52);
        deck.getCards();

        for (Card cards : deck.getCards()) {
            System.out.println(cards);
        }

    }
}
