package ca.sheridancollege.project;

import java.util.ArrayList;

public class PlayerDeck extends GroupOfCards {

    private ArrayList<WarCard> playerDeck;
    private String nameofDeck;

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

    public String getNameofDeck() {
        return this.nameofDeck;
    }

    /**
     *
     * @param nameofDeck
     */
    public void setNameofDeck(String nameofDeck) {
        this.nameofDeck = nameofDeck;
    }

    /**
     * use method to remove specific cards from the playerDeck -- not sure how
     * to implement this method
     */
    public void removeCards() {
        // TODO - implement PlayerDeck.removeCards
        throw new UnsupportedOperationException();
    }

    /**
     * use method to add specific cards to the playerDeck -- not sure how to
     * implement this method
     */
    public void addCards() {
        // TODO - implement PlayerDeck.addCards
        throw new UnsupportedOperationException();
    }

}
