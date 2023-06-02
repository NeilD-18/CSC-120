package proj4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Poker game to determine the best hand given hole cards and community cards. 
 * @author Neil Daterao
 * @note I affirm that I have carried out the attached academic endeavors with full academic honesty, in
accordance with the Union College Honor Code and the course syllabus.
 */
public class Client {
    /**
     * 
     * Main Poker Game function
     */
    public static void main(String[] args) {
        String playAgain = "Y";
        Scanner inputChecker = new Scanner(System.in); 
        
        while (playAgain.equals("Y")) {
            
            System.out.println("Welcome to the Poker Hand Strength Guessing Game! Press return to get your first set of hands! \n");
            inputChecker.nextLine();
        
            Deck deckOfCards = new Deck(); 
            deckOfCards.shuffle();

            CommunityCardSet communityCards = generateCommunityCardSet(deckOfCards); 

            int totalPoints = 0; 
            boolean gameIsOver = false; 
            String[] acceptedAnswers = {"A", "B", "C"};

            while (deckOfCards.size() >= StudPokerHand.MAXCARDSINSTUDPOKERHAND * 2 && !gameIsOver) { 
                System.out.println("The Community Cards are:");
                System.out.println(communityCards + "\n");
                System.out.println("Which of the following hands are worth more?");
                
                ArrayList<Card> handAContents = getHoleCardsAsList(deckOfCards);
                ArrayList<Card> handBContents = getHoleCardsAsList(deckOfCards);

                StudPokerHand handA = new StudPokerHand(communityCards, handAContents);
                StudPokerHand handB = new StudPokerHand(communityCards, handBContents); 
                
                System.out.println("Hand A:");
                System.out.println(handA);
                System.out.println("   or   ");
                System.out.println("Hand B:");
                System.out.println(handB + "\n");
                System.out.println("Enter A or B (or C if it is a tie)");
                
                int expectedWinner = handA.compareTo(handB);
                System.out.println("Cheat" + expectedWinner); //To test
                String answer = inputChecker.nextLine().toUpperCase(); 
               

                while (!isValidAnswer(answer, acceptedAnswers)) {
                    System.out.println("Invalid Input!");
                    System.out.println("Enter A or B (or C if it is a tie)!");
                    answer = inputChecker.nextLine();
                }
                System.out.println("Got input: " + answer);

                if (answer.equals("A") && expectedWinner > 0) { 
                    totalPoints++; 
                    System.out.println("CORRECT!!!!!");
                    System.out.println("------------------------------------");
                }

                else if(answer.equals("B") && expectedWinner < 0) { 
                    totalPoints++; 
                    System.out.println("CORRECT!!!!!");
                    System.out.println("------------------------------------");
                }   

                else if(answer.equals("C") && expectedWinner == 0) { 
                    totalPoints++; 
                    System.out.println("CORRECT!!!!!");
                    System.out.println("------------------------------------");
                }

                else { 
                    System.out.println("THATS WRONG!!!!");
                    System.out.println("------------------------------------");
                    gameIsOver = true; 
                }
                
            }

            System.out.println("Game Over!");
            System.out.println("Total Points: " + totalPoints);

            System.out.println("Would you like to play again (Y/N)?");
            playAgain = inputChecker.nextLine(); 

            if (!playAgain.equals("Y")){
                System.out.println("Awh Bummer! Have a nice day!");
                inputChecker.close();
                return; 
            }
        }
        inputChecker.close();
        
    }
    /**
     * 
     * @param deckOfCards Deck object of deck of cards
     * @return CommunityCardSet object of the community cards
     */
    private static CommunityCardSet generateCommunityCardSet(Deck deckOfCards) { 
        CommunityCardSet communityCards = new CommunityCardSet(new ArrayList<Card>()); 
        int cardCount = 0; 
        while(cardCount < CommunityCardSet.MAXAMOUNTOFCOMMUNITYCARDS) { 
            Card cardToAdd = deckOfCards.deal();
            communityCards.addCard(cardToAdd);
            cardCount++; 
        }
        return communityCards; 
    }
    /**
     * 
     * @param answer Answer given
     * @param acceptedAnswers List of valid answers
     * @return True if answer is accepted and false if not
     */
    private static boolean isValidAnswer(String answer, String[] acceptedAnswers) {
        for (String acceptedAnswer : acceptedAnswers) {
            if (answer.equals(acceptedAnswer)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param deckOfCards Deck object of a deck of cards
     * @return ArrayList of card objects for the hole cards 
     */
    private static ArrayList<Card> getHoleCardsAsList(Deck deckOfCards) { 
        ArrayList<Card> holeCards = new ArrayList<Card>(); 
        int cardCount = 0; 
        while (cardCount < StudPokerHand.MAXCARDSINSTUDPOKERHAND) { 
            Card cardToAdd = deckOfCards.deal();
            holeCards.add(cardToAdd);
            cardCount++; 
        }
        return holeCards; 
    }

    

}
