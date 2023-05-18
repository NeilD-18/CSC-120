package proj3;

/**
 * Class which performs unit testing on the Deck class
 * 
 * @author Neil Daterao
 */
public class DeckTester {
    /**
     * 
     * Foreman function which runs all the tests
     */
    public static void main(String[] args) {
        Testing.setVerbose(true);
        Testing.startTests();
        Testing.testSection("Testing shuffle method");
        DeckTester.testShuffle();
        Testing.testSection("Testing deal method");
        DeckTester.testDeal();
        Testing.testSection("Testing isEmpty");
        DeckTester.testIsEmpty(); 
        Testing.testSection("Testing size method");
        DeckTester.testSize();
        Testing.testSection("Testing gather method");
        DeckTester.testGather();
        Testing.finishTests(); 

    }
  
    private static void testShuffle() { 
        Deck unshuffledDeck = new Deck(); 
        Deck shuffledDeck = new Deck();
        shuffledDeck.shuffle();
         
        Testing.assertTrue("Testing shuffle function", unshuffledDeck.toString() != shuffledDeck.toString());
    }

    private static void testDeal() { 
        Deck newDeck = new Deck(); 
        Card cardToBeDealt = newDeck.deal();
        String expected = "2 of Hearts";  //first card of deck
        Testing.assertEquals("Testing deal", expected, cardToBeDealt.toString());
        
        int i = 0; 
        while (i < Deck.MAXCARDAMOUNT - 1) { 
            cardToBeDealt = newDeck.deal();
            i++; 
        }
        expected = "Ace of Clubs"; //last card of deck
        Testing.assertEquals("Testing dealing of last card", expected, cardToBeDealt.toString());

        cardToBeDealt = newDeck.deal();
        expected = null; //no cards left to deal
        Testing.assertEquals("Testing to ensure null gets returned if no cards left", expected, cardToBeDealt);

    }

    private static void testIsEmpty(){
        Deck newDeck = new Deck(); 
        boolean actual = newDeck.isEmpty(); 
        Testing.assertFalse("Testing a non empty deck", actual);

        int i = 0; 
        while (i < Deck.MAXCARDAMOUNT) { 
            newDeck.deal();
            i++;
        }
        actual = newDeck.isEmpty();
        Testing.assertTrue("Testing an empty deck", actual); 
    }

    private static void testSize() { 
        Deck newDeck = new Deck();
        int expected = 52; 
        int actual = newDeck.size();
        Testing.assertEquals("Testing size of a full deck", expected, actual);

        newDeck.deal(); 
        expected = 51; 
        actual = newDeck.size();
        Testing.assertEquals("Testing size of a deck without one card", expected, actual);

        int i = 0; 
        while (i < 50) { 
            newDeck.deal();
            i++;
        }
        expected = 1; 
        actual = newDeck.size();
        Testing.assertEquals("Testing size of a deck with one card", expected, actual);

        newDeck.deal(); 
        expected = 0; 
        actual = newDeck.size();
        Testing.assertEquals("Testing size of a deck with no cards", expected, actual);
    }

    private static void testGather(){
        Deck newDeck = new Deck();
        int i = 0; 
        while (i < 50) { 
            newDeck.deal();
            i++;
        }
        newDeck.gather();
        int expected = 52; 
        int actual = newDeck.size(); 
        Testing.assertEquals("Testing gathering all the cards after they've been dealt", expected, actual);
    }
}
