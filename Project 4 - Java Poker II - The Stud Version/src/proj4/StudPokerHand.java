package proj4;

import java.util.ArrayList;

/**
 * Class that models a 2 card poker hand that also has access to the community cards 
 * @author Neil Daterao
 */
public class StudPokerHand {
    
    private ArrayList<Card> studPokerHandContents; 
    private CommunityCardSet communityCards; 
    private final int MAXCARDSINSTUDPOKERHAND = 2;
    


    /**
     * Non-default constructor. Initializes 2 card poker hand. If array list has more than 2 cards, it will just take the first two cards. 
     * @param cc CommunityCardSet object
     * @param cardList ArrayList of cards 
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList) {
        communityCards = cc; 
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
        PokerHand otherBestHand = other.getBestFiveCardHand();
        return getBestFiveCardHand().compareTo(otherBestHand); 
    }


    /**
     * Private helper function to determine the best poker hand we have
     * @return PokerHand object that is the best given the possible poker hands. 
     */
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

    /**
     * Private helper function to obtain all possible pokerhands
     * @return ArrayList of PokerHand objects of all possible poker hands
     */
    private ArrayList<PokerHand> getAllFiveCardHands() { 
        ArrayList<Card> allCardsInPlay = getAllCardsInPlay(); 
        ArrayList<PokerHand> allPossiblePokerHands = new ArrayList<PokerHand>(); 
        ArrayList<Card> cardList;

        for (int cardIndex = 0, maxCardIndex = allCardsInPlay.size() ; cardIndex < maxCardIndex; cardIndex++) { 
            for (int nextCardIndex = cardIndex + 1; nextCardIndex < maxCardIndex; nextCardIndex++) { 
                cardList = new ArrayList<Card>(allCardsInPlay); 
                Card firstCardToRemove = cardList.get(cardIndex); 
                Card secondCardToRemove = cardList.get(nextCardIndex);
                cardList.remove(firstCardToRemove);
                cardList.remove(secondCardToRemove);
                allPossiblePokerHands.add(new PokerHand(cardList)); 
            }
        }

        return allPossiblePokerHands; 
    }

    /**
     * Private helper function to put all the possible cards into one arraylist to make the data more manageable.
     * @return An ArrayList of card object of all the cards in play
     */
    private ArrayList<Card> getAllCardsInPlay() { 
        ArrayList<Card> allCardsInPlay = new ArrayList<>(studPokerHandContents);
        for (int cardIndex = 0; cardIndex < communityCards.size(); cardIndex++) { 
            Card cardInCommunityCards = communityCards.getIthCard(cardIndex);
            allCardsInPlay.add(cardInCommunityCards); 
        }
        return allCardsInPlay; 
    }




}



