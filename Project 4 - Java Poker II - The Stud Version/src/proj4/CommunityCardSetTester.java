package proj4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that performs unit tests on Community Card Set class
 * @author Neil Daterao 
 */
public class CommunityCardSetTester {
    /**
     * 
     * Foreman function which runs all tests 
     */
    public static void main(String[] args) {
        Testing.setVerbose(true);
        Testing.startTests();
        Testing.testSection("Testing Add Card Method");
        CommunityCardSetTester.testAddCard();
        Testing.testSection("Testing GetIthCard Method");
        CommunityCardSetTester.testGetIthCard();
        Testing.testSection("Testing ToString");
        CommunityCardSetTester.testToString();
        Testing.finishTests();
    }

    private static void testAddCard() { 
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<Card>());
        Card cardToAdd = new Card(1,1); 
        communityCards.addCard(cardToAdd);
        int expected = 1; 
        int actual = communityCards.size();
        Testing.assertEquals("Testing add card method with first card", expected, actual);

        Card anotherCardToAdd = new Card(2,2); 
        communityCards.addCard(anotherCardToAdd);
        expected = 2;
        actual = communityCards.size();
        Testing.assertEquals("Testing add card method with second card", expected, actual);

        Card thirdCardToAdd = new Card(5,0); 
        Card fourthCardToAdd = new Card(3, 0);
        Card fifthCardToAdd = new Card(10,1); 
        Card additionalCardToAdd = new Card(7, 0); 

        communityCards.addCard(thirdCardToAdd);
        communityCards.addCard(fourthCardToAdd);
        communityCards.addCard(fifthCardToAdd);
        
        expected = 5;
        actual = communityCards.size();
        Testing.assertEquals("Testing add card method with fifth card", expected, actual);

        communityCards.addCard(additionalCardToAdd);
        actual = communityCards.size(); 
        Testing.assertEquals("Testing add card method with overloaded card", expected, actual);

    }


    private static void testGetIthCard() { 
        ArrayList<Card> communityCardContents= new ArrayList<Card>(Arrays.asList(
            new Card("14", "Hearts"), 
            new Card("14", "Spades"), 
            new Card("11", "Diamonds"), 
            new Card("4", "Spades"), 
            new Card("3", "Clubs"))); 
        
        CommunityCardSet communityCards = new CommunityCardSet(communityCardContents); 

        String expected = "Ace of Hearts";
        String actual = communityCards.getIthCard(0).toString(); 
        Testing.assertEquals("Testing getting ith card at 0th index", expected, actual);

        expected = "Jack of Diamonds";
        actual = communityCards.getIthCard(2).toString(); 
        Testing.assertEquals("Testing getting ith card at 2nd index", expected, actual);

        expected = "3 of Clubs";
        actual = communityCards.getIthCard(4).toString(); 
        Testing.assertEquals("Testing getting ith card at last index", expected, actual);

        expected = null;
        Card actualCard = communityCards.getIthCard(6);
        Testing.assertEquals("Testing getting ith card at invalid index", expected, actualCard);

        expected = null;
        actualCard = communityCards.getIthCard(-1);
        Testing.assertEquals("Testing getting ith card at invalid index", expected, actualCard);

    }

    private static void testToString() { 
        ArrayList<Card> firstCommunityCardContents= new ArrayList<Card>(Arrays.asList(
            new Card("aCe", "Hearts"), 
            new Card("14", "Spades"), 
            new Card("11", "Diamonds"), 
            new Card("4", "Spades"), 
            new Card("3", "Clubs"))); 
        CommunityCardSet firstCommunityCardSet = new CommunityCardSet(firstCommunityCardContents); 
        String expected = "Ace of Hearts | Ace of Spades | Jack of Diamonds | 4 of Spades | 3 of Clubs";
        String actual = firstCommunityCardSet.toString(); 
        Testing.assertEquals("Testing toString for first set of Community Cards", expected, actual);

        ArrayList<Card> secondCommunityCardContents= new ArrayList<Card>(Arrays.asList(
            new Card(1, 0), 
            new Card(-2,0), 
            new Card("11", "Diamonds"), 
            new Card("four", "Spades"), 
            new Card(3, 1))); 
        CommunityCardSet secondCommunityCardSet = new CommunityCardSet(secondCommunityCardContents); 
        expected = "2 of Spades | 2 of Spades | Jack of Diamonds | 4 of Spades | 3 of Hearts";
        actual = secondCommunityCardSet.toString();
        Testing.assertEquals("Testing toString for second set of community cards", expected, actual);
        
    }
}
