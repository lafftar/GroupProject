package ca.sheridancollege.project;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Scanner;

/**
 * Models the WarGame, contains the logic to run the game
 *
 * @author TJ
 * @modifier Bryan Acorda
 */
public class WarGame extends Game {

    private WarPlayer player1 = new WarPlayer("Player 1");
    private WarPlayer player2 = new WarPlayer("Player 2");
    private PlayerDeck placeholderDeck = new PlayerDeck(0); // deck to hold cards that are discarded in the war round
    ArrayList<WarCard> playerCards;

    // for easier access to last player card for each player
    private WarCard player1Card;
    private WarCard player2Card;

    // allows us to declare gameOver in warInitiated  and other methods
    // and have it carry over to the distributeWinnings() method
    private boolean gameOver = false;

    // allows us to stop the game after 1000 rounds have been played, and declare the player with most cards the winner
    private int numRounds = 0;

    public WarGame(String name) {
        super(name);
    }

    /**
     * Compares two War Cards based on their rank and returns 0 - if card 1 is
     * greater, 1 if card 2 is greater, 2 if they are the same.
     *
     * @param card1
     * @param card2
     */
    public int compareCards(WarCard card1, WarCard card2) {
        // returns values 0, 1, 2 depending on which players card won
        if (card1.getRank().getRankNumber() > card2.getRank().getRankNumber()) {
            return 0; // if player 1's card won
        }
        if (card1.getRank().getRankNumber() < card2.getRank().getRankNumber()) {
            return 1; // if player 2's card won
        }
        return 2; // if players cards are the same, war condition
    }

    // returns the player with less cards
    private WarPlayer returnPlayerWithLowerCards() {
        if (this.player1.getDeck().getSize() < this.player2.getDeck().getSize()) {
            return this.player1;
        }
        return this.player2;
    }

    /**
     * Initiates war takes out 4 cards from the playerDeck puts the first 3 in
     * the placeholder deck returns the last card.
     *
     * @return
     */
    public void warInitiated() {

        // first check for war condition between players
        boolean atWar = this.compareCards(this.player1Card, this.player2Card) == 2;

        // while war is declared, two rounds are played
        // This loop will only be entered when war is declared from first play,
        // which is the only time war can be declared
        /* will only be entered if both cards have the same rank, the game is still going, and the number of rounds is less than
        999*/
        while (atWar && !this.gameOver && this.numRounds < 999) {
            // if any players have less than two cards, a message is printed to the players, the round is ended
            if (this.player1.getDeck().getSize() < 2 || this.player2.getDeck().getSize() < 2) {
                this.gameOver = true;
                System.out.println(String.format("War has been initiated, but Player '%s' has less than 2 cards! "
                        + "They cannot afford to go to war!", this.returnPlayerWithLowerCards().getName()));
                break;
            }
            System.out.println("War has been initiated!!!");
            for (int i = 0; i < 2; i++) {

                this.player1Card = this.player1.drawCard();
                this.player2Card = this.player2.drawCard();

                System.out.println(String.format("Player '%s' Drew: %s", this.player1.getName(), this.player1Card));
                System.out.println(String.format("Player '%s' Drew: %s", this.player2.getName(), this.player2Card));

                // take 1 card from  each player, add to placeholder deck
                this.placeholderDeck.addCardToPlayerDeck(this.player1Card);
                this.placeholderDeck.addCardToPlayerDeck(this.player2Card);

                // remove the cards we just drew from each player
                this.player1.getDeck().getPlayerDeck().remove(this.player1Card);
                this.player2.getDeck().getPlayerDeck().remove(this.player2Card);

                // increment for each round war is played
                this.incrementNumRounds();
            }
            // checks if the last two cards constitue war
            atWar = this.compareCards(this.player1Card, this.player2Card) == 2;
        }
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
                System.out.println(String.format("Player '%s' Wins! They get %d cards",
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
            // wipe the placeholder deck after every play
            this.placeholderDeck.wipePlayerDeck();
        }
        // announces how many cards each player has
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

        // placing these calls in variables to reduce function calls/increase performance
        int p1Condition = this.player1.getDeck().getPlayerDeck().size();
        int p2Condition = this.player2.getDeck().getPlayerDeck().size();

        // the player with the most cards is declared the winner
        if (p1Condition > p2Condition) { // if player 1's deck size is greater, they win
            System.out.println("\n" + this.player1.getName() + " Wins!");
            this.player1.setWins(this.player1.getWins() + 1);
            this.player2.setLosses(this.player2.getLosses() + 1);
        } else if (p1Condition == p2Condition) { // if both players have the same deck size, they both win
            System.out.println("\nBoth players have the same number of cards! "
                    + "You both get a win!");
            this.player1.setWins(this.player1.getWins() + 1);
            this.player2.setWins(this.player2.getWins() + 1);
        } else { // if player 2's deck size is greater, they win
            System.out.println("\n" + this.player2.getName() + " Wins!");
            this.player2.setWins(this.player2.getWins() + 1);
            this.player1.setLosses(this.player1.getLosses() + 1);
        }

        // prints score statistics for each player.
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
        // wipes the placeholder deck, as well as each players playerdeck
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
        this.sleepForOneSecond();
        System.out.println("Press the 'enter' key to carry on with the game: ");
        new Scanner(System.in).nextLine();
    }

    public static void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            // netbeans forced us to put this try/except here
        }
    }

    /**
     * Runs the game of War.
     */
    @Override
    public void play() {

        // print the instructions at the beginning of the game
        if (this.player1.getWins() == 0 && this.player2.getWins() == 0) {
            this.introText();
        }
        Scanner in = new Scanner(System.in);
        // collect info about both players if any players have default names
        if (this.player1.getName().equalsIgnoreCase("Player 1") || this.player2.getName().equalsIgnoreCase("Player 2")) {
            System.out.println("Now, players, register your names: ");
            System.out.print("Player 1 Name: ");
            this.player1 = (new WarPlayer(in.nextLine()));
            System.out.print("Player 2 Name: ");
            this.player2 = (new WarPlayer(in.nextLine()));
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

        // first we create the wargroupofcards, it's created, assembled and shuffled in the wargroupofcards class
        WarGroupOfCards allCards = new WarGroupOfCards();

        // allCards are divided equally to both players
        allCards.dealToPlayerDeck(new ArrayList<>(asList(this.player1, this.player2)));

        // exit the loop if any players reach 0 cards, or other methods have set the .gameOver flag to true
        while (this.player1.getDeck().getSize() > 0 && this.player2.getDeck().getSize() > 0 && !this.gameOver) {

            // start game
            // both players deal
            this.player1Card = player1.drawCard();
            this.player2Card = player2.drawCard();

            System.out.println(String.format("%s Drew: %s", this.player1.getName(), player1Card));
            System.out.println(String.format("%s Drew: %s", this.player2.getName(), player2Card));

            // take 1 card from  each player, add to placeholder deck
            this.placeholderDeck.addCardToPlayerDeck(player1Card);
            this.placeholderDeck.addCardToPlayerDeck(player2Card);

            // remove the cards we just drew from each player
            this.player1.getDeck().getPlayerDeck().remove(player1Card);
            this.player2.getDeck().getPlayerDeck().remove(player2Card);

            // increment the first round
            this.incrementNumRounds();

            // checks if war needs to be declared, handles all war logic
            this.warInitiated();

            // distributes winning cards to winning player
            this.distributeWinnings();

        }
        // Declares winner
        this.declareWinner();
        // resets the game, wipes all playerdecks, sets gameOver to false.
        this.resetGame();
    }
}
