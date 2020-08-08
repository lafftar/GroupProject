package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * @author OtherUser
 */
public class PlayerDeck extends WarDeck {

    private ArrayList<WarCard> playerDeck = new ArrayList(26);
    private String nameOfDeck;

    public PlayerDeck(int size) {
        super(size);
    }

    public ArrayList<WarCard> getPlayerDeck() {
        return this.playerDeck;
    }

    /**
     *
     * @param playerDeck
     */
    public void setPlayerDeck(ArrayList<WarCard> playerDeck) {
        this.playerDeck = playerDeck;
    }

    /**
     *
     * @return
     */
    public String getNameOfDeck() {
        return this.nameOfDeck;
    }

    /**
     *
     * @param nameOfDeck
     */
    public void setNameOfDeck(String nameOfDeck) {
        this.nameOfDeck = nameOfDeck;
    }

    /**
     *
     *
     * @param card
     */
    public void addCardToPlayerDeck(WarCard card) {
        this.playerDeck.add(card);
    }

}
