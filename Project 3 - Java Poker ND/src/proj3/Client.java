package proj3;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simple game where the user chooses which poker hand they think is stronger.
 * 
 * @author Neil Daterao
 */

public class Client {
    public static void main(String[] args) {
        String playAgain = "Y";
        
        while (playAgain.equals("Y")) {
            Scanner inputChecker = new Scanner(System.in); 
            
            System.out.println("Welcome to the poker strength test game! Press return to get your first set of hands! \n");
            inputChecker.nextLine();
        
            Deck deckOfCards = new Deck(); 
            deckOfCards.shuffle();
            int totalPoints = 0; 
            boolean gameIsOver = false; 

            while (deckOfCards.size() >= PokerHand.MAXCARDSINPOKERHAND * 2 && gameIsOver == false) { 
                ArrayList<Card> pokerHand = new ArrayList<Card>();
                ArrayList<Card> otherPokerHand = new ArrayList<Card>();

                for (int i = 0 ; i < PokerHand.MAXCARDSINPOKERHAND; i++) {
                    pokerHand.add(deckOfCards.deal());
                    otherPokerHand.add(deckOfCards.deal()); 
                }

                PokerHand pokerHandObj = new PokerHand(pokerHand); 
                PokerHand otherPokerHandObj = new PokerHand(otherPokerHand); 

                int expectedWinner = pokerHandObj.compareTo(otherPokerHandObj); 

                System.out.println("    Hand #1 \n");
                System.out.println("---------------");
                System.out.println(pokerHandObj);
                System.out.println("---------------");
                System.out.println("    Hand #2 \n");
                System.out.println(otherPokerHandObj);
                System.out.println("---------------");
                System.out.println("Cheat:" + expectedWinner); //-> To check while testing 
                
                System.out.println("Which hand do you think is stronger, 1 or 2? If you think it's a tie enter 0!");
                String answer = inputChecker.nextLine();

                String[] acceptedAnswers = {"0", "1", "2"}; 

                while (!isValidAnswer(answer, acceptedAnswers)) {
                    System.out.println("Invalid Input!");
                    System.out.println("Which hand do you think is stronger, 1 or 2? If you think it's a tie enter 0!");
                    answer = inputChecker.nextLine();
                }

                int chosenAnswer = Integer.parseInt(answer);
                if (chosenAnswer == 1 && expectedWinner > 0) {
                    totalPoints++;
                    System.out.println("\nGood job you got it right! Let's see if you can get the next set of hands right too!\n");
                } 
                else if (chosenAnswer == 2 && expectedWinner < 0) {
                    totalPoints++;
                    System.out.println("\nGood job you got it right! Let's see if you can get the next set of hands right too!\n");
                } 
                else if (chosenAnswer == 0 && expectedWinner == 0) {
                    totalPoints++;
                    System.out.println("\nGood job you got it right! Let's see if you can get the next set of hands right too!\n");
                } 
                else {
                    System.out.println("Incorrect!");
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

    }


    private static boolean isValidAnswer(String answer, String[] acceptedAnswers) {
        for (String acceptedAnswer : acceptedAnswers) {
            if (answer.equals(acceptedAnswer)) {
                return true;
            }
        }
        return false;
    }
}
