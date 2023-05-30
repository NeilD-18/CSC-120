package proj4; 

import java.util.ArrayList;

public class test {

   
    public static void main(String[] args) {
        ArrayList<String> hello1 = new ArrayList<String>();
        String hello[] = new String[10]; 
        hello1.add("yup");
        hello1.add("yupppp");
        hello[0] = "1"; 
        hello[1] = "2"; 
        System.out.println((hello[1] == null) ? "yurr" : "false");
        System.out.println(hello1.indexOf("yupppp"));
        String test2 = "2";
        String testTwo = "two";
        //System.out.println((Integer.parseInt(testTwo) == null ) ? "it's null" : "false");
        try { System.out.println(Integer.valueOf(testTwo)); } 
        catch (NumberFormatException invalidString) { 
            System.out.println("sht dont work");
        }
        Card my_card = new Card(15,4); 
        System.out.println(my_card.getRank());
        System.out.println(my_card.getSuit());
        
        
    }
}
