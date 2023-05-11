import java.util.Random;
/**
 * Class for Die object and its methods
 * @author Neil Daterao
 */

public class Die {

    private int numSidesOfDie;
    private int currentValOfDie;
    private final int STARTINGVALOFDIE = 1;
    private final int DEFAULTSIDESOFDIE = 6;

    /**
     * Default constructor. Initializes die object with 6 sides
     */
    public Die(){
        numSidesOfDie = DEFAULTSIDESOFDIE;
        currentValOfDie = STARTINGVALOFDIE;
    }

    /**
     * Constructor for the die object which takes in a number of sides
     * @param numberOfSidesOfDie Integer representing the number of sides of the die
     */
    public Die(int numberOfSidesOfDie) {
        numSidesOfDie = numberOfSidesOfDie;
        currentValOfDie = STARTINGVALOFDIE;

    }

    /**
     * Method that rolls the die and updates the current value of the side it lands on
     */
    public void roll() {
        Random randomSide = new Random();
        int randomSideofDie = randomSide.nextInt(numSidesOfDie) + 1; //nextInt is from 0 to numSidesofDie - 1, thus add to max it from 1 to numSidesOfDie
        currentValOfDie = randomSideofDie;
    }

    /**
     * Gets the current value
     * @return Returns current value of die
     */
    public int getValue() {
        return currentValOfDie;
    }
}
