package ca.sheridancollege.project;

import java.util.*;
import static java.util.Arrays.asList;

public class WarGame extends Game {

    private WarPlayer player1 = new WarPlayer("Player 1");
    private WarPlayer player2 = new WarPlayer("Player 2");
    private PlayerDeck placeholderDeck = new PlayerDeck(0); // deck to hold cards that are discarded in the war round
    ArrayList<WarPlayer> player = new ArrayList(asList(player1, player2)); // Store each player
    ArrayList<WarCard> playerCards;
    ; // Deck that holds cards that are discarded in the war round

    // allows us to declare gameOver in warInitiated and have it carry over to the distributeWinnings() method
    private boolean gameOver = false;
    // allows us to stop the game after 100 rounds have been played, and declare the player with most cards the winner
    private int numRounds = 0;

    // trying to fix
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
    public void warInitiated(WarCard p1Card, WarCard p2Card) {

        // Store in array
        ArrayList<WarCard> cards = new ArrayList(asList(p1Card, p2Card));
        boolean atWar = this.compareCards(p1Card, p2Card) == 2;

        // while war is declared, we want the methods above to loop twice.
        // This loop will only be entered when war is declared from first play,
        // which is obvs the only time war can be declared
        // if any player has less than two cards when war is initiated
        // I think this is the reason why the game cannot finish, remember that
        // the condition is that the games ends with a winner or loser if either
        // the winner has all 52 cards OR or loser has no cards at all.
        // With this, you are preventing a player to lose because you aren't
        // letting the loser have less that 2 cards. -Bryan
        if ((player.get(0).getDeck().getSize() < 2 || player.get(1).getDeck().getSize() < 2) && atWar) {
            this.gameOver = true;
            System.out.println(String.format("War has been initiated, but Player '%s' has less than 2 cards! "
                    + "They cannot afford to go to war!", this.returnPlayerWithLowerCards().getName()));
        } else {
            while (atWar) {
                // Changed the comparing number to 2 -Bryan
                System.out.println("War has been initiated!!!");
                for (int i = 0; i < 2; i++) {

                    p1Card = player.get(0).drawCard();
                    p2Card = player.get(1).drawCard();

                    System.out.println(String.format("Player '%s' drew %s", this.player1.getName(), p1Card));
                    System.out.println(String.format("Player '%s' drew %s", this.player2.getName(), p2Card));

                    // take 1 card from  each player, add to placeholder deck
                    this.placeholderDeck.addCardToPlayerDeck(p1Card);
                    this.placeholderDeck.addCardToPlayerDeck(p2Card);

                    // remove the card we just drew from each player
                    this.player.get(0).getDeck().getPlayerDeck().remove(p1Card);
                    this.player.get(1).getDeck().getPlayerDeck().remove(p2Card);

                    this.incrementNumRounds();
                }
                atWar = this.compareCards(p1Card, p2Card) == 2;
            }

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
     * @param player1Card
     * @param player2Card
     * @param num
     */
    public void distributeWinnings(WarCard player1Card, WarCard player2Card, int num) {

        if (!this.gameOver) {
            if (this.compareCards(player1Card, player2Card) == num) { // If a player won
                // that player will have all cards in placeholder deck added to the bottom of his pile.
                // place holder deck will be wiped.

                // Changed %d to %s, and called the players getName() class instead -Bryan
                System.out.println(String.format("Player '%s' Wins! They get %d cards",
                        player.get(num).getName(), this.placeholderDeck.getSize() - 1));

                // Same deal here -Bryan
                for (WarCard card : this.placeholderDeck.getCards()) {
                    player.get(num).getDeck().addCardToPlayerDeck(card);
                }

                this.placeholderDeck.getCards().removeAll(player.get(num).getDeck().getCards());
                // the .getSize() method only returns the size of the class at initialization, not while it's moving
                // i've overridden the method in playerdeck

                // Changed the "Player 1 now has..." to use getName() from WarPlayer -Bryan
                for (WarPlayer warPlayer : player) {
                    System.out.println(String.format(warPlayer + " Now has %d cards", warPlayer.getDeck().getSize()));
                } // -Bryan

//                System.out.println(String.format(player.get(0).getName()
//                        + " Now Has %d cards", this.player1.getDeck().getSize()));
//                System.out.println(String.format(player.get(1).getName()
//                        + " Now Has %d cards", this.player2.getDeck().getSize()));
            }
        }

    }

    /**
     * This method declares a winner and increments the winning score of each
     * player
     *
     */
    @Override
    public void declareWinner() {

        // Put these here to clean up the conditions a bit
        WarPlayer p1 = player.get(0);
        WarPlayer p2 = player.get(1);
        int p1Condition = p1.getDeck().getPlayerDeck().size();
        int p2Condition = p2.getDeck().getPlayerDeck().size();

        // changing this to declare winner on the person with the most cards
        // instead
        if (p1Condition > p2Condition) {
            System.out.println(p1.getName() + " Wins!");
            p1.setWins(p1.getWins() + 1);
            p2.setLosses(player.get(1).getLosses() + 1);

        } else if (p1Condition == p2Condition) {
            System.out.println("Both players have the same number of cards! "
                    + "You both get a win!");

            for (WarPlayer warPlayer : player) {
                warPlayer.setWins(warPlayer.getWins() + 1);
            } // -Bryan

//            player.get(0).setWins(player.get(0).getWins() + 1);
//            player.get(1).setWins(player.get(1).getWins() + 1);
        } else {
            System.out.println(p2.getName() + " Wins!");
            p2.setWins(p2.getWins() + 1);
            p1.setLosses(p1.getLosses() + 1);

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
//        Scanner in = new Scanner(System.in);
//            // collect info about both players
//            System.out.print("Player 1 Name: ");
//            this.setPlayer1(new WarPlayer(in.nextLine()));
//            System.out.print("Player 2 Name: ");
//            this.setPlayer2(new WarPlayer(in.nextLine()));
//            System.out.println("Players:\n" + this.player1.getName()
//                    + "\n" + this.player2.getName());
        // need to shuffle the deck and distribute the cards from wargroupofcards
        // first we create the wargroupofcards, it's created, assembled and shuffled in the wargroupofcards class
        WarGroupOfCards allCards = new WarGroupOfCards();

        allCards.dealToPlayerDeck(new ArrayList<>(asList(this.player1, this.player2)));
        // this will need to be nested further, to have support for continious play
        while (this.player.get(0).getDeck().getSize() > 0 && this.player.get(1).getDeck().getSize() > 0 && !this.gameOver) {

            /**
             * OKAY SO there was a lot of DRY humping going on betweeen player1
             * and player2.. gave them a room by storing them in arraylists and
             * cleaned it up by printing out all repeating lines of code in
             * for-each loops. Although I did leave all the repeated code
             * commented out just in case you wanted to bring them back -Bryan
             *
             */
            // start game
            // both players deal
            WarCard player1Card = player.get(0).drawCard();
            WarCard player2Card = player.get(1).drawCard();

            // initialized the playerCards ArrayList from the private data members
            // stored each player in arraylists to stay consitent and clean.
            playerCards = new ArrayList(asList(player1Card, player2Card));

            // need to replace these 'Player 1' with the player names.
            // Just did -Bryan
            for (WarPlayer warPlayer : player) {
                System.out.println(warPlayer + " Drew: " + playerCards.get(player.indexOf(warPlayer)));
            } // -Bryan

//            System.out.println(player1.getName() + " Drew: " + playerCards.get(0).toString());
//            System.out.println(player2.getName() + " Drew: " + playerCards.get(1).toString());
            // deal the first cards,
            // place it in the placeholder deck
            // remove the cards from each players deck.
            // compare the cards
            // take 1 card from  each player, add to placeholder deck
            for (WarCard playerCard : playerCards) {
                this.placeholderDeck.addCardToPlayerDeck(playerCard);
            } // -Bryan
//            this.placeholderDeck.addCardToPlayerDeck(player1Card);
//            this.placeholderDeck.addCardToPlayerDeck(player2Card);

            // might benefit from having a remove card method for the player
            // remove the card we just drew from each player
            for (WarPlayer warPlayer : player) {
                for (WarCard playerCard : playerCards) {
                    warPlayer.getDeck().getPlayerDeck().remove(playerCard);
                } // -Bryan
            }

//            this.player1.getDeck().getPlayerDeck().remove(player1Card);
//            this.player2.getDeck().getPlayerDeck().remove(player2Card);
            this.incrementNumRounds();

            // Checks for whether War is declared and does it's thing you know? -Bryan
            warInitiated(player1Card, player2Card);

            // distributes winning cards to winning player -Bryan
            for (WarPlayer warPlayer : player) {
                this.distributeWinnings(player1Card, player2Card, player.indexOf(warPlayer));
            } // -Bryan
//            distributeWinnings(player1Card, player2Card, 0); // Player 1
//            distributeWinnings(player1Card, player2Card, 1); // Player 2

        }
        System.out.println("");
        // Declares winner -Bryan
        declareWinner();
        // resets the game, wipes all playerdecks, sets gameOver to false.
        this.resetGame();
    }
}
