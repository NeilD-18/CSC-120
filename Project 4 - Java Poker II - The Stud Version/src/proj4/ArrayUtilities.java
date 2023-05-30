package proj4;

import java.util.HashMap;
import java.util.Map;

/**
 * Class with helpful Array Utilities, most notably "Counter". This has the same behavior as Counter from collections in Python.
 * 
 * @author Neil Daterao
 */
public class ArrayUtilities {
    /**
     * Counter is identical to the Counter from collections in Python. Java doesn't have it's own counter thus I created my own method. It returns a map where the key in the number and the value is the amount of occurances of the number.
     * @param listOfNums A list of integers 
     * @return Returns a map where the key in the number and the value is the amount of occurances of the number.
     */
    public static Map<Integer, Integer> Counter(int[] listOfNums){
        final Map<Integer, Integer> numPairedWithCount = new HashMap<>();

        for (int i = 0; i < listOfNums.length; i++) {   
            numPairedWithCount.put(listOfNums[i], numPairedWithCount.getOrDefault(listOfNums[i], 0) + 1); 
        }

        return numPairedWithCount; 
    }  
    
}
