import java.util.ArrayList;

/**
 * Driver for Lab 8
 *
 * @author Neil Daterao
 **/
public class DeckTests {

	public static void main(String[] args) {
		inOrder();
		shuffledOrder();
		dealThenShuffle();
		gatherTest();
		gatherRemainingTest();
	}
	
	/**
	 * Constructs a deck and prints what it deals (should be in order).
	 * This tests the constructor.
	 */
	public static void inOrder(){
		System.out.println("IN ORDER TEST");
		Deck deck1 = new Deck();
		deck1.printStats();
		dealAndPrint(deck1);
	}
	
	/**
	 * Constructs a deck, shuffles, and prints it.
	 * This tests the <code>shuffle</code> method to see if it shuffles all cards.
	 */
	public static void shuffledOrder(){
		System.out.println("SHUFFLED TEST");
		Deck deck2 = new Deck();
		deck2.shuffle();
		deck2.printStats(dealAndPrint(deck2));
	}
	
	/**
	 * Deals first 3 (ordered) cards, shuffles, then prints the rest.
	 * This tests the <code>shuffle</code> method to see if it shuffles remaining cards.
	 */
	public static void dealThenShuffle(){
		System.out.println("DEAL IN SORTED ORDER, THEN SHUFFLE THE REST");
		Deck deck3 = new Deck();
		System.out.println(deck3.deal());
		System.out.println(deck3.deal());
		System.out.println(deck3.deal());
		deck3.shuffle();
		deck3.printStats(dealAndPrint(deck3));
	}
		
	/**
	 * Deals an ordered deck, prints number left in deck (should be zero),
	 * gathers cards, prints number left in deck (should be all), and deals all.
	 * This tests the <code>gather</code> and <code>size</code> methods.
	 */
	public static void gatherTest(){
		System.out.println("GATHER METHOD TEST");
		Deck deck4 = new Deck();
		dealAndPrint(deck4);
		System.out.println("Before gathering, deck has " + deck4.size() + " cards.");
		deck4.printStats();
		deck4.gather();
		System.out.println("After gathering, deck now has " + deck4.size() + " cards.");
		deck4.printStats();
		dealAndPrint(deck4);
	}
	
	/**
	 * DECK TEST: Deals 3 cards from a shuffled deck, prints number left in deck (should be 49), 
	 * gathers cards, prints number left in deck (should be 52), and deals all (should be in order).
	 * This tests <code>gather</code> to see if it reorders the deck.
	 */
	public static void gatherRemainingTest(){
		System.out.println("GATHER REMAINING CARDS");
		Deck deck4 = new Deck();
		deck4.shuffle();
		System.out.println(deck4.deal());
		System.out.println(deck4.deal());
		System.out.println(deck4.deal());
		System.out.println("Dealt 3 cards. Before gathering, deck has " + deck4.size() + " cards.");
		deck4.printStats();
		deck4.gather();
		System.out.println("After gathering, deck now has " + deck4.size() + " cards and SHOULD be in order:");
		deck4.printStats(dealAndPrint(deck4));

	}
		
	/**
	 * Use this method to help you debug.  It will deal out all cards left in the deck.
	 * @param theDeck the deck to deal
	 * @return a list of the cards that you dealt in the order you dealt them
	 */
	public static ArrayList<Card> dealAndPrint(Deck theDeck){
		ArrayList<Card> cards = new ArrayList<Card>();
		System.out.println("dealing all cards:");
		System.out.println("------------------");
		if (theDeck.isEmpty()){
			System.out.println("### No cards in deck! ###");
		}
		while (!theDeck.isEmpty()){
			Card aCard = theDeck.deal();
			System.out.println(aCard);
			cards.add(aCard);
		}
		System.out.println();
		return cards;
	}

}
