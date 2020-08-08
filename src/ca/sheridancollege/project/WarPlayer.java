package ca.sheridancollege.project;

/**
 * Models a player in the game War
 *
 * @author Ashley Sun, 2020
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

    public WarPlayer(String name) {
        super(name);
    }

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
     * Returns the first card in the player's deck.
     *
     * @return a war card
     */
    public WarCard drawCard() {
        return deck.getCardFromDeck(0);
        //return new WarCard(Suit.CLUBS, Rank.EIGHT); // just for testing, delete.
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
    
    // getter and setter for wins and losses
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

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

    // ???
    @Override
    public void play() {

    }

}
