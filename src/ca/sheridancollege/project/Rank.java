package ca.sheridancollege.project;

/**
 * Enum for the rank of a war card. example: JACK ("Jack", 11), QUEEN ("Queen",
 * 12), KING ("King", 13);
 *
 */
public enum Rank {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

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

//    /**
//     *
//     * @param rank
//     * @param rankNum
//     */
//    private Rank(String rank, int rankNum) {
//        this.displayRank = rank;
//        this.rankNumber = rankNum;
//    }
}
