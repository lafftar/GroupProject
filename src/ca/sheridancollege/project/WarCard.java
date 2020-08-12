package ca.sheridancollege.project;

/**
 * Models a WarCard which has programmer-defined values for it's suit and rank. 
 * suit of type Suit enum, rank of type Rank enum makes a war card with specific
 * suit and rank. Also returns a string representation of car card from toString 
 * 
 * @author Bryan Acorda
 * @author Ashley Sun
 */
public class WarCard extends Card {

    private Suit suit;
    private Rank rank;

    /**
     * Constructs a WarCard with specified suit and rank.
     * 
     * @param s to assign suit
     * @param r to assign rank
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
     * @param suit assigns data member suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
    * Retrieves the rank of this WarCard.
    * @return rank data member
    */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Assigns a rank enum to this WarCard.
     * @param rank assigns data member rank
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
