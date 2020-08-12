package ca.sheridancollege.project;

/**
 * Models a player in the game War.
 *
 * @author Ashley Sun
 * @author Bryan Acorda
 * @author Tibabalase Oludemi
 */
public class WarPlayer extends Player {

    // playerDeck - player's hand of cards
    private PlayerDeck deck = new PlayerDeck();

    // score - how many rounds the player won
    private int score = 0;

    // # of games won
    private int wins = 0;

    // # of games lost
    private int losses = 0;

    /**
     * Constructs a WarPlay object with specified name.
     */
    public WarPlayer(String name) {
        super(name);
    }

    /**
     * Retrieves the deck of WarPlayer.
     *
     * @return deck
     */
    public PlayerDeck getDeck() {
        return this.deck;
    }

    /**
     * Assigns a deck of WarCards to the player.
     *
     * @param deck of the WarPlayer
     */
    public void setDeck(PlayerDeck deck) {
        this.deck = deck;
    }

    /**
     * Returns the first card in the player's deck.
     *
     * @return a war card
     */
    public WarCard drawCard() {
        return deck.getCardFromDeck(0);
    }

    /**
     * Retrieve the number of rounds won by the player.
     *
     * @return score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Assigns a score to the player.
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    // getter and setter for wins and losses
    /**
     * Retrieves the number of games won of this WarPlayer.
     *
     * @return wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Sets the number of wins to this WarPlayer.
     *
     * @param wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Retrieves the number of games lost of this WarPlayer.
     *
     * @return losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Sets the losses member.
     *
     * @param losses passed to set data variable losses
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }

    /**
     * Returns a String representing how many games the player won vs lost.
     * i.e., 2 : 0, is two games won and 0 games lost
     *
     * @return the stats the players game
     */
    public String getStats() {
        return String.format("%d : %d", wins, losses);
    }

    /**
     * A toString that returns the name of the Player, makes it easier to print
     * without calling .getName() all the time.
     *
     * @return the name of player
     */
    public String toString() {
        return this.getName();
    }
}
