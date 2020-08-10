package ca.sheridancollege.project;

/**
 * Enumeration for the rank of a War Card.
 *
 * @author Ashley Sun
 */
public enum Rank {
    
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13),
    ACE("Ace", 14);

    //user-friendly format of rank
    private String displayRank;
    
    //the actual number assigned to the rank
    private int rankNumber;

    /**
    * Retrieve the String of this rank.
    *
    * @return displayRank
    */
    public String getDisplayRank() {
        return this.displayRank;
    }

    /**
    * Retrieve the number assigned to this rank.
    * 
    * @return rankNumber
    */
    public int getRankNumber() {
        return this.rankNumber;
    }

    /**
     * Private constructor, not to be instantiated outside of enum class.
     * 
     * @param rank
     * @param rankNum
     */
    private Rank(String rank, int rankNum) {
        displayRank = rank;
        rankNumber = rankNum;
    }

}
