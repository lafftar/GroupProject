package ca.sheridancollege.project;

/**
 * suit of type Suit enum rank of type Rank enum makes a war card with specific
 * suit and rank
 *
 */
public class WarCard extends Card {

    private Suit suit;
    private Rank rank;

    /**
     *
     * @param suit
     * @param rank
     */
    public WarCard(Suit suit, Rank rank) {
        // TODO - implement WarCard.WarCard
        throw new UnsupportedOperationException();
    }

    public Suit getSuit() {
        return this.suit;
    }

    /**
     *
     * @param suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    /**
     *
     * @param rank
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "";
    }
}
