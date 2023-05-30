package proj4;

import java.util.ArrayList;

/**
 * Class that models a 2 card poker hand that also has access to the community cards 
 */
public class StudPokerHand {
    
    private ArrayList<Card> studPokerHandContents; 
    private final int MAXCARDSINSTUDPOKERHAND = 2;
    


    /**
     * Non-default constructor. Initializes 2 card poker hand. If array list has more than 2 cards, it will just take the first two cards. 
     * @param cc CommunityCardSet object
     * @param cardList ArrayList of cards 
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList) {
        studPokerHandContents = new ArrayList<Card>();
        for (Card card: cardList ) { addCard(card); }
    }

    /**
     * Method to add a card to the 2 card poker hand. If hand is full, nothing will happen.
     * @param cardToAdd Card object to add to the hand 
     */
    public void addCard(Card cardToAdd) { 
        if (size() < MAXCARDSINSTUDPOKERHAND) { studPokerHandContents.add(cardToAdd); }
    }

    /**
     * 
     * @return Size of the current 2 card poker hand 
     */
    public int size() { 
        return studPokerHandContents.size(); 
    }

    /**
     * 
     * @param index Integer representing index of the card we are getting
     * @return Card object at given index, will return null if invalid index is given. 
     */
    public Card getIthCard(int index) { 
        try { 
            return studPokerHandContents.get(index); 
        }
        catch(IndexOutOfBoundsException invalidIndex) { 
            return null; 
        }
    }

    /**
     * @return String version of the 2 card poker hand seperated by a comma. 
     */
    public String toString() { 
        String stringVersionOfStudPokerHand = "";
        int cardCounter = 0; //This is to add the comma, don't want to have Card, card, Instead Card, card
        for (Card card : studPokerHandContents) { 
            stringVersionOfStudPokerHand += card.toString();
            cardCounter++; 
            if (cardCounter < MAXCARDSINSTUDPOKERHAND) { stringVersionOfStudPokerHand += ", "; }
        }
        return stringVersionOfStudPokerHand; 
    }

    /**
    * Determines how this hand compares to another hand, using the
    * community card set to determine the best 5-card hand it can
    * make. Returns positive, negative, or zero depending on the comparison.
    *
    * @param other The hand to compare this hand to
    * @return a negative number if this is worth LESS than other, zero
    * if they are worth the SAME, and a positive number if this is worth
    * MORE than other
    */
    public int compareTo(StudPokerHand other) { 
        return 0; 
    }



    private PokerHand getBestFiveCardHand() {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    } 

    private ArrayList<PokerHand> getAllFiveCardHands() { 
        return null; 
    }




}



