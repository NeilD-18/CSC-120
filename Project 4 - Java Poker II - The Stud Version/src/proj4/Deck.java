package proj4;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that models a standard deck of playing cards
 * 
 * @author Neil Daterao
 */
public class Deck {
    
    private ArrayList<Card> deckOfCards; 
    private int nextToDeal; 
    public static final int MAXCARDAMOUNT = 52; 

    /**
     * Default Constructor. Initializes a standard playing card deck of 52 cards. 
     */
    public Deck() {
        deckOfCards = new ArrayList<Card>(); 
        nextToDeal = 0; 
        for (String suit : Card.SUITS) { 
            int suitAsInt = Card.SUITS.indexOf(suit); 
            
            for (int rank = Card.MINCARDRANK; rank <= Card.MAXCARDRANK; rank++) { 
                deckOfCards.add(new Card(rank, suitAsInt)); 
            }
        }
    }

      /**
     * Method to shuffle the current deck. 
     */
    public void shuffle() { 
        if (nextToDeal < MAXCARDAMOUNT) { 
            for (int currentCardIndex = nextToDeal; currentCardIndex < deckOfCards.size(); currentCardIndex++)  {
                int randomCardIndex = ThreadLocalRandom.current().nextInt(nextToDeal, deckOfCards.size()); 
                Card currentCard = deckOfCards.get(currentCardIndex);
                Card randomCardToSwap = deckOfCards.get(randomCardIndex); 
                deckOfCards.set(currentCardIndex, randomCardToSwap);
                deckOfCards.set(randomCardIndex, currentCard);
    
            }
        }
        else { System.out.println("No cards left in the deck to shuffle!");}
    }

    /**
     * 
     * @return Returns the next undealt card. If all cards have been dealt, will return null.
     * @apiNote This runs in O(1) time since ArrayLists have constant look up times and we're not shifting the index of any cards in the ArrayList. 
     */
    public Card deal(){ 
       if (!isEmpty()) {
            Card cardToBeDealt = deckOfCards.get(nextToDeal); 
            nextToDeal++; 
            return cardToBeDealt; 
       }

       else { return null; }
      
    }

    /**
     * 
     * @return Returns true if deck is empty and false if there are still undealt cards.
     */
    public boolean isEmpty() { 
        return size() == 0;
    }
   
    /**
     * 
     * @return An integer representing the amount of undealt cards in the deck
     */
    public int size() { 
        return MAXCARDAMOUNT - nextToDeal; 
    }
    
    /**
     * 
     * Resets the deck to a state where all cards are undealt. 
     */
    public void gather() {
        nextToDeal = 0; 
    }

    
    /**
     * @return Returns the string version of all the undealt cards in the deck with one playing card per line
     */
    public String toString() { 
        if (nextToDeal < MAXCARDAMOUNT) { 
            String deckOfCardsAsString = ""; 
            
            for (int indexOfCard = nextToDeal; indexOfCard < deckOfCards.size(); indexOfCard++) { 
                deckOfCardsAsString += deckOfCards.get(indexOfCard).toString() + "\n"; 
            }
            
            return deckOfCardsAsString; 
        }
        else { return "Deck is empty!"; }
    }




}
