package proj4;

import java.util.ArrayList;

/**
 * Class that models the collection of community cards in Texas Hold'em.
 * @author Neil Daterao
 */
public class CommunityCardSet {
    
    private ArrayList<Card> CommunityCardSetContents; 
    private final int MAXAMOUNTOFCOMMUNITYCARDS = 5; 


    /**
     * Non-default constructor, initializes the community cards. Will only initialize up to 5 community cards. 
     * @param cardList ArrayList of cards to add to the CommunityCardSet.
     */
    public CommunityCardSet(ArrayList<Card> cardList) {
        CommunityCardSetContents = new ArrayList<Card>(); 
        for (Card cardToAdd : cardList) { addCard(cardToAdd); } 
            
    }

    /**
     * Method to add a card to the community card set, will do nothing if there are already 5 community cards. 
     * @param cardToAdd Card object to add to community card set. 
     */
    public void addCard(Card cardToAdd) { 
        if (size() < MAXAMOUNTOFCOMMUNITYCARDS) { CommunityCardSetContents.add(cardToAdd); }
        
    }

    /**
     * 
     * @return Integer representing the size of the community card set. 
     */
    public int size() { 
        return CommunityCardSetContents.size(); 
    }

    /**
     * Method will return null if invalid index is given
     * @param index Integer representing the index of the card in the community card set 
     * @return Card at given index
     */
    public Card getIthCard(int index){ 
        try { 
            return CommunityCardSetContents.get(index); 
        }
        catch(IndexOutOfBoundsException invalidIndex) { 
            return null; 
        }
    }

    /**
     * 
     * @return String version of the Community Card Set with each card seperated by " | "
     */
    public String toString() { 
        String stringVersionOfCommunityCardSet = ""; 
        int CardCounter = 0; // To seperate each with " | " and avoid having " | " ending off the string. 
        for (Card card : CommunityCardSetContents) { 
            stringVersionOfCommunityCardSet += card.toString();
            CardCounter++; 
            if (CardCounter < MAXAMOUNTOFCOMMUNITYCARDS) { stringVersionOfCommunityCardSet += " | "; }
        }
        return stringVersionOfCommunityCardSet; 
    }
}
