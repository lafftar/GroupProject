package ca.sheridancollege.project;

/**
 * Enumeration class for the rank of a War Card.
 * 
 * @author Ashley Sun, 2020
 * 
 *
 */
public enum Rank {
    ONE ("One", 1),
    TWO ("Two", 2),
    THREE ("Three", 3),
    FOUR ("Four", 4),
    FIVE ("Five", 5),
    SIX ("Six", 6),
    SEVEN ("Seven", 7),
    EIGHT ("Eight", 8),
    NINE ("Nine", 9),
    TEN ("Ten", 10),
    JACK ("Jack", 11),
    QUEEN ("Queen", 12),
    KING ("King", 13);

    /**
     *
     * displayRank : String, a string representation of the rank i.e., "Jack
     *
     */
    private String displayRank;
    /**
     *
     * rankNumber : int, the actual value of the rank; to be used in the logic
     * of the game i.e., 11
     *
     */
    private int rankNumber;

    public String getDisplayRank() {
        return this.displayRank;
    }

    public int getRankNumber() {
        return this.rankNumber;
    }

    /**
     * Private constructor , do not instantiate .
     * 
     * @param rank
     * @param rankNum
     */
    private Rank(String rank, int rankNum) {
        // TODO - implement Rank.Rank
        this.displayRank = rank;
        this.rankNumber = rankNum;
    }

}