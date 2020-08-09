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
    private PlayerDeck placeholderDeck = new PlayerDeck(0); // deck to hold cards that are discarded in the war round

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
        // this will need to be nested further, to have support for continious play
        while (this.player1.getDeck().getSize() > 0 && this.player2.getDeck().getSize() > 0) {
            // start game
//         both players deal
            WarCard player1Card = this.player1.drawCard();
            WarCard player2Card = this.player2.drawCard();
            // need to replace these 'Player 1' with the player names.
            System.out.println("Player 1 Drew: " + player1Card);
            System.out.println("Player 2 Drew: " + player2Card);
            // deal the first cards,
            // place it in the placeholder deck
            // remove the cards from each players deck.
            // compare the cards

            // take 1 card from  each player, add to placeholder deck
            this.placeholderDeck.addCardToPlayerDeck(player1Card);
            this.placeholderDeck.addCardToPlayerDeck(player2Card);
            // might benefit from having a remove card method for the player
            // remove the card we just drew from each player
            this.player1.getDeck().getPlayerDeck().remove(player1Card);
            this.player2.getDeck().getPlayerDeck().remove(player2Card);
            // while war is declared, we want the methods above to loop twice.
            // this loop will only be entered when war is declared from first play, which is obvs the only time war can be declared
            while (this.compareCards(player1Card, player2Card) == 3) {
                System.out.println("War has been initiated!!!");
                for (int i = 0; i < 2; i++) {
                    player1Card = this.player1.drawCard();
                    player2Card = this.player2.drawCard();
                    if (i == 1) {
                        // WarCard might need a better toString()
                        System.out.println("Player 1 Drew: " + player1Card);
                        System.out.println("Player 2 Drew: " + player2Card);
                    }
                    // take 1 card from  each player, add to placeholder deck
                    this.placeholderDeck.addCardToPlayerDeck(player1Card);
                    this.placeholderDeck.addCardToPlayerDeck(player2Card);
                    // might benefit from having a remove card method for the player
                    // remove the card we just drew from each player
                    this.player1.getDeck().getPlayerDeck().remove(player1Card);
                    this.player2.getDeck().getPlayerDeck().remove(player2Card);
                }
            }
            // super repetitive, DRY distributeWinnings()?
            if (this.compareCards(player1Card, player2Card) == 2) { // player 2 won
                // player 2 will have all cards in placeholder deck added to the bottom of his pile.
                // place holder deck will be wiped.
                System.out.println(String.format("Player %d Wins! They get %d cards",
                        this.compareCards(player1Card, player2Card), this.placeholderDeck.getSize()));
                for (WarCard card : this.placeholderDeck.getCards()) {
                    this.player2.getDeck().addCardToPlayerDeck(card);
                }
                this.placeholderDeck.getCards().removeAll(this.player2.getDeck().getCards());
                // the .getSize() method only returns the size of the class at initialization, not while it's moving
                // i've overridden the method in playerdeck
                System.out.println(String.format("Player 1 Now Has %d cards", this.player1.getDeck().getSize()));
                System.out.println(String.format("Player 2 Now Has %d cards", this.player2.getDeck().getSize()));
            }
            if (this.compareCards(player1Card, player2Card) == 1) { // player 1 won
                // player 1 will have all cards in placeholder deck added to the bottom of his pile.
                // place holder deck will be wiped.
                System.out.println(String.format("Player %d Wins! They get %d cards",
                        this.compareCards(player1Card, player2Card), this.placeholderDeck.getSize()));
                for (WarCard card : this.placeholderDeck.getCards()) {
                    this.player1.getDeck().addCardToPlayerDeck(card);
                }
                this.placeholderDeck.getCards().removeAll(this.player1.getDeck().getCards());
                System.out.println(String.format("Player 1 Now Has %d cards", this.player1.getDeck().getSize()));
                System.out.println(String.format("Player 2 Now Has %d cards", this.player2.getDeck().getSize()));
            }
        }

    }

}
