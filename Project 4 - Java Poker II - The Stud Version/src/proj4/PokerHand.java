package proj4; // do not erase. Gradescope expects this.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Arrays;


/**
 * Class that models a standard poker hand
 * @author Neil Daterao
 */
public class PokerHand {
   
    
    private ArrayList<Card> pokerHandContents;
    private final int FIRSTVALIDCARDINDEX = 0; 
    private final int FLUSH = 4; 
    private final int TWOPAIR = 3; 
    private final int ONEPAIR = 2; 
    private final int HIGHCARD = 1; 
    private final int DEFAULTCARDRANK = 2; 
    public static final int MAXCARDSINPOKERHAND = 5; 

    
    /**
     * Non-default constructor. Intializes a poker hand of cards passed in as a parameter
     * @param cardList An ArrayList of cards objects
     */
    public PokerHand(ArrayList<Card> cardList) { 
        pokerHandContents = new ArrayList<Card>(); 
        for (Card card : cardList) {  pokerHandContents.add(card);  }
    }

    /**
     * Nothing will happen if poker hand already has 5 cards 
     * @param cardToBeAdded Card object that you want to add to the poker hand
     */
    public void addCard(Card cardToBeAdded){ 
        if (size() < MAXCARDSINPOKERHAND) { pokerHandContents.add(cardToBeAdded); }
    }
    
    /**
     * 
     * @return Integer representing the size of the poker hand
     */
    public int size() {
        return pokerHandContents.size(); 
    }

    /**
     * 
     * @param index Integer representing index of card. Index must be >= 0 and less than 5, the max cards in the hand. 
     * @return Card object at given index
     */
    public Card getIthCard(int index) { 
        try { 
            return pokerHandContents.get(index); 
        }
        catch(IndexOutOfBoundsException invalidIndex) { 
            return null; 
        }
    }

    /**
     * @return String version of the poker hand with one card per line
     */
    public String toString() { 
        String stringVersionOfPokerHand = ""; 
        for (int i = FIRSTVALIDCARDINDEX; i < size(); i++) {
            stringVersionOfPokerHand += getIthCard(i).toString() + "\n";
        }
        return stringVersionOfPokerHand; 
    }

   /**
    * A flush is if 5 cards in a poker hand have the same suit. Thus, if 4 cards have the same suit, the hand is not classified as a flush because a flush requires 5 cards. 
    * @return True if poker hand is a flush and false if not. 
    */
   private boolean isFlush(){
        Card firstCard = getIthCard(FIRSTVALIDCARDINDEX); 
        String previousSuit = firstCard.getSuit(); 
        for (Card card : pokerHandContents) { 
            if (!card.getSuit().equals(previousSuit)) { 
                return false;
            }
        }
        if (size() == MAXCARDSINPOKERHAND) { return true; }
        else { return false; }
   }
   
   /**
    * 
    * @return Integer returning the number of pairs in the poker hand
    */
   private int numberOfPairs() { 

        int[] rankOfCards = getRanksOfHandInArray(); 
        int pairs = 0; 

       
        Map<Integer, Integer> countOfRanks = ArrayUtilities.Counter(rankOfCards); 

        for (Integer rank : countOfRanks.keySet()) { 
            if (countOfRanks.get(rank).equals(4)) { pairs += 2; }
            else if (countOfRanks.get(rank) >= 2) { pairs += 1; }
            else { pairs += 0; }

        }

        return pairs; 
   }

   /**
    * 
    * @return Classification of hand as power ranking. 4: Flush 3: Two Pair 2: One pair 1: High Card
    */
   public int determineClassificationOfHand() { 
        if (isFlush()){ return FLUSH; }
        else if (numberOfPairs() == 2) { return TWOPAIR; }
        else if (numberOfPairs() == 1) { return ONEPAIR; }
        else { return HIGHCARD; }

   }

   /**
    * 
    * @return Ranks of Hand in an integer array. 
    */
   private int[] getRanksOfHandInArray() { 
       int[] ranksOfHandInArray = new int[size()];

       for (int i = FIRSTVALIDCARDINDEX; i < size(); i++) { 
            ranksOfHandInArray[i] = getIthCard(i).getRank();
       }
       return ranksOfHandInArray;  
    
   }
   /**
    * Function to determine which hand of two pairs is stronger
    * @param otherHand Another PokerHand Object which is classified as a two pair 
    * @return Will return 1 if this PokerHand is stronger, -1 if the otherHand PokerHand is stronger and 0 if they are of equal strength 
    */
   private int determineWinningTwoPair(PokerHand otherHand) { 
       ArrayList<Integer> pairsInThisHand = new ArrayList<Integer>(); 
       int extraCardRankInThisHand = DEFAULTCARDRANK;
       ArrayList<Integer> pairsInOtherHand = new ArrayList<Integer>();
       int extraCardRankInOtherHand = DEFAULTCARDRANK; 
       int maxIndex = 2; //Magic number but since the function is private it's okay! The reason for this magic number is to account for the fact that we're comparing two different pairs 

       int[] ranksInThisHand = getRanksOfHandInArray(); 
       int[] ranksInOtherHand = otherHand.getRanksOfHandInArray(); 

       Map<Integer, Integer> countsOfRanksInThisHand = ArrayUtilities.Counter(ranksInThisHand);
       Map<Integer, Integer> countsOfRanksInOtherHand = ArrayUtilities.Counter(ranksInOtherHand); 
       
       for (int rank : countsOfRanksInThisHand.keySet()) { 
           if (countsOfRanksInThisHand.get(rank) == 4) { 
               pairsInThisHand.add(rank);
               pairsInThisHand.add(rank); //Treat four of a kind as two "two-pairs"
           }
           else if (countsOfRanksInThisHand.get(rank) >= 2) { 
               pairsInThisHand.add(rank); 
           }
           else { extraCardRankInThisHand = rank; }
       }

       for (int rank : countsOfRanksInOtherHand.keySet()) { 
        if (countsOfRanksInOtherHand.get(rank) == 4) { 
            pairsInOtherHand.add(rank);
            pairsInOtherHand.add(rank);
        }
        else if (countsOfRanksInOtherHand.get(rank) >= 2) { 
            pairsInOtherHand.add(rank);
        }
        
        else { extraCardRankInOtherHand = rank; }
    }
        Collections.sort(pairsInThisHand, Comparator.reverseOrder());
        Collections.sort(pairsInOtherHand, Comparator.reverseOrder());
       
        for (int i=FIRSTVALIDCARDINDEX; i < maxIndex; i++) { 
            if (pairsInThisHand.get(i) > pairsInOtherHand.get(i)) { return 1; }
            else if (pairsInThisHand.get(i) < pairsInOtherHand.get(i)) { return -1; }
        }
        return extraCardRankInThisHand - extraCardRankInOtherHand; 
   }

   /**
    * Function to determine which hand of one pairs is stronger
    * @param otherHand Another PokerHand Object which is classified as One Pair
    * @return Will return 1 if this PokerHand is stronger, -1 if the otherHand PokerHand is stronger and 0 if they are of equal strength 
    */
   private int determineWinningOnePair(PokerHand otherHand) { 
        int pairInThisHand = DEFAULTCARDRANK;
        ArrayList<Integer> extraCardsInThisHand = new ArrayList<Integer>(); 
        int pairInOtherHand = DEFAULTCARDRANK;
        ArrayList<Integer> extraCardsInOtherHand = new ArrayList<Integer>();
        int maxIndex = 3; //Magic number again, but it's okay since it is a private function, this is to account for comparing three of a kind with one pair, the list of extra cards will be different lengths and we want to iterate through the smallest sorted array.

        int[] ranksInThisHand = getRanksOfHandInArray();
        int[] ranksInOtherHand = otherHand.getRanksOfHandInArray(); 

        Map<Integer, Integer> countsOfRanksInThisHand = ArrayUtilities.Counter(ranksInThisHand);
        Map<Integer, Integer> countsOfRanksInOtherHand = ArrayUtilities.Counter(ranksInOtherHand); 

        for (int rank : countsOfRanksInThisHand.keySet()) { 
            if (countsOfRanksInThisHand.get(rank) >= 2 ) { 
                pairInThisHand = rank;
            }
            else { extraCardsInThisHand.add(rank); }
        }

        for (int rank : countsOfRanksInOtherHand.keySet()) { 
            if (countsOfRanksInOtherHand.get(rank) >= 2 ) { 
                pairInOtherHand = rank;
            }
            else { extraCardsInOtherHand.add(rank); }
        }

        Collections.sort(extraCardsInThisHand, Comparator.reverseOrder());
        Collections.sort(extraCardsInOtherHand, Comparator.reverseOrder());
        
        if (extraCardsInThisHand.size() != extraCardsInOtherHand.size() || extraCardsInThisHand.size() == 2 || extraCardsInOtherHand.size() == 2) { maxIndex = 2; }

        if (pairInThisHand == pairInOtherHand) { 
            for (int i = FIRSTVALIDCARDINDEX; i < maxIndex; i++) {
                if (extraCardsInThisHand.get(i) > extraCardsInOtherHand.get(i)) { return 1; }
                else if (extraCardsInThisHand.get(i) < extraCardsInOtherHand.get(i)) { return -1; }
            }
        }

        return pairInThisHand - pairInOtherHand; 
   }

 /**
    * Function to determine which hand of High Cards is stronger
    * @param otherHand Another PokerHand Object which is classified as High Card
    * @return Will return 1 if this PokerHand is stronger, -1 if the otherHand PokerHand is stronger and 0 if they are of equal strength 
    */
   private int determineWinningHighCard(PokerHand otherHand) { 
        int[] ranksInThisHand = getRanksOfHandInArray();
        int[] ranksInOtherHand = otherHand.getRanksOfHandInArray(); 

        Arrays.sort(ranksInThisHand);
        Arrays.sort(ranksInOtherHand); 

        for (int i = size() - 1; i >= 0 ; i--) { 
            if (ranksInThisHand[i] > ranksInOtherHand[i]) { return 1; }
            else if (ranksInThisHand[i] < ranksInOtherHand[i]) { return -1; }

        }
        return 0; 
        
   }

   /**
    * Function to determine which hand of Flushes is stronger
    * @param otherHand Another PokerHand Object which is classified as a Flush
    * @return Will return 1 if this PokerHand is stronger, -1 if the otherHand PokerHand is stronger and 0 if they are of equal strength 
    */
   private int determineWinningFlush(PokerHand otherHand) { 
       //Since we alreay know this is a flush, we have to check the ranks of the card and we can use the same algorithm we used to check high cards. 
        return determineWinningHighCard(otherHand); 
   }
   
    /**
    * Determines how this hand compares to another hand, returns
    * positive, negative, or zero depending on the comparison.
    *
    * @param other The hand to compare this hand to
    * @return a negative number if this is worth LESS than other, zero
    * if they are worth the SAME, and a positive number if this is worth
    * MORE than other
    */
    public int compareTo(PokerHand other) { 
        
        if (determineClassificationOfHand() - other.determineClassificationOfHand() == 0) {
            if (determineClassificationOfHand() == FLUSH) { return determineWinningFlush(other); }
            else if (determineClassificationOfHand() == TWOPAIR) { return determineWinningTwoPair(other); }
            else if (determineClassificationOfHand() == ONEPAIR) { return determineWinningOnePair(other); }
            else if (determineClassificationOfHand() == HIGHCARD) { return determineWinningHighCard(other); }
       
        }
        return determineClassificationOfHand() - other.determineClassificationOfHand(); 
    }





}
