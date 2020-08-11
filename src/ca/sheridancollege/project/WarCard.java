package ca.sheridancollege.project;

/**
 * suit of type Suit enum, rank of type Rank enum makes a war card with specific
 * suit and rank
 * 
 * @author Bryan Acorda
 */
public class WarCard extends Card {

    private Suit suit;
    private Rank rank;

    /**
     * Constructs a WarCard with specified suit and rank.
     * @param suit
     * @param rank
     */
    public WarCard(Suit s, Rank r) {
        suit = s;
        rank = r;
    }

    /**
    * Retrieves the suit of this WarCard.
    * @return suit
    */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * Assigns a suit enum to this WarCard.
     * @param suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
    * Retrieves the rank of this WarCard.
    * @return rank
    */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Assigns a rank enum to this WarCard.
     * @param rank
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * Returns this WarCard as a String.
     * 
     * @return a string representation of this WarCard
     */
    @Override
    public String toString() {
        return this.getRank().getDisplayRank() + " of " 
                + this.getSuit().getDisplaySuit();
    }
}
