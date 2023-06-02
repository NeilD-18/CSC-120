package proj4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that runs unit tests on Stud Poker Hand class. 
 * @author Neil Daterao 
 */
public class StudPokerHandTester {
    /**
     * 
     * Foreman function which runs all tests 
     */
    public static void main(String[] args) {
        Testing.setVerbose(true);
        Testing.startTests();
        Testing.testSection("Testing Add Card Method");
        StudPokerHandTester.testAddCard();
        Testing.testSection("Testing GetIthCard Method");
        StudPokerHandTester.testGetIthCard();
        Testing.testSection("Testing ToString");
        StudPokerHandTester.testToString();
        Testing.testSection("Testing CompareTo Method");
        StudPokerHandTester.testCompareTo();
        Testing.finishTests();
    }

    
    
    private static void testAddCard() { 
        StudPokerHand holeCards = new StudPokerHand(new CommunityCardSet(new ArrayList<Card>()), new ArrayList<Card>());
        Card cardToAdd = new Card(1,1); 
        holeCards.addCard(cardToAdd);
        int expected = 1; 
        int actual = holeCards.size();
        Testing.assertEquals("Testing add card method with first card", expected, actual);

        Card anotherCardToAdd = new Card(2,2); 
        holeCards.addCard(anotherCardToAdd);
        expected = 2;
        actual = holeCards.size();
        Testing.assertEquals("Testing add card method with second card", expected, actual);

        Card thirdCardToAdd = new Card(5,0); 
        holeCards.addCard(thirdCardToAdd);
        actual = holeCards.size();
        Testing.assertEquals("Testing add card method with overloaded card", expected, actual);

    }

    private static void testGetIthCard() { 
        ArrayList<Card> holeCardContents= new ArrayList<Card>(Arrays.asList(
            new Card("11", "Diamonds"),  
            new Card("3", "Clubs"))); 
        
        StudPokerHand holeCards = new StudPokerHand(new CommunityCardSet(new ArrayList<Card>()), holeCardContents);

        String expected = "Jack of Diamonds";
        String actual = holeCards.getIthCard(0).toString(); 
        Testing.assertEquals("Testing getting ith card at 0th index", expected, actual);

        expected = "3 of Clubs";
        actual = holeCards.getIthCard(1).toString(); 
        Testing.assertEquals("Testing getting ith card at 1st/last index", expected, actual);

        expected = null;
        Card actualCard = holeCards.getIthCard(2);
        Testing.assertEquals("Testing getting ith card at invalid index", expected, actualCard);

        expected = null;
        actualCard = holeCards.getIthCard(-1);
        Testing.assertEquals("Testing getting ith card at invalid index", expected, actualCard);

    }

    private static void testToString() { 
        ArrayList<Card> holeCardContents= new ArrayList<Card>(Arrays.asList(
            new Card("11", "Diamonds"),  
            new Card("3", "Clubs"))); 
        
        StudPokerHand holeCards = new StudPokerHand(new CommunityCardSet(new ArrayList<Card>()), holeCardContents);
        String expected = "Jack of Diamonds, 3 of Clubs";
        String actual = holeCards.toString(); 
        Testing.assertEquals("Testing Two String with first two hole cards", expected, actual);

        ArrayList<Card> anotherHoleCardContents= new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Diamonds"),  
            new Card(2, 0))); 
        
        StudPokerHand otherHoleCards = new StudPokerHand(new CommunityCardSet(new ArrayList<Card>()), anotherHoleCardContents);
        expected = "Ace of Diamonds, 2 of Spades"; 
        actual = otherHoleCards.toString(); 
        Testing.assertEquals("Testing Two String with other two hole cards", expected, actual);


    }

    private static void testCompareTo() { 
        StudPokerHandTester.testSameCommunityCardsAsBestHand(); 
        StudPokerHandTester.testSameCommunityCardsThisHandWins();
        StudPokerHandTester.testSameCommunityCardsOtherHandWins();
        StudPokerHandTester.testDiffCCTwoPair107and77();
        StudPokerHandTester.testHandWithBetterHoleLosesToFlush();
        StudPokerHandTester.testOnePairTie();
        StudPokerHandTester.testHighCardFlushWin();
        StudPokerHandTester.testHighCardWin(); 
    }

    private static void testSameCommunityCardsAsBestHand() { 
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Spades"),
            new Card("King", "Spades"),
            new Card("Jack", "Spades"),
            new Card("Queen", "Spades"),
            new Card(10,0)
        )));
        StudPokerHand thisPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Hearts"),
            new Card("Ace", "Diamonds"))));
        
        StudPokerHand otherPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("King", "Hearts"),
            new Card("King", "Diamonds"))));

        int expected = 0; 
        int actual = thisPokerHand.compareTo(otherPokerHand); 
        Testing.assertEquals("Test the Same Community Cards being the best hand", expected, actual);
    }

    private static void testSameCommunityCardsThisHandWins() { 
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Jack", "Clubs"),
            new Card("Queen", "Diamonds"),
            new Card(10,0)
        )));
        StudPokerHand thisPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Clubs"),
            new Card("Ace", "Diamonds"))));
        
        StudPokerHand otherPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("King", "Hearts"),
            new Card("Queen", "Spades"))));

        int expected = -1; 
        int actual = thisPokerHand.compareTo(otherPokerHand); 
        Testing.assertEquals("Test the Same Community Cards, hand 1 wins, higher 3 of a kind", expected, actual);
    }

    private static void testSameCommunityCardsOtherHandWins() { 
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Jack", "Clubs"),
            new Card("Queen", "Diamonds"),
            new Card(10,0)
        )));
        StudPokerHand thisPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Clubs"),
            new Card("Ace", "Diamonds"))));
        
        StudPokerHand otherPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("King", "Hearts"),
            new Card("King", "Spades"))));

        int expected = 1; 
        int actual = thisPokerHand.compareTo(otherPokerHand); 
        Testing.assertEquals("Test the Same Community Cards, hand 2 wins, 3 of a kind v 2 pair", expected, actual);
    }

    private static void testDiffCCTwoPair107and77() { 
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("7", "Clubs"),
            new Card("Queen", "Diamonds"),
            new Card(10,0)
        )));

        CommunityCardSet otherCommunityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("7", "Clubs"),
            new Card("7", "Diamonds"),
            new Card(10,0)
        )));
        StudPokerHand thisPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("10", "Clubs"),
            new Card("7", "Diamonds"))));
        
        StudPokerHand otherPokerHand = new StudPokerHand(otherCommunityCards, new ArrayList<Card>(Arrays.asList(
            new Card("7", "Hearts"),
            new Card("7", "Spades"))));

        int expected = 1; 
        int actual = thisPokerHand.compareTo(otherPokerHand); 
        Testing.assertEquals("Test Different Community Cards, hand 1 wins, 2 pair 10-7 v 4-of-a-kind 7", expected, actual);
    }

    private static void testHandWithBetterHoleLosesToFlush() { 
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Spades"),
            new Card("King", "Spades"),
            new Card("7", "Diamonds"),
            new Card("Queen", "Diamonds"),
            new Card(10,0)
        )));

        CommunityCardSet otherCommunityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Hearts"),
            new Card("King", "Hearts"),
            new Card("7", "Hearts"),
            new Card("7", "Diamonds"),
            new Card(10,0)
        )));
        StudPokerHand thisPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("14", "Clubs"),
            new Card("14", "Diamonds"))));
        
        StudPokerHand otherPokerHand = new StudPokerHand(otherCommunityCards, new ArrayList<Card>(Arrays.asList(
            new Card("6", "Hearts"),
            new Card("8", "Hearts"))));
        
        int expected = -2;
        int actual = thisPokerHand.compareTo(otherPokerHand); 
        Testing.assertEquals("Test Different Community Cards, better hole cards lose to flush", expected, actual);

    }

    private static void testOnePairTie(){
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Spades"),
            new Card("King", "Spades"),
            new Card("7", "Diamonds"),
            new Card("Queen", "Diamonds"),
            new Card(10,0)
        )));

        CommunityCardSet otherCommunityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Hearts"),
            new Card("King", "Hearts"),
            new Card("7", "Hearts"),
            new Card("Queen", "Diamonds"),
            new Card(10,0)
        )));
        StudPokerHand thisPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("10", "Clubs"),
            new Card("8", "Diamonds"))));
        
        StudPokerHand otherPokerHand = new StudPokerHand(otherCommunityCards, new ArrayList<Card>(Arrays.asList(
            new Card("10", "Diamonds"),
            new Card("2", "Hearts"))));
        
        int expected = 0;
        int actual = thisPokerHand.compareTo(otherPokerHand); 
        Testing.assertEquals("Test Different Community Cards, tie on one pair", expected, actual);

    }   

    private static void testHighCardFlushWin() { 
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Spades"),
            new Card("King", "Spades"),
            new Card("7", "Spades"),
            new Card("Queen", "Diamonds"),
            new Card(10,1)
        )));

        CommunityCardSet otherCommunityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("Ace", "Hearts"),
            new Card("King", "Hearts"),
            new Card("7", "Hearts"),
            new Card("7", "Diamonds"),
            new Card(10,0)
        )));
        StudPokerHand thisPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("10", "Spades"),
            new Card("8", "Spades"))));
        
        StudPokerHand otherPokerHand = new StudPokerHand(otherCommunityCards, new ArrayList<Card>(Arrays.asList(
            new Card("10", "Hearts"),
            new Card("9", "Hearts"))));
        
        int expected = -1;
        int actual = thisPokerHand.compareTo(otherPokerHand); 
        Testing.assertEquals("Test Different Community Cards, other hand wins on high card flush", expected, actual);

    }

    private static void testHighCardWin() { 
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("2", "Spades"),
            new Card("3", "Clubs"),
            new Card("4", "Diamonds"),
            new Card("5", "Diamonds"),
            new Card(6,0)
        )));

        CommunityCardSet otherCommunityCards = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(
            new Card("4", "Hearts"),
            new Card("3", "Spades"),
            new Card("2", "Hearts"),
            new Card("5", "Diamonds"),
            new Card(6,0)
        )));
        StudPokerHand thisPokerHand = new StudPokerHand(communityCards, new ArrayList<Card>(Arrays.asList(
            new Card("14", "Clubs"),
            new Card("7", "Diamonds"))));
        
        StudPokerHand otherPokerHand = new StudPokerHand(otherCommunityCards, new ArrayList<Card>(Arrays.asList(
            new Card("14", "Hearts"),
            new Card("8", "Hearts"))));
        
        int expected = -1;
        int actual = thisPokerHand.compareTo(otherPokerHand); 
        Testing.assertEquals("Test Different Community Cards, other hand has better high card", expected, actual);

    }
}


