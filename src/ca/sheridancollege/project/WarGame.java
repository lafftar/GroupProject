package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.Random;
import java.util.Scanner;

public class WarGame extends Game {

    private WarGroupOfCards allCards = new WarGroupOfCards();
    private WarPlayer player1 = new WarPlayer("Player 1");
    private WarPlayer player2 = new WarPlayer("Player 2");
    private PlayerDeck placeholderDeck = new PlayerDeck(52); // deck to hold cards that are discarded in the war round

    public WarGame(String name) {
        super(name);
    }

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
    public int compareCards(WarCard card1, WarCard card2) {
        // 1 if card 1 is greater
        // 2 if card 2 is greater
        // 3 if they're equal
        if (card1.getRank().getRankNumber() > card2.getRank().getRankNumber()) {
            return 1;
        }
        if (card1.getRank().getRankNumber() < card2.getRank().getRankNumber()) {
            return 2;
        }
        return 3;
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
                - both players deal: take one card from each player, put it in the placeholder
                - compare cards, whoever has the highest card gets the playerDeck

         */
//        Scanner in = new Scanner(System.in);
        // collect info about both players

//        System.out.print("Player 1 Name: ");
//        this.setPlayer1(new WarPlayer(in.nextLine()));
//        System.out.print("Player 2 Name: ");
//        this.setPlayer2(new WarPlayer(in.nextLine()));
//        System.out.println(this.player1.getName());
//        System.out.println(this.player2.getName());
        // need to shuffle the deck and distribute the cards from wargroupofcards
        // first we create the wargroupofcards, it's created, assembled and shuffled in the wargroupofcards class
//        WarGroupOfCards allCards = new WarGroupOfCards();
        allCards.dealToPlayerDeck(new ArrayList<>(asList(this.player1, this.player2)));

        // start game
//         both players deal
        WarCard card1 = new WarCard(Suit.DIAMONDS, Rank.NINE);
        WarCard card2 = new WarCard(Suit.CLUBS, Rank.NINE);
        card1 = this.player1.drawCard();
        card2 = this.player2.drawCard();
        System.out.println("Player 1 Drew: " + card1);
        System.out.println("Player 2 Drew: " + card2);
        // deal the first cards,
        // place it in the placeholder deck
        // remove the cards from each players deck.
        // compare the cards

        // take 1 card from  each player, add to placeholder deck
        this.placeholderDeck.addCardToPlayerDeck(card1);
        this.placeholderDeck.addCardToPlayerDeck(card2);
        // might benefit from having a remove card method for the player
        // remove the card we just drew from each player
        this.player1.getDeck().getPlayerDeck().remove(card1);
        this.player2.getDeck().getPlayerDeck().remove(card2);
        // while war is declared, we want the methods above to loop twice.
        // this loop will only be entered when war is declared from first play, which is obvs the only time war can be declared
        while (this.compareCards(card1, card2) == 3) {
            System.out.println("War has been initiated!!!");
            for (int i = 0; i < 2; i++) {
                card1 = this.player1.drawCard();
                card2 = this.player2.drawCard();
                if (i == 1) {
                    System.out.println("Player 1 Drew: " + card1);
                    System.out.println("Player 2 Drew: " + card2);
                }
                // take 1 card from  each player, add to placeholder deck
                this.placeholderDeck.addCardToPlayerDeck(card1);
                this.placeholderDeck.addCardToPlayerDeck(card2);
                // might benefit from having a remove card method for the player
                // remove the card we just drew from each player
                this.player1.getDeck().getPlayerDeck().remove(card1);
                this.player2.getDeck().getPlayerDeck().remove(card2);
            }
        }
        // super repetitive, DRY distributeWinnings()?
        if (this.compareCards(card1, card2) == 2) { // player 2 won
            // player 2 will have all cards in placeholder deck added to the bottom of his pile.
            // place holder deck will be wiped.
            System.out.println(String.format("Player %d Wins! They get %d cards",
                    this.compareCards(card1, card2), this.placeholderDeck.getSize()));
            for (WarCard card : this.placeholderDeck.getCards()) {
                this.player2.getDeck().addCardToPlayerDeck(card);
            }
            this.placeholderDeck.getCards().removeAll(this.player2.getDeck().getCards());
            System.out.println(String.format("Player 1 Now Has %d cards", this.player1.getDeck().getSize()));
            System.out.println(String.format("Player 2 Now Has %d cards", this.player2.getDeck().getSize()));
        }
        if (this.compareCards(card1, card2) == 1) { // player 1 won
            // player 1 will have all cards in placeholder deck added to the bottom of his pile.
            // place holder deck will be wiped.
            for (WarCard card : this.placeholderDeck.getCards()) {
                this.player1.getDeck().addCardToPlayerDeck(card);
            }
            this.placeholderDeck.getCards().removeAll(this.player1.getDeck().getCards());
        }
        System.out.println(this.compareCards(card1, card2));
    }

}
