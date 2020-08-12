
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. 
 * The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant 01-2020
 * @modifier Bryan Acorda 08-2020 
 */
public class GroupOfCards {

    // The group of cards, stored in an ArrayList
    private ArrayList<WarCard> cards;
    
    //the size of the grouping
    private int size;

    /**
    * Creates a GroupOfCards object with a specified size.
    *
    * @param size 
    */
    public GroupOfCards(int size) {
        cards = new ArrayList();
        this.size = size;
    }

    /**
     * A method that retrieves this group of cards object as an ArrayList.
     * 
     * @return the group of cards.
     */
    public ArrayList<WarCard> getCards() {
        return cards;
    }

    /**
    * Shuffles the cards in this GroupOfCards.
    *
    */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Retrieves the size of this GroupOfCards arraylist.
     * 
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /** 
     * Sets the size of this GroupOfCards arraylist.
     *
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
