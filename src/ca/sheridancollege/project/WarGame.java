package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;

public class WarGame extends Game {

    private WarPlayer player1;
    private WarPlayer player2;
    private PlayerDeck placeholderDeck; // deck to hold cards that are discarded in the war round

    public WarPlayer getPlayer1() {
        return this.player1;
    }

    /**
     *
     * @param player1
     */
    public void setPlayer1(WarPlayer player1) {
        this.player1 = player1;
    }

    public WarPlayer getPlayer2() {
        return this.player2;
    }

    /**
     *
     * @param player2
     */
    public void setPlayer2(WarPlayer player2) {
        this.player2 = player2;
    }

    public PlayerDeck getWarDeck() {
        return this.placeholderDeck; // just assuming, confirm
    }

    /**
     *
     * @param warDeck
     */
    public void setWarDeck(PlayerDeck warDeck) {
        this.placeholderDeck = warDeck; // just assuming, confirm
    }

    /**
     * compares two war cards return true if they are the same return false if
     * they are different
     *
     * @param card1
     * @param card2
     * @return true if card values have same rank and suit, false otherwise
     */
    public boolean compareCards(WarCard card1, WarCard card2) {
        return card1.equals(card2);
    }

    /**
     * initiates war takes out 4 cards from the playerDeck puts the first 3 in
     * the placeholder deck returns the last card
     *
     * @return
     */
    public WarCard war() {
        return new WarCard(Suit.CLUBS, Rank.EIGHT); // just for testing, DELETE
    }

    /**
     * retrieves the set of cards that are discarded during the war round - the
     * winner's pile of cards
     */
    public PlayerDeck getPlaceholderDeck() {
        return this.placeholderDeck;
    }

    /**
     * the extra cards from the war round are added to the placeholder deck
     *
     * @param placeholderDeck
     */
    public void addToPlaceholderDeck(PlayerDeck placeholderDeck) {
        // TODO - implement WarGame.addToPlaceholderDeck
        throw new UnsupportedOperationException();
    }

    @Override
    public void declareWinner() {

    }

    @Override
    public void play() {
        /* First Round:
                both players deal: take one card from each player, put it in the placeholder

         */

    }

}
