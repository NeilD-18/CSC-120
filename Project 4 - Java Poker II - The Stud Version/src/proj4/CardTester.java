package proj4;

/**
 * Class which performs unit testing on the Card class
 * 
 * @author Neil Daterao
 */
public class CardTester {
    
    /**
     * Foreman function which calls all tests.
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
        Card cardWithRank3 = new Card(3, 3);
        int expected = 3; 
        int actual = cardWithRank3.getRank(); 
        Testing.assertEquals("Testing get rank with a card with rank 3", expected, actual);


        Card cardWithRank6 = new Card("SIX", "Hearts");
        expected = 6;
        actual = cardWithRank6.getRank();
        Testing.assertEquals("Testing get rank with a card with rank 6", expected, actual);

        Card cardWithRank4 = new Card("fOuR", "Diamonds");
        expected = 4;
        actual = cardWithRank4.getRank();
        Testing.assertEquals("Testing get rank with a card with rank 4", expected, actual);

        Card cardWithRankAceAsString = new Card("aCe", "Diamonds");
        expected = 14;
        actual = cardWithRankAceAsString.getRank();
        Testing.assertEquals("Testing get rank with a card with rank 14", expected, actual);

        Card cardWithRankAceAsInt = new Card(14, 3);
        expected = 14;
        actual = cardWithRankAceAsInt.getRank();
        Testing.assertEquals("Testing get rank with a card with rank 14", expected, actual);

        Card cardWithInvalidRank = new Card("twooo", "Diamonds");
        expected = 2;
        actual = cardWithInvalidRank.getRank();
        Testing.assertEquals("Testing get rank with an invalid rank, defaults to 2", expected, actual);
    
        
    }
    

    private static void testGetSuit() { 
        Card cardWithSuitDiamonds = new Card("four", "Diamonds"); 
        String expected = "Diamonds";
        String actual = cardWithSuitDiamonds.getSuit(); 
        Testing.assertEquals("Testing get suit with a card with suit Diamonds", expected, actual);

        Card cardWithSuitHearts = new Card(4, 1);
        String expectedHearts = "Hearts";
        String actualHearts = cardWithSuitHearts.getSuit();
        Testing.assertEquals("Testing get suit with a card with suit Hearts", expectedHearts, actualHearts);

        Card cardWithSuitSpades = new Card("7", "Spades");
        String expectedSpades = "Spades";
        String actualSpades = cardWithSuitSpades.getSuit();
        Testing.assertEquals("Testing get suit with a card with suit Spades", expectedSpades, actualSpades);

        Card cardWithSuitClubs = new Card(9, 2);
        String expectedClubs = "Clubs";
        String actualClubs = cardWithSuitClubs.getSuit();
        Testing.assertEquals("Testing get suit with a card with suit Clubs", expectedClubs, actualClubs);

    }
    
    
    private static void testToString() { 
        Card card3Clubs = new Card(3, 2);
        String expected = "3 of Clubs"; 
        String actual = card3Clubs.toString(); 
        Testing.assertEquals("Testing card of 3 of clubs", expected, actual);

        Card cardAceSpades = new Card("ACE", "Spades");
        String expectedAceSpades = "Ace of Spades";
        String actualAceSpades = cardAceSpades.toString();
        Testing.assertEquals("Testing card of Ace of Spades all caps", expectedAceSpades, actualAceSpades);

        Card cardKingDiamonds = new Card("kInG", "Diamonds");
        String expectedKingDiamonds = "King of Diamonds";
        String actualKingDiamonds = cardKingDiamonds.toString();
        Testing.assertEquals("Testing card of King of Diamonds, string", expectedKingDiamonds, actualKingDiamonds);

        Card cardQueenHearts = new Card(12, 1);
        String expectedQueenHearts = "Queen of Hearts";
        String actualQueenHearts = cardQueenHearts.toString();
        Testing.assertEquals("Testing card of Queen of Hearts, int ", expectedQueenHearts, actualQueenHearts);

        Card cardJackClubs = new Card("jAcK", "Clubs");
        String expectedJackClubs = "Jack of Clubs";
        String actualJackClubs = cardJackClubs.toString();
        Testing.assertEquals("Testing card of Jack of Clubs, case insensitive string", expectedJackClubs, actualJackClubs);

        Card card10Diamonds = new Card(10, 3);
        String expected10Diamonds = "10 of Diamonds";
        String actual10Diamonds = card10Diamonds.toString();
        Testing.assertEquals("Testing card of 10 of Diamonds, int", expected10Diamonds, actual10Diamonds);

        Card card6Spades = new Card(6, 0);
        String expected6Spades = "6 of Spades";
        String actual6Spades = card6Spades.toString();
        Testing.assertEquals("Testing card of 6 of Spades", expected6Spades, actual6Spades);

        Card cardInvalidInput = new Card("fifteen", "Charlie");
        String expectedDefaultCard = "2 of Spades"; 
        String actualDefaultCard = cardInvalidInput.toString(); 
        Testing.assertEquals("Testing card of invalid input strings", expectedDefaultCard, actualDefaultCard);

        Card cardInvalidInputIntegers = new Card(15, -1);
        String expectedDefaultCardIntegers = "2 of Spades"; 
        String actualDefaultCardIntegers = cardInvalidInputIntegers.toString(); 
        Testing.assertEquals("Testing card of invalid input input intgers", expectedDefaultCardIntegers, actualDefaultCardIntegers);

    }
    
}
