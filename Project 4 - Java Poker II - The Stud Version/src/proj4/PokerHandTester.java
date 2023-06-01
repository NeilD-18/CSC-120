package proj4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class which performs unit testing on the PokerHand class
 * 
 * @author Neil Daterao
 */
public class PokerHandTester{
    
    public static void main(String[] args) {
        Testing.setVerbose(true);
        Testing.startTests();
        Testing.testSection("Testing compareTo method");
        PokerHandTester.testCompareTo();
        Testing.testSection("Testing addCard method");
        PokerHandTester.testAddCard();
        Testing.testSection("Testing getIthCard method");
        PokerHandTester.testgetIthCard();
        Testing.finishTests();

    }

    private static void testAddCard() { 
        PokerHand pokerHandObj = new PokerHand(new ArrayList<Card>()); 
        Card cardToAdd = new Card("4", "Diamonds"); 
        pokerHandObj.addCard(cardToAdd);
        int expected = 1; 
        int actual = pokerHandObj.size(); 
        Testing.assertEquals("Testing adding a card to an empty hand", expected, actual);

        Card anotherCardToAdd = new Card("Ace", "Spades");
        pokerHandObj.addCard(anotherCardToAdd);
        expected = 2; 
        actual = pokerHandObj.size(); 
        Testing.assertEquals("Testing adding a card to a hand with 1 card", expected, actual);

        pokerHandObj.addCard(new Card(1, 3));
        pokerHandObj.addCard(new Card(7, 3));
        pokerHandObj.addCard(new Card(3, 3));

        
        Card add6thCard = new Card("Jack", "Clubs");
        pokerHandObj.addCard(add6thCard); 
        expected = 5;
        actual = pokerHandObj.size();
        Testing.assertEquals("Testing adding a card to a hand with 5 cards", expected, actual);

    }

    private static void testgetIthCard() { 
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("14", "Hearts"), 
            new Card("14", "Spades"), 
            new Card("11", "Diamonds"), 
            new Card("4", "Spades"), 
            new Card("3", "Clubs"))); 
        
        PokerHand pokerHandObj = new PokerHand(pokerHand); 
        String expected = "Ace of Hearts";
        String actual = pokerHandObj.getIthCard(0).toString(); 
        Testing.assertEquals("Testing getting ith card at 0th index", expected, actual);

        expected = "Jack of Diamonds";
        actual = pokerHandObj.getIthCard(2).toString(); 
        Testing.assertEquals("Testing getting ith card at 2nd index", expected, actual);

        expected = "3 of Clubs";
        actual = pokerHandObj.getIthCard(4).toString(); 
        Testing.assertEquals("Testing getting ith card at last index", expected, actual);

        expected = null;
        Card actualCard = pokerHandObj.getIthCard(6);
        Testing.assertEquals("Testing getting ith card at invalid index", expected, actualCard);

        expected = null;
        actualCard = pokerHandObj.getIthCard(-1);
        Testing.assertEquals("Testing getting ith card at invalid index", expected, actualCard);
        
    }
    
    
    private static void testCompareTo() { 
        PokerHandTester.testOnePair4vAce();
        PokerHandTester.testTwoPair94v93();
        PokerHandTester.testOnePairAceHighCardWin(); 
        PokerHandTester.testTwoPair58v76();
        PokerHandTester.testTwoPairOfSameDiffHighCard();
        PokerHandTester.test9HighFlushv6HighFlush();
        PokerHandTester.testKing107FlushvKing105Flush();
        PokerHandTester.testFlushActualTie();
        PokerHandTester.testHighCardTie();
        PokerHandTester.testTwoPairTie();
        PokerHandTester.testOnePairTie();
        PokerHandTester.testFlushVHighCard();
        PokerHandTester.testTwoPairvOnePair();
        PokerHandTester.testFullHousevStraight();
        PokerHandTester.testRoyalFlushvStraightFlush();
        PokerHandTester.testFourOfAKindV2Pair();
        PokerHandTester.testHighCardTieUpToThirdCard();
        PokerHandTester.testOnePairTieTillFourthCard();
        PokerHandTester.testThreeOfAKindVsTwoPair();



    }

    private static void testOnePair4vAce() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("14", "Hearts"), 
            new Card("14", "Spades"), 
            new Card("11", "Diamonds"), 
            new Card("4", "Spades"), 
            new Card("3", "Clubs"))); 
        
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("4", "Hearts"), 
            new Card("4", "Spades"), 
            new Card("11", "Diamonds"), 
            new Card("2", "Spades"), 
            new Card("3", "Clubs"))); 
        
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand); 
        int expected = 10;
        int actual = pokerHandObj.compareTo(otherPokerHandObj); 
        Testing.assertEquals("Testing one pair, aces v 4s", expected, actual);
    }

    private static void testTwoPair94v93() {
        ArrayList<Card> pokerHand2 = new ArrayList<Card>(Arrays.asList(
            new Card("9", "Hearts"),
            new Card("9", "Spades"),
            new Card("4", "Diamonds"),
            new Card("4", "Spades"),
            new Card("3", "Clubs")
        ));
        ArrayList<Card> otherPokerHand2 = new ArrayList<Card>(Arrays.asList(
            new Card("9", "Diamonds"),
            new Card("9", "Clubs"),
            new Card("5", "Spades"),
            new Card("3", "Hearts"),
            new Card("3", "Spades")
        ));
        PokerHand PokerHandObj2 = new PokerHand(pokerHand2);
        PokerHand otherPokerHandObj2 = new PokerHand(otherPokerHand2);
        int expected = 1; 
        int actual = PokerHandObj2.compareTo(otherPokerHandObj2);
        Testing.assertEquals("Testing two pairs, 9s and 4s vs 9s and 3s", expected, actual);
    }

    private static void testOnePairAceHighCardWin() { 
        ArrayList<Card> pokerHand3 = new ArrayList<Card>(Arrays.asList(
            new Card("14", "Hearts"),
            new Card("14", "Spades"),
            new Card("10", "Diamonds"),
            new Card("7", "Spades"),
            new Card("2", "Clubs")
        ));
        ArrayList<Card> otherPokerHand3 = new ArrayList<Card>(Arrays.asList(
            new Card("14", "Diamonds"),
            new Card("14", "Clubs"),
            new Card("11", "Spades"),
            new Card("8", "Hearts"),
            new Card("3", "Spades")
        ));
        PokerHand pokerHandObj3 = new PokerHand(pokerHand3);
        PokerHand otherPokerHandObj3 = new PokerHand(otherPokerHand3);
        int expected = -1; 
        int actual = pokerHandObj3.compareTo(otherPokerHandObj3);
        Testing.assertEquals("Testing two pairs of Aces with high cards determining the winner", expected, actual);
    }

    private static void testTwoPair58v76() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("5", "Hearts"),
            new Card("5", "Spades"),
            new Card("8", "Diamonds"),
            new Card("8", "Spades"),
            new Card("10", "Clubs")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("7", "Diamonds"),
            new Card("7", "Clubs"),
            new Card("6", "Spades"),
            new Card("6", "Hearts"),
            new Card("3", "Diamonds")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 1; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing two pairs of 5 and 8 vs 7 and 6", expected, actual);
    }

    private static void testTwoPairOfSameDiffHighCard() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("8", "Spades"),
            new Card("8", "Hearts"),
            new Card("7", "Diamonds"),
            new Card("7", "Clubs"),
            new Card("10", "Spades")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("8", "Diamonds"),
            new Card("8", "Clubs"),
            new Card("7", "Spades"),
            new Card("7", "Hearts"),
            new Card("11", "Diamonds")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = -1;
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing two pairs with same pairs but different high cards", expected, actual);
    }
    
    private static void test9HighFlushv6HighFlush() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Clubs"),
            new Card("3", "Clubs"),
            new Card("4", "Clubs"),
            new Card("5", "Clubs"),
            new Card("9", "Clubs")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("4", "Spades"),
            new Card("7", "Spades"),
            new Card("8", "Spades"),
            new Card("2", "Spades"),
            new Card("6", "Spades")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 1; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing 9-high flush vs 6-high flush", expected, actual);
    }
    
    private static void testKing107FlushvKing105Flush() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("10", "Hearts"),
            new Card("7", "Hearts"),
            new Card("3", "Hearts"),
            new Card("2", "Hearts"),
            new Card("4", "Hearts")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("10", "Diamonds"),
            new Card("5", "Diamonds"),
            new Card("4", "Diamonds"),
            new Card("2", "Diamonds"),
            new Card("6", "Diamonds")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 1; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing King-10-7 flush vs King-10-5 flush", expected, actual);
    }
    
    private static void testFlushActualTie() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Hearts"),
            new Card("4", "Hearts"),
            new Card("6", "Hearts"),
            new Card("8", "Hearts"),
            new Card("10", "Hearts")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Diamonds"),
            new Card("4", "Diamonds"),
            new Card("6", "Diamonds"),
            new Card("8", "Diamonds"),
            new Card("10", "Diamonds")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 0;
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing actual tie with flush", expected, actual);
    }
    
    private static void testHighCardTie() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Hearts"),
            new Card("4", "Diamonds"),
            new Card("6", "Spades"),
            new Card("8", "Clubs"),
            new Card("10", "Hearts")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Clubs"),
            new Card("4", "Hearts"),
            new Card("6", "Diamonds"),
            new Card("8", "Spades"),
            new Card("10", "Clubs")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 0; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing high card tie", expected, actual);
    }
    
    private static void testTwoPairTie() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("3", "Hearts"),
            new Card("3", "Spades"),
            new Card("6", "Diamonds"),
            new Card("6", "Spades"),
            new Card("10", "Clubs")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("3", "Diamonds"),
            new Card("3", "Clubs"),
            new Card("6", "Hearts"),
            new Card("6", "Clubs"),
            new Card("10", "Spades")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 0; // Assuming both hands have the same two pair
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing two pair tie", expected, actual);
    }
    
    private static void testOnePairTie() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Hearts"),
            new Card("2", "Spades"),
            new Card("4", "Diamonds"),
            new Card("6", "Spades"),
            new Card("10", "Clubs")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Diamonds"),
            new Card("2", "Clubs"),
            new Card("4", "Hearts"),
            new Card("6", "Clubs"),
            new Card("10", "Spades")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 0; // Assuming both hands have the same pair
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing one pair tie", expected, actual);
    }
    
    private static void testFlushVHighCard() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Hearts"),
            new Card("4", "Hearts"),
            new Card("6", "Hearts"),
            new Card("8", "Hearts"),
            new Card("10", "Hearts")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Clubs"),
            new Card("4", "Diamonds"),
            new Card("6", "Spades"),
            new Card("8", "Clubs"),
            new Card("10", "Spades")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 3; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing flush vs high card", expected, actual);
    }
    
    private static void testTwoPairvOnePair() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("5", "Hearts"),
            new Card("5", "Spades"),
            new Card("8", "Diamonds"),
            new Card("8", "Spades"),
            new Card("10", "Clubs")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("5", "Diamonds"),
            new Card("5", "Clubs"),
            new Card("7", "Spades"),
            new Card("9", "Hearts"),
            new Card("3", "Diamonds")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 1; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing two pair vs one pair", expected, actual);
    }
    
    private static void testFullHousevStraight() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("7", "Hearts"),
            new Card("7", "Spades"),
            new Card("7", "Diamonds"),
            new Card("4", "Spades"),
            new Card("4", "Clubs")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("5", "Diamonds"),
            new Card("6", "Clubs"),
            new Card("7", "Spades"),
            new Card("8", "Hearts"),
            new Card("9", "Spades")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 2; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing full house vs straight", expected, actual);
    }
    
    private static void testRoyalFlushvStraightFlush() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("10", "Hearts"),
            new Card("11", "Hearts"),
            new Card("12", "Hearts"),
            new Card("13", "Hearts"),
            new Card("14", "Hearts")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("7", "Spades"),
            new Card("8", "Spades"),
            new Card("9", "Spades"),
            new Card("10", "Spades"),
            new Card("11", "Spades")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 1; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing royal flush vs straight flush", expected, actual);
    }
    
    private static void testFourOfAKindV2Pair() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("6", "Hearts"),
            new Card("6", "Spades"),
            new Card("6", "Diamonds"),
            new Card("6", "Clubs"),
            new Card("9", "Clubs")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("8", "Diamonds"),
            new Card("8", "Clubs"),
            new Card("7", "Spades"),
            new Card("7", "Hearts"),
            new Card("3", "Spades")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = -1; // Assuming the second hand has two pairs
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing four of a kind vs two pair", expected, actual);
    }
    
    private static void testHighCardTieUpToThirdCard() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Hearts"),
            new Card("4", "Diamonds"),
            new Card("6", "Spades"),
            new Card("8", "Clubs"),
            new Card("10", "Hearts")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Clubs"),
            new Card("4", "Hearts"),
            new Card("6", "Diamonds"),
            new Card("9", "Spades"),
            new Card("10", "Clubs")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = -1; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing high card tie up to the third card", expected, actual);
    }
    
    private static void testOnePairTieTillFourthCard() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Hearts"),
            new Card("2", "Spades"),
            new Card("4", "Diamonds"),
            new Card("6", "Spades"),
            new Card("10", "Clubs")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("2", "Diamonds"),
            new Card("2", "Clubs"),
            new Card("4", "Hearts"),
            new Card("6", "Clubs"),
            new Card("9", "Spades")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = 1; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing one pair tie up to the fourth card", expected, actual);
    }
    
    private static void testThreeOfAKindVsTwoPair() {
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("7", "Hearts"),
            new Card("7", "Spades"),
            new Card("7", "Diamonds"),
            new Card("4", "Spades"),
            new Card("4", "Clubs")
        ));
        ArrayList<Card> otherPokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("5", "Diamonds"),
            new Card("5", "Clubs"),
            new Card("7", "Spades"),
            new Card("7", "Hearts"),
            new Card("9", "Spades")
        ));
        PokerHand pokerHandObj = new PokerHand(pokerHand);
        PokerHand otherPokerHandObj = new PokerHand(otherPokerHand);
        int expected = -1; 
        int actual = pokerHandObj.compareTo(otherPokerHandObj);
        Testing.assertEquals("Testing three of a kind vs two pair", expected, actual);
    }



}
