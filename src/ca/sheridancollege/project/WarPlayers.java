/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author purvp
 */
public class WarPlayers extends Player {
    private String player1;
    private String player2;

    public WarPlayers(String player1, String player2, String name) {
        super(name);
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    @Override
    public void play() {
       
    }
    
}
