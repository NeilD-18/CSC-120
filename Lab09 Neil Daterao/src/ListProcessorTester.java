import java.util.ArrayList;
import java.util.Arrays;

public class ListProcessorTester
{
    public static void main(String [] args)
    {
        Testing.setVerbose(true);
        Testing.startTests();
        getMinTests();
        getMinIndexTests();
        //sortTests();
        Testing.finishTests();
    }

    /**
     * turns an array of strings into an ArrayList
     */
    private static ArrayList<String> array2arraylist(String[] strings){
        return new ArrayList<String>(Arrays.asList(strings));
    }

    public static void getMinTests() {
        Testing.testSection("Testing getMin");

        ListProcessor lp = new ListProcessor();

        String[] strings = {"b", "e", "a", "d", "g", "k", "c", "r", "t", "v", "a", "c", "b"};
        ArrayList<String> originalList = array2arraylist(strings);
        ArrayList<String> copy = new ArrayList<String>(originalList);
        // makes a copy of originalList

        String actual = lp.getMin(copy);
        Testing.assertEquals("The minimum of a list of strings is the first in alphabetical order",
                "a",
                actual);

        Testing.assertEquals("getMin should not modify the list",
                originalList,
                copy);

        actual = lp.getMin(array2arraylist(new String[]{"aardvark", "lion", "zebra", "cougar", "cheetah"}));
        Testing.assertEquals("boundary case: minimum in first position",
                "aardvark",
                actual);

        actual = lp.getMin(array2arraylist(new String[]{"bear", "lion", "zebra", "cougar", "antelope"}));
        Testing.assertEquals("boundary case: minimum in last position",
                "antelope",
                actual);
    }


    public static void getMinIndexTests() {

        Testing.testSection("Testing getMinIndex");

        ListProcessor lp = new ListProcessor();
        String[] strings = {"b", "e", "a", "d", "g", "k", "c", "r", "t", "v", "a", "c", "b"};
        ArrayList<String> originalList = array2arraylist(strings);
        ArrayList<String> copy = new ArrayList<String>(originalList);

        Testing.assertEquals("getMinIndex should return the index of the first occurrence of the min element",
                       2,
                       lp.getMinIndex(copy));

        Testing.assertEquals("getMinIndex should not modify the list",
                originalList,
                copy);

        int actual = lp.getMinIndex(array2arraylist
                (new String[]{"aardvark", "lion", "zebra", "cougar", "cheetah"}));
        Testing.assertEquals("boundary case: minimum in first position",
                0,
                actual);

        actual = lp.getMinIndex(array2arraylist
                (new String[]{"bear", "lion", "zebra", "cougar", "antelope"}));
        Testing.assertEquals("boundary case: minimum in last position",
                4,
                actual);

    }

    public static void sortTests()
    {
        Testing.testSection("Testing sort");
        
        ListProcessor lp = new ListProcessor();
        
        String[] strings = {"b", "e", "a", "d", "g", "k", "c", "r", "t", "v", "a", "c", "b"};

        ArrayList<String> myList = array2arraylist(strings);

        lp.sort(myList);

        String[] sortedStrings = {"a", "a", "b", "b", "c", "c", "d", "e", "g", "k", "r", "t", "v"};
        ArrayList<String> sortedList = array2arraylist(sortedStrings);
        Testing.assertEquals("sort puts list in alphabetic order",
                       sortedList,
                       myList);
    }

}
