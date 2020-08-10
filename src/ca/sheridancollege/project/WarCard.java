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
    public WarCard(Suit s, Rank r) {
        suit = s;
        rank = r;
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

    // ashley - change getRank to return the int rankNum
    public int getRank() {
        return rank.getRankNumber();
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
        return rank.getDisplayRank() + " of " + suit.getDisplaySuit();
    }
}
