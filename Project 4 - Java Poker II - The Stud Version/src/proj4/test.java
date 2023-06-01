package proj4; 

import java.util.ArrayList;
import java.util.Arrays;

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
        Deck myDeck = new Deck();
        System.out.println(myDeck);
        //ArrayList<Card> pokerHand1;
        //System.out.println(pokerHand1.size());
        ArrayList<Card> pokerHand = new ArrayList<Card>(Arrays.asList(
            new Card("7", "Hearts"), 
            new Card("7", "Spades"), 
            new Card("10", "Diamonds"), 
            new Card("4", "Spades"), 
            new Card("3", "Clubs"))); 
        ArrayList<Card> hand = new ArrayList<Card>(Arrays.asList(
            new Card(10,0),
            new Card(4,2)));
        ArrayList<Card> otherhand = new ArrayList<Card>(Arrays.asList(
            new Card(7,0),
            new Card(7,2)));
        CommunityCardSet mySet = new CommunityCardSet(pokerHand); 
        StudPokerHand myHand = new StudPokerHand(mySet, hand);
        StudPokerHand otherHand = new StudPokerHand(mySet, otherhand);
        System.out.println(myHand.compareTo(otherHand));   
        ArrayList<Card> pokerHand1 = new ArrayList<Card>(Arrays.asList(
            new Card("13", "Hearts"),
            new Card("13", "Spades"),
            new Card("13", "Diamonds"),
            new Card("13", "Spades"),
            new Card("2", "Clubs")
        ));
        ArrayList<Card> otherPokerHand1 = new ArrayList<Card>(Arrays.asList(
            new Card("13", "Diamonds"),
            new Card("13", "Clubs"),
            new Card("10", "Hearts"),
            new Card("10", "Clubs"),
            new Card("9", "Spades")
        ));
        PokerHand poker1 = new PokerHand(pokerHand1);
        PokerHand othPokerHand1 = new PokerHand(otherPokerHand1);
        System.out.println(poker1.compareTo(othPokerHand1));
        
        //**** TO DO****//
        //CommunityCardSet test
        //StudPoker Tests
        //Actual game lol almost done tho! 
        
    }
}
