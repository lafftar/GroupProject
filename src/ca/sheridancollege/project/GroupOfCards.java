/**
 * SYST 17796 Project Base code.
 * 
 * Date: 06-09-2020
 * @Author Bryan Acorda
 * Group 3
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.WarCard.Rank;
import ca.sheridancollege.project.WarCard.Suit;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(int size) {
        cards = new ArrayList();
        this.size = size;
        assembleCards();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public void assembleCards() {
        // Assembling the deck from the cards created in the Card class 
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new WarCard(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
