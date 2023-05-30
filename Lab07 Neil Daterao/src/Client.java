import java.util.Scanner;
/**
 * Main game of die
 * @author Neil Daterao
 */
public class Client {

    public static void main(String[] args) {
        Die D6 = new Die();
        Die D12 = new Die(12);
        int currentValOfD6, currentValOfD12;
        Scanner inputChecker = new Scanner(System.in);

        System.out.println("Welcome to the game of Die! Press return to roll the dice!");
        inputChecker.nextLine();

        while (D12.getValue() != 2 * D6.getValue() && D6.getValue() != 2 * D12.getValue()) {
            D6.roll();
            D12.roll();
            currentValOfD6 = D6.getValue();
            currentValOfD12 = D12.getValue();
            System.out.println("Current Value of 6 Sided Die is: " + currentValOfD6);
            System.out.println("Current Value of 12 Sided Die is: " + currentValOfD12);
            System.out.println("Press Return to continue/roll again!");
            inputChecker.nextLine();
        }

        System.out.println("Game Over!");
        if (D12.getValue() == 2 * D6.getValue()) {System.out.println("D12 Wins!");}
        else {System.out.println("D6 Wins!"); }
        inputChecker.close();
    }
}
