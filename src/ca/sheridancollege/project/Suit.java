package ca.sheridancollege.project;

/**
 *
 * Enum for the suit of a war card. displaySuit : String, a string
 * representation of the suit i.e., "Spades"
 *
 */
public enum Suit {
    CLUBS,
    HEARTS,
    DIAMONDS,
    SPADES;

    private String displaySuit;

    public String getDisplaySuit() {
        return this.displaySuit;
    }

    /**
     *
     * @param suit
     */
//    private Suit() {
//        // TODO - implement Suit.Suit
//        throw new UnsupportedOperationException();
//    }
}
