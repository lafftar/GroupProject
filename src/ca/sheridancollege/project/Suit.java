package ca.sheridancollege.project;

/**
 *
 * Enum for the suit of a war card. displaySuit : String, a string
 * representation of the suit i.e., "Spades" Created enum
 *
 * @author Ashley Sun
 */
public enum Suit {
    CLUBS("Clubs"),
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    SPADES("Spades");

    private String displaySuit;

    public String getDisplaySuit() {
        return this.displaySuit;
    }

    /**
     *
     * @param suit
     */
    private Suit(String suit) {
        displaySuit = suit;
    }

}
