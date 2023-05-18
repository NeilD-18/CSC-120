package proj3; // do not erase. Gradescope expects this.

/**
 * Class to model a single playing card
 * 
 * @author Neil Datero
 */
public class Card {

    private int rank;
    private String suit; 
    private final int JACK = 11;
    private final int QUEEN = 12;
    private final int KING = 13;
    private final int ACE = 14;
    public static final String[] SUITS = {"Hearts", "Spades", "Diamonds", "Clubs"}; 
    public static final int[] RANKS = {2,3,4,5,6,7,8,9,10,11,12,13,14};
   
    /**
     * Non-default constructor for playing card
     * @param rankOfCard Rank of Card as an integer from 2-14
     * @param suitOfCard Suit of Card as a full string. i.e "Spades", "Hearts" etc.
     */
    public Card(int rankOfCard, String suitOfCard) { 
        rank = rankOfCard; 
        suit = suitOfCard; 
    }
    /**
     * Getter function for rank of card
     * @return Rank as an integer from 2-14
     */
    public int getRank() { 
        return rank; 
    }

    /**
     * Getter function for string of card
     * @return Suit as a string, "Hearts", "Spades", etc.
     */
    public String getSuit(){ 
        return suit; 
    }

    
    /**
     * Translates the rank into a string. If the rank is greater than 10, it will return the string version of the face card. 
     * @return Rank in a string form: 2-10 or "Hearts", "Spades" etc.
     */
    private String rankAsString() { 
        int cardRank = getRank(); 
        String rankAsString; 
        
        if (cardRank == JACK) { rankAsString = "Jack"; }
        else if (cardRank == QUEEN) { rankAsString = "Queen"; }
        else if (cardRank == KING) { rankAsString = "King"; }
        else if (cardRank == ACE) { rankAsString = "Ace"; }
        else { rankAsString = String.valueOf(cardRank); }
        
        return rankAsString; 
    }
    
    
    
    /**
     * Returns a string representation of the object.
     * @return Returns a string representation of the object.
     */
    public String toString(){ 
        return rankAsString() + " of " + getSuit();
    }


   
}
