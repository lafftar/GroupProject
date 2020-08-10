package ca.sheridancollege.project;

import java.util.*;
import static java.util.Arrays.asList;

public class WarGame extends Game {

    private WarGroupOfCards allCards = new WarGroupOfCards();
    private WarPlayer player1 = new WarPlayer("Player 1");
    private WarPlayer player2 = new WarPlayer("Player 2");
    private PlayerDeck placeholderDeck = new PlayerDeck(0); // deck to hold cards that are discarded in the war round
    ArrayList<WarPlayer> player = new ArrayList(); // Store each player

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

    /**
     * Initiates war takes out 4 cards from the playerDeck puts the first 3 in
     * the placeholder deck returns the last card.
     *
     * @return
     */
    public void warInitiated(WarCard player1, WarCard player2) {
        // while war is declared, we want the methods above to loop twice.
        // This loop will only be entered when war is declared from first play, 
        // which is obvs the only time war can be declared

        // Changed the comparing number to 2 -Bryan
        while (this.compareCards(player1, player2) == 2) {
            System.out.println("War has been initiated!!!");
            for (int i = 0; i < 2; i++) {
                player1 = this.player1.drawCard();
                player2 = this.player2.drawCard();
                if (i == 1) {
                    // WarCard might need a better toString()
                    System.out.println("Player 1 Drew: " + player1.toString());
                    System.out.println("Player 2 Drew: " + player2.toString());
                }
                // take 1 card from  each player, add to placeholder deck
                this.placeholderDeck.addCardToPlayerDeck(player1);
                this.placeholderDeck.addCardToPlayerDeck(player2);
                // might benefit from having a remove card method for the player
                // remove the card we just drew from each player
                this.player1.getDeck().getPlayerDeck().remove(player1);
                this.player2.getDeck().getPlayerDeck().remove(player2);
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
     */
    public void distributeWinnings(WarCard player1Card, WarCard player2Card, int num) {

        // I'm not satisfied with having to create an Arraylist object here but
        // it works for now. -Bryan
        player = new ArrayList();
        player.add(player1);
        player.add(player2);

        if (this.compareCards(player1Card, player2Card) == num) { // If a player won
            // that player will have all cards in placeholder deck added to the bottom of his pile.
            // place holder deck will be wiped.

            // Changed %d to %s, and called the players getName() class instead -Bryan
            System.out.println(String.format("Player %s Wins! They get %d cards",
                    player.get(num).getName(), this.placeholderDeck.getSize()));

            // Same deal here -Bryan
            for (WarCard card : this.placeholderDeck.getCards()) {
                player.get(num).getDeck().addCardToPlayerDeck(card);
            }

            this.placeholderDeck.getCards().removeAll(player.get(num).getDeck().getCards());
            // the .getSize() method only returns the size of the class at initialization, not while it's moving
            // i've overridden the method in playerdeck

            // Changed the "Player 1 now has..." to use getName() from WarPlayer -Bryan
            System.out.println(String.format(player.get(0).getName()
                    + " Now Has %d cards", this.player1.getDeck().getSize()));
            System.out.println(String.format(player.get(1).getName()
                    + " Now Has %d cards", this.player2.getDeck().getSize()));
        }

    }

    /**
     * This method declares a winner and increments the winning score of each
     * player
     *
     */
    @Override
    public void declareWinner() {

        if (player1.getDeck().getPlayerDeck().size() == 52) {
            System.out.println(player1.getName() + " Wins!");
            player1.setWins(player1.getWins() + 1);
            player2.setLosses(player2.getLosses() + 1);

        } else {
            System.out.println(player2.getName() + " Wins!");
            player2.setWins(player2.getWins() + 1);
            player1.setLosses(player1.getLosses() + 1);

        }

        // Created a score ouput for each player, it doesn't work accurately as
        // this is just a test. -Bryan
        String outputScore = "\nGame Stats:\n" + player1.getStats() + "\n" + player2.getStats();
        System.out.println(outputScore);
    }

        /**
         * Summary: creates WarGroupOfCards object - already shuffled both
         * players draw one card compare cards war round super repetitive, DRY
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
//        WarGroupOfCards allCards = new WarGroupOfCards();
            allCards.dealToPlayerDeck(new ArrayList<>(asList(this.player1, this.player2)));
            // this will need to be nested further, to have support for continious play
            while (this.player1.getDeck().getSize() > 0 && this.player2.getDeck().getSize() > 0) {
                // start game
//         both players deal
                WarCard player1Card = this.player1.drawCard();
                WarCard player2Card = this.player2.drawCard();
                // need to replace these 'Player 1' with the player names. 
                // Just did -Bryan
                System.out.println(player1.getName() + " Drew: " + player1Card.toString());
                System.out.println(player2.getName() + " Drew: " + player2Card.toString());
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

                // Checks for whether War is declared and does it's thing you know? -Bryan
                warInitiated(player1Card, player2Card);

                // distributes winning cards to winning player -Bryan
                distributeWinnings(player1Card, player2Card, 0); // Player 1
                distributeWinnings(player1Card, player2Card, 1); // Player 2

            }
            System.out.println("");
            declareWinner();
        }

    

    public static void main(String[] args) {
        // This just to test the class, don't mind the random main method.
        // This should be deleted after completion -Bryan

        Scanner input = new Scanner(System.in);
        WarGame game = new WarGame("War");

        boolean playAgain = false;
        do {
            game.play();
            System.out.println("Do you want to play again? ");
            String confirm = input.next();

            if (confirm.equalsIgnoreCase("yes")) {
                playAgain = true;
            }
        } while (playAgain);

    }

}
