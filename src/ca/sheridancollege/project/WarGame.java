package ca.sheridancollege.project;

import java.util.*;
import static java.util.Arrays.asList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WarGame extends Game {

    private WarPlayer player1 = new WarPlayer("Player 1");
    private WarPlayer player2 = new WarPlayer("Player 2");
    private PlayerDeck placeholderDeck = new PlayerDeck(0); // deck to hold cards that are discarded in the war round
    ArrayList<WarPlayer> player = new ArrayList(asList(player1, player2)); // Store each player
    ArrayList<WarCard> playerCards;
    // for some reason, changing the object in .warInitiated() doesn't change the object outside, so i'm making this global
    private WarCard player1Card;
    private WarCard player2Card;

    // allows us to declare gameOver in warInitiated and have it carry over to the distributeWinnings() method
    private boolean gameOver = false;
    // allows us to stop the game after 1000 rounds have been played, and declare the player with most cards the winner
    private int numRounds = 0;

    // trying to fix
    public WarGame(String name) {
        super(name);
    }

    // don't think we need any of these public classes, all game logic should be private, as no other classes use this.
    // Outside of the constructor and .play() - TJ
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
     * Compares two War Cards based on their rank and returns 1 - if card 1 is
     * greater 2 - if card 2 is greater 3 - if they are the same.
     *
     * @param card1
     * @param card2
     */
    public int compareCards(WarCard card1, WarCard card2) {

//         1 if card 1 is greater
//         2 if card 2 is greater
//         3 if they're equal
        // Yeah... I changed these values to 0,1,2. This way the ArrayList for
        // distributeWinnings() method could work -Bryan
        if (card1.getRank().getRankNumber() > card2.getRank().getRankNumber()) {
            return 0;
        }
        if (card1.getRank().getRankNumber() < card2.getRank().getRankNumber()) {
            return 1;
        }
        return 2;
    }

    private WarPlayer returnPlayerWithLowerCards() {
        if (player.get(0).getDeck().getSize() < player.get(1).getDeck().getSize()) {
            return player.get(0);
        }
        return player.get(1);
    }

    /**
     * Initiates war takes out 4 cards from the playerDeck puts the first 3 in
     * the placeholder deck returns the last card.
     *
     * @return
     */
    public void warInitiated() {

        // Store in array
        boolean atWar = this.compareCards(this.player1Card, this.player2Card) == 2;

        // while war is declared, we want the methods above to loop twice.
        // This loop will only be entered when war is declared from first play,
        // which is the only time war can be declared
        while (atWar && !this.gameOver && this.numRounds < 999) {
            if ((this.player1.getDeck().getSize() < 2 || this.player2.getDeck().getSize() < 2) && atWar) {
                this.gameOver = true;
                System.out.println(String.format("War has been initiated, but Player '%s' has less than 2 cards! "
                        + "They cannot afford to go to war!", this.returnPlayerWithLowerCards().getName()));
                break;
            }
            // Changed the comparing number to 2 -Bryan
            System.out.println("War has been initiated!!!");
            for (int i = 0; i < 2; i++) {

                this.player1Card = this.player1.drawCard();
                this.player2Card = this.player2.drawCard();

                System.out.println(String.format("Player '%s' Drew: %s", this.player1.getName(), this.player1Card));
                System.out.println(String.format("Player '%s' Drew: %s", this.player2.getName(), this.player2Card));

                // take 1 card from  each player, add to placeholder deck
                this.placeholderDeck.addCardToPlayerDeck(this.player1Card);
                this.placeholderDeck.addCardToPlayerDeck(this.player2Card);

                // remove the card we just drew from each player
                this.player1.getDeck().getPlayerDeck().remove(this.player1Card);
                this.player2.getDeck().getPlayerDeck().remove(this.player2Card);

                this.incrementNumRounds();
            }
            atWar = this.compareCards(this.player1Card, this.player2Card) == 2;
        }

    }

    /**
     * Retrieves the set of cards that are discarded during the war round - the
     * winner's pile of cards.
     *
     * @return PlayerDeck
     */
    public PlayerDeck getPlaceholderDeck() {
        return this.placeholderDeck;
    }

    /**
     * The extra cards from the war round are added to the placeholder deck
     *
     * @param placeholderDeck
     */
    public void addToPlaceholderDeck(PlayerDeck placeholderDeck) {
        // TODO - implement WarGame.addToPlaceholderDeck
//        throw new UnsupportedOperationException();

    }

    /**
     * This method handles distribution of cards when a player wins a round
     *
     */
    public void distributeWinnings() {

        // as long as the game is not over, distribute winnings
        // announce the winner of the hand, as well as how many cards they get
        // add all cards from placeholder deck to the winning player deck
        // wipe placeholder deck
        // announce the number of cards each player now holds
        if (!this.gameOver) {
            if (this.compareCards(this.player1Card, this.player2Card) == 0) { // player 1 wins
                System.out.println(String.format("Player '%s' Wins! They get %d cards", // cards/card fix - TO DO
                        this.player1.getName(), this.placeholderDeck.getSize() / 2));
                for (WarCard card : this.placeholderDeck.getCards()) {
                    this.player1.getDeck().addCardToPlayerDeck(card);
                }
            }
            if (this.compareCards(this.player1Card, this.player2Card) == 1) { // player 2 wins
                System.out.println(String.format("Player '%s' Wins! They get %d cards",
                        this.player2.getName(), this.placeholderDeck.getSize() / 2));
                for (WarCard card : this.placeholderDeck.getCards()) {
                    this.player2.getDeck().addCardToPlayerDeck(card);
                }
            }
            this.placeholderDeck.wipePlayerDeck();
        }
        System.out.println(String.format("%s now has %d cards",
                this.player1.getName(), this.player1.getDeck().getSize()));
        System.out.println(String.format("%s now has %d cards",
                this.player2.getName(), this.player2.getDeck().getSize()));

    }

    /**
     * This method declares a winner and increments the winning score of each
     * player
     *
     */
    @Override
    public void declareWinner() {

        // Put these here to clean up the conditions a bit
        int p1Condition = this.player1.getDeck().getPlayerDeck().size();
        int p2Condition = this.player2.getDeck().getPlayerDeck().size();

        // changing this to declare winner on the person with the most cards
        // instead
        if (p1Condition > p2Condition) {
            System.out.println("\n" + this.player1.getName() + " Wins!");
            this.player1.setWins(this.player1.getWins() + 1);
            this.player2.setLosses(this.player2.getLosses() + 1);

        } else if (p1Condition == p2Condition) {
            System.out.println("\nBoth players have the same number of cards! "
                    + "You both get a win!");
            this.player1.setWins(this.player1.getWins() + 1);
            this.player2.setWins(this.player2.getWins() + 1);
        } else {
            System.out.println("\n" + this.player2.getName() + " Wins!");
            this.player2.setWins(this.player2.getWins() + 1);
            this.player1.setLosses(this.player1.getLosses() + 1);
        }

        // Created a score ouput for each player, it doesn't work accurately as
        // this is just a test. -Bryan
        String outputScore = String.format("\nGame Stats:\nPlayers : Wins : Losses\n%s : %s\n%s : %s",
                this.player1.getName(), this.player1.getStats(), this.player2.getName(), this.player2.getStats());
        System.out.println(outputScore);
    }

    /**
     * This method resets all values from each player
     *
     */
    private void resetGame() {
        this.gameOver = false;
        this.numRounds = 0;
        for (WarPlayer warPlayer : this.player) {
            warPlayer.getDeck().wipePlayerDeck();
        }
        this.placeholderDeck.wipePlayerDeck();
        this.player1.getDeck().wipePlayerDeck();
        this.player2.getDeck().wipePlayerDeck();
    }

    /**
     * This method increments the rounds and checks and stops game after 1000
     * increments
     *
     */
    private void incrementNumRounds() {
        this.numRounds++;
        if (this.numRounds > 1000) {
            this.gameOver = true;
            System.out.println("Players have played over 1,000 rounds! We don't have all day! "
                    + "Game goes to the player with the most cards.");
        }
    }

    private void introText() {
        System.out.println("This is the game of War.\n\n"
                + "INSTRUCTIONS:"
                + "\n-The objective of the game is to win all of the cards.\n"
                + "-Each player will be dealt 26 cards."
                + "\n-Each player places a card down\n"
                + "-If both players have equal ranks War is declared (Repeats until somebody wins a round)\n"
                + "-If one player has a higher rank, they win the round. They keep all cards placed on the table.\n"
                + "-The player that has all 52 cards wins.\n"
                + "-Scores are updated at the end of the game.\n\n"
                + "ADDITIONAL INFORMATION:\n"
                + "-This game is in auto-play mode, the War card game can sometimes take up to an hour to complete! "
                + "This will complete in a few seconds.\n"
                + "-If more than 1,000 rounds occur in the game, the player with the most cards wins.\n"
                + "-If there is a tie, both players get a win.\n\n");
    }

    private void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            // netbeans forced us to put this try/except here
        }
    }

    /**
     * Summary: creates WarGroupOfCards object - already shuffled both players
     * draw one card compare cards war round super repetitive, DRY
     * distributeWinnings()? there is a winner
     */
    @Override
    public void play() {


        /* First Round:
                - both players deal: take one card from each player, put it in the placeholder
                - compare cards, whoever has the highest card gets the playerDeck

         */
        // print the instructions at the beginning of the game
        if (this.player1.getWins() == 0 && this.player2.getWins() == 0) {
            this.introText();
        }
        Scanner in = new Scanner(System.in);
        // collect info about both players
        if (this.player1.getName().equalsIgnoreCase("Player 1") || this.player2.getName().equalsIgnoreCase("Player 2")) {
            System.out.println("Now, players, register your names: ");
            System.out.print("Player 1 Name: ");
            this.setPlayer1(new WarPlayer(in.nextLine()));
            System.out.print("Player 2 Name: ");
            this.setPlayer2(new WarPlayer(in.nextLine()));
        }
        System.out.print(String.format("%s and %s! Would you like to view the instructions again?(Yes/No): ",
                this.player1.getName(), this.player2.getName()));
        if (in.nextLine().equalsIgnoreCase("Yes")) {
            this.introText();
        }
        System.out.print("\nGame begins in");
        for (int i = 3; i > 0; i--) {
            System.out.print(String.format(" %d", i));
            this.sleepForOneSecond();
        }
        System.out.println("\nGo!\n\n");
        this.sleepForOneSecond();
        // need to shuffle the deck and distribute the cards from wargroupofcards
        // first we create the wargroupofcards, it's created, assembled and shuffled in the wargroupofcards class
        WarGroupOfCards allCards = new WarGroupOfCards();

        allCards.dealToPlayerDeck(new ArrayList<>(asList(this.player1, this.player2)));

        while (this.player1.getDeck().getSize() > 0 && this.player2.getDeck().getSize() > 0 && !this.gameOver) {

            // start game
            // both players deal
            this.player1Card = player1.drawCard();
            this.player2Card = player2.drawCard();

            System.out.println(String.format("%s Drew: %s", this.player1.getName(), player1Card));
            System.out.println(String.format("%s Drew: %s", this.player2.getName(), player2Card));

            // place it in the placeholder deck
            // remove the cards from each players deck.
            // take 1 card from  each player, add to placeholder deck
            this.placeholderDeck.addCardToPlayerDeck(player1Card);
            this.placeholderDeck.addCardToPlayerDeck(player2Card);

            // remove the card we just drew from each player
            this.player1.getDeck().getPlayerDeck().remove(player1Card);
            this.player2.getDeck().getPlayerDeck().remove(player2Card);

            // increment the first round
            this.incrementNumRounds();

            // Checks for whether War is declared and does it's thing you know? -Bryan
            this.warInitiated();

            // distributes winning cards to winning player -Bryan
            this.distributeWinnings();

        }
        // Declares winner -Bryan
        this.declareWinner();
        // resets the game, wipes all playerdecks, sets gameOver to false.
        this.resetGame();
    }
}
