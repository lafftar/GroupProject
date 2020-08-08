package ca.sheridancollege.project;

public class WarGame extends Game {

    private WarPlayer player1;
    private WarPlayer player2;
    /**
     * the deck that is being used in the game
     */
    private PlayerDeck warDeck;
    /**
     * deck to hold cards that are discarded in the war round
     */
    private PlayerDeck placeholderDeck;

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
        return this.warDeck;
    }

    /**
     *
     * @param warDeck
     */
    public void setWarDeck(PlayerDeck warDeck) {
        this.warDeck = warDeck;
    }

    /**
     * compares two war cards return true if they are the same return false if
     * they are different
     *
     * @param card1
     * @param card2
     */
    public boolean compareCards(WarCard card1, WarCard card2) {
        // TODO - implement WarGame.compareCards
        throw new UnsupportedOperationException();
    }

    /**
     * initiates war takes out 4 cards from the playerDeck puts the first 3 in
     * the placeholder deck returns the last card
     */
    public WarCard war() {
        // TODO - implement WarGame.war
        throw new UnsupportedOperationException();
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

    }

}
