package proj3;

/**
 * Class which performs unit testing on the Card class
 * 
 * @author Neil Daterao
 */
public class CardTester {
    
    /**
     * Foreman function which calls all tests.
     * 
     */
    public static void main(String[] args) {
        Testing.setVerbose(true);
        Testing.startTests();
        Testing.testSection("Testing getRank");
        CardTester.testGetRank();
        Testing.testSection("Testing getSuit");
        CardTester.testGetSuit();
        Testing.testSection("Testing toString");
        CardTester.testToString();
        Testing.finishTests();
    }

    /**
     * Tests for getRank
     */
    private static void testGetRank(){
        Card cardWithRank3 = new Card(3, "Hearts");
        int expected = 3; 
        int actual = cardWithRank3.getRank(); 
        Testing.assertEquals("Testing get rank with a card with rank 3", expected, actual);


        Card cardWithRank6 = new Card(6, "Hearts");
        expected = 6;
        actual = cardWithRank6.getRank();
        Testing.assertEquals("Testing get rank with a card with rank 6", expected, actual);

        Card cardWithRank14 = new Card(14, "Diamonds");
        expected = 14;
        actual = cardWithRank14.getRank();
        Testing.assertEquals("Testing get rank with a card with rank 14", expected, actual);
    
        
    }

    /**
     * Test for getSuit
     */
    private static void testGetSuit() { 
        Card cardWithSuitDiamonds = new Card(4, "Diamonds"); 
        String expected = "Diamonds";
        String actual = cardWithSuitDiamonds.getSuit(); 
        Testing.assertEquals("Testing get suit with a card with suit Diamonds", expected, actual);

        Card cardWithSuitHearts = new Card(4, "Hearts");
        String expectedHearts = "Hearts";
        String actualHearts = cardWithSuitHearts.getSuit();
        Testing.assertEquals("Testing get suit with a card with suit Hearts", expectedHearts, actualHearts);

        Card cardWithSuitSpades = new Card(7, "Spades");
        String expectedSpades = "Spades";
        String actualSpades = cardWithSuitSpades.getSuit();
        Testing.assertEquals("Testing get suit with a card with suit Spades", expectedSpades, actualSpades);

        Card cardWithSuitClubs = new Card(9, "Clubs");
        String expectedClubs = "Clubs";
        String actualClubs = cardWithSuitClubs.getSuit();
        Testing.assertEquals("Testing get suit with a card with suit Clubs", expectedClubs, actualClubs);

    }

    /**
     * Tests for toString
     */
    private static void testToString() { 
        Card card3Clubs = new Card(3, "Clubs");
        String expected = "3 of Clubs"; 
        String actual = card3Clubs.toString(); 
        Testing.assertEquals("Testing card of 3 of clubs", expected, actual);

        Card cardAceSpades = new Card(14, "Spades");
        String expectedAceSpades = "Ace of Spades";
        String actualAceSpades = cardAceSpades.toString();
        Testing.assertEquals("Testing card of Ace of Spades", expectedAceSpades, actualAceSpades);

        Card cardKingDiamonds = new Card(13, "Diamonds");
        String expectedKingDiamonds = "King of Diamonds";
        String actualKingDiamonds = cardKingDiamonds.toString();
        Testing.assertEquals("Testing card of King of Diamonds", expectedKingDiamonds, actualKingDiamonds);

        Card cardQueenHearts = new Card(12, "Hearts");
        String expectedQueenHearts = "Queen of Hearts";
        String actualQueenHearts = cardQueenHearts.toString();
        Testing.assertEquals("Testing card of Queen of Hearts", expectedQueenHearts, actualQueenHearts);

        Card cardJackClubs = new Card(11, "Clubs");
        String expectedJackClubs = "Jack of Clubs";
        String actualJackClubs = cardJackClubs.toString();
        Testing.assertEquals("Testing card of Jack of Clubs", expectedJackClubs, actualJackClubs);

        Card card10Diamonds = new Card(10, "Diamonds");
        String expected10Diamonds = "10 of Diamonds";
        String actual10Diamonds = card10Diamonds.toString();
        Testing.assertEquals("Testing card of 10 of Diamonds", expected10Diamonds, actual10Diamonds);

        Card card6Spades = new Card(6, "Spades");
        String expected6Spades = "6 of Spades";
        String actual6Spades = card6Spades.toString();
        Testing.assertEquals("Testing card of 6 of Spades", expected6Spades, actual6Spades);
    }
}
