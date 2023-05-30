package proj4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 * Class to model a single playing card
 * 
 * @author Neil Datero
 */
public class Card {
    private int rankOfCard; 
    private String suitOfCard; 
    
    private final ArrayList<String> SUITS = new ArrayList<String>(Arrays.asList("Spades", "Hearts", "Clubs", "Diamonds")); 
    private final int RANKS[] = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    private final int JACK = 11;
    private final int QUEEN = 12;
    private final int KING = 13;
    private final int ACE = 14;
    private final int DEFAULTCARDRANK = 2; 
    private final String DEFAULTCARDSUIT = "Spades"; 
    private final int MINCARDRANK = 2;
    private final int MAXCARDRANK = 14; 
    private final Map<String, Integer> stringRankToIntMap = new HashMap<String, Integer>() {{
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9); 
        put("ten", 10); 
        put("jack", 11);
        put("queen", 12); 
        put("king", 13); 
        put("ace", 14); 
    }};

    /**
    * Constructor. If invalid rank or suit is given, will default to default rank and suit.
    * @param rank String: whole cards (2-10) can either be spelled
    * out like "two" or numeric like "2". Face cards will always be
    * spelled out like "Jack". Case insensitive.
    * @param suit String: "Spades", "Hearts", "Clubs", or "Diamonds"
    */
    public Card(String rank, String suit) {
        try { 
            rankOfCard = Integer.valueOf(rank);
            if (rankOfCard < MINCARDRANK || rankOfCard > MAXCARDRANK) { rankOfCard = DEFAULTCARDRANK; }
        }
        catch (NumberFormatException invalidStringForIntegerConversion ) { 
            String rankAsLowerCase = rank.toLowerCase();
            Integer rankAsInt = stringRankToIntMap.get(rankAsLowerCase); 
            if (rankAsInt != null) { 
                rankOfCard = rankAsInt; 
            }
            else { rankOfCard = DEFAULTCARDRANK; }
        }

        if (SUITS.contains(suit)) { suitOfCard = suit; }
        else { suitOfCard = DEFAULTCARDSUIT; }
    }

    /**
     * Constructor. If invalid rank or suit is given, will default to default rank and suit
     * @param rank integer between 2-14
     * @param suit integer: 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     */
    public Card(int rank, int suit) {
        if (rank >= MINCARDRANK && rank <= MAXCARDRANK) { rankOfCard = rank;  }
        else { rankOfCard = DEFAULTCARDRANK; }
        
        try { suitOfCard = SUITS.get(suit); }
        catch(IndexOutOfBoundsException invalidSuitIndex) { 
            suitOfCard = DEFAULTCARDSUIT; 
        }
        
    } 

    /**
     * 
     * @return Rank of Card as integer 2-14 (11: Jack, 12: Queen, 13: King, 14: Ace)
     */
    public int getRank() { 
       return rankOfCard;
    }

    /**
     * 
     * @return Suit of Card as a string: "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public String getSuit() { 
        return suitOfCard; 
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
