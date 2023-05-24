/**
 * Simulates a playing card with rank and suit
 */
public class Card
{
	/** All suits in play **/
	public static final String[] SUITS={"spades","clubs","hearts","diamonds"};
	
	/** All ranks in play **/
	public static final String[] RANKS ={"IGNORE","IGNORE","2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    public static final int MINRANK = 2;
    public static final int MAXRANK = 14;

	
    private int rank;
    private String suit;

    /**
     * Constructor. Card created with 1 int and 1 string.
     * 
     * @param newRank int between 2-14 (11=J, 12=Q, 13=K, 14=A)
     * @param newSuit suit as a string, like "spades"
     */
    public Card(int newRank, String newSuit)
    {
        rank = newRank;
        suit = newSuit.toLowerCase();
    }
    
    /**
     * Constructor. Card created with 2 ints.
     *
     * @param newRank int between 2-14 (11=J, 12=Q, 13=K, 14=A)
     * @param newSuit int between 0-3 (0=spades, 1=clubs, 2=hearts, 3=diamonds)
     */
    public Card(int newRank, int newSuit)
    {
        rank = newRank;
        suit = SUITS[newSuit];
    }

    /**
     * Getter for rank
     * 
     * @return 11 for Jack, 12 for Queen, 13 for King, 14 for Ace, rest are as numbered
     */
    public int getRank()
    {
        return rank;
    }
    
    /**
     * Getter for suit
     * 
     * @return "spades", "diamonds", "hearts", or "clubs"
     */
    public String getSuit()
    {
        return suit;
    }
    
    /**
     * Gives full name of card
     * @return full name of card, such as "Jack of clubs"
     */
    public String toString()
    {
        return RANKS[getRank()] + " of " + getSuit();
    }
}
