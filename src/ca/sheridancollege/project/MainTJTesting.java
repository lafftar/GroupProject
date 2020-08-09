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
public class MainTJTesting {

    public static void main(String[] args) {
        WarGame warGame = new WarGame("War");
        warGame.play();

        /*
        When playerdeck is initilized, it inherits 52 cards from WarGroupOfCards,
also, even though playerdeck is initilized with 26 cards, it has a size of 0. When WarPlayer is initlized, it inherits
         */
        // WarPlayer is supposed to get init with a player deck, with an arraylist size of 26
//        PlayerDeck playerDeckObj = new PlayerDeck();
//        System.out.println(playerDeckObj.getPlayerDeck().size());
//        WarPlayer warPlayerObj = new WarPlayer("War Player 1");
//        System.out.println(warPlayerObj);
    }

}
