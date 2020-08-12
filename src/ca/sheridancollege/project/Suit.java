package ca.sheridancollege.project;

/**
 * Enumeration for the suit of a war card.
 *
 * @author Ashley Sun
 * @author Bryan Acorda
 * @author Tibabalase Oludemi
 */
public enum Suit {
    CLUBS("Clubs"),
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    SPADES("Spades");

    //A String representation of the suit
    private String displaySuit;

    /**
     * Retrieve the String representation of this suit
     *
     * @return displaySuit
     */
    public String getDisplaySuit() {
        return this.displaySuit;
    }

    /**
     * Private constructor, is not instantiated outside of enum class.
     *
     * @param suit
     */
    private Suit(String suit) {
        displaySuit = suit;
    }

}
