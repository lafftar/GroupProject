package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * @author OtherUser
 */
public class PlayerDeck extends GroupOfCards {

    public PlayerDeck() {
        super(26);
    }

    public PlayerDeck(int size) {
        super(size);
    }

    public ArrayList<WarCard> getPlayerDeck() {
        return super.getCards();
    }

    /**
     *
     * @param playerDeck
     */
//    public void setPlayerDeck(ArrayList<WarCard> playerDeck) {
//        super.getCards().set = playerDeck;
//    }
    /**
     *
     *
     * @param card
     */
    public void addCardToPlayerDeck(WarCard card) {
        super.getCards().add(card);
    }

    /**
     * Returns the card at the specific index
     *
     * @param cardIndex
     * @return the specific war card
     */
    public WarCard getCardFromDeck(int cardIndex) {
//        System.out.println(this.cards);
        return super.getCards().get(cardIndex);
    }

}
