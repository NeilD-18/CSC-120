import java.util.ArrayList;

/**
 * @author Neil Daterao
 * @note I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus.
 */
public class ListProcessor
{
    /**
     * Swaps elements i and j in the given list.
     */
    private void swap(ArrayList<String> aList, int i, int j)
    {
        String tmp = aList.get(i);
        aList.set(i, aList.get(j));
        aList.set(j, tmp);
    }

    /**
     * Finds the minimum element of a list and returns it.
     * Non-destructive (That means this method should not change aList.)
     *
     * @param aList the list in which to find the minimum element.
     * @return the minimum element of the list.
     */
    public String getMin(ArrayList<String> aList)
    {
        return getMin(aList, 0 );
    }

    /**
     * Finds the minimum element of a list and returns it.
     * Non-destructive (That means this method should not change aList.)
     * Helper method for public getMin function
     *
     * @param aList the list in which to find the minimum element.
     * @param startingIndex starting index to search from
     * @return
     */
    private String getMin(ArrayList<String> aList, int startingIndex) {
        String currentMin = aList.get(startingIndex);
        String restOfListMin = new String();

       if (aList.size() - startingIndex == 1) {
            return aList.get(startingIndex);
       }
       else {
           restOfListMin = getMin(aList, startingIndex + 1);
           return (currentMin.compareTo(restOfListMin) < 0) ? currentMin : restOfListMin;
       }

    }


    /**
     * Finds the minimum element of a list and returns the index of that
     * element. If there is more than one instance of the minimum, then
     * the lowest index will be returned.  Non-destructive.
     *
     * @param aList the list in which to find the minimum element.
     * @return the index of the minimum element in the list.
     */
    public int getMinIndex(ArrayList<String> aList)
    {
        return getMinIndex(aList, 0, 1);
    }

    /**
     * Finds the minimum element of a list and returns the index of that
     * element. If there is more than one instance of the minimum, then
     * the lowest index will be returned.  Non-destructive.
     * @param aList the list in which to find the minimum element.
     * @param minIndex minimum index. to start, this is 0.
     * @param currentIndex current index. to start, this is 1.
     * @return
     */
    private int getMinIndex(ArrayList<String> aList, int minIndex, int currentIndex) {
        if (currentIndex >= aList.size()) {
            return minIndex;
        }

        else if (aList.get(currentIndex).compareTo(aList.get(minIndex)) < 0) {
            minIndex = currentIndex;
        }

        return getMinIndex(aList, minIndex, currentIndex + 1);

    }

    /**
     * Sorts a list in place. I.E. the list is modified so that it is in order.
     *
     * @param aList: the list to sort.
     */
    public void sort(ArrayList<String> aList)
    {
        sort(aList, 0);
    }

    /**
     * Selection sort algorithm for helper function of the public version of sort.
     *
     * @param aList the list to sort.
     * @param startingIndex Starting index of list
     */
    private void sort(ArrayList<String> aList, int startingIndex) {

        if (startingIndex == aList.size()) {
            return;
        }
        else {
            int minIndex = getMinIndex(aList, startingIndex, startingIndex+1);
            swap(aList, minIndex, startingIndex);
            sort(aList, startingIndex + 1);
        }

    }
}

    

