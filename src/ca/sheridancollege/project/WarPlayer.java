package ca.sheridancollege.project;

/**
 * Models a player in the game War
 *
 */
public class WarPlayer {

    /**
     * playerDeck - player's hand of cards
     */
    private PlayerDeck deck;
    /**
     * score - how many rounds the player won
     */
    private int score;
    /**
     * stats - how many games the player won
     *
     */
    private double stats;

    public PlayerDeck getDeck() {
        return this.deck;
    }

    /**
     *
     * @param deck
     */
    public void setDeck(PlayerDeck deck) {
        this.deck = deck;
    }

    /**
     * returns a war card from the player's playerDeck arraylist
     *
     */
    public WarCard drawCard() {
        // TODO - implement WarPlayer.drawCard
        throw new UnsupportedOperationException();
    }

    public int getScore() {
        return this.score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    public double getStats() {
        return this.stats;
    }

    /**
     *
     * @param stats
     */
    public void setStats(double stats) {
        this.stats = stats;
    }

    public void calcStats() {
        // TODO - implement WarPlayer.calcStats
        throw new UnsupportedOperationException();
    }

    public void calcScore() {
        // TODO - implement WarPlayer.calcScore
        throw new UnsupportedOperationException();
    }

    @Override
    public void play() {

    }

}
