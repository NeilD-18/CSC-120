from distutils.log import error
from tkinter import E
from card import *
from deck import *
from copy import deepcopy
from collections import Counter
"""
Module containing a poker hand class

:author: Neil Daterao
"""

max_cards_in_hand = 5

class PokerHand: 
    
    def __init__(self,list_of_cards):
        """
        Constructor initializes a copy of a deck of cards and an empty hand 
        """
        self.__list_of_cards = deepcopy(list_of_cards) #Creates a copy of the list of card objects
        self.__hand = [] 
        for count in range(max_cards_in_hand):
            self.__hand.append(self.__list_of_cards[count])
       
        
    def add_card(self, card):
        """
        Function that adds card object passed in as a parameter to the hand
        """
        #make so it can't add 6 cards
        if self.__hand.size() < max_cards_in_hand:
            self.__hand.append(card)
        else:
            raise Exception("Hand is full")
    
    def get_ith_card(self, index):
        """
        Return a card from the hand at the given index
        
        :return: a card object
        """
        return self.__hand[index]
    
    def size(self):
        """
        Get the current size of the hand
        
        :return: Integer representing the size of the hand
        """
        return len(self.__hand)
    
    
    def __str__(self):
        """
        Return string version of hand with one card per line
        
        :return: String version of the hand with one card per line
        """
        
        string_version_of_hand = ""
        for card in self.__hand:
            string_version_of_hand += str(card) + "\n"
        return string_version_of_hand
    
    def is_flush(self):
    
        """
        Determines if hand is a flush

        :return: Boolean, True if a flush and False if not
        """
        first_card = self.get_ith_card(0)
        previous = first_card.get_suit()
        for card in self.__hand:
            if card.get_suit() != previous:
                return False
            previous = card.get_suit()
        return True 
    
    def num_of_pairs(self):
        """
        Determines number of pairs in a hand

        :return: An integer representing the number of pairs 
        """
    
        rank_of_cards = []
        for card in self.__hand: 
            rank_of_cards.append(card.get_rank())
        
        count_of_ranks = Counter(rank_of_cards)
        
        pairs = 0 
        for rank in count_of_ranks:
            if count_of_ranks[rank] ==  4:
                pairs += 2
            elif count_of_ranks[rank] >= 2:
                pairs += 1
            else:
                pairs += 0
        return pairs
    
    def determine_classification_of_hand(self):
        """
        Determines the classification of a hand. In other words, if the hand is a pair, 2 pair, flush, or high card.
        
        :return: A string of the classification of the hand

        """
        if self.is_flush():
            return "Flush"
        elif self.num_of_pairs() == 2:
            return "Two pair"
        elif self.num_of_pairs() == 1:
            return "Pair"
        else:
            return "High card"
    

    

    def compare_to(self, other_hand):
        """
        Determines which of two poker hands is worth more. Returns an int
        which is either positive, negative, or zero depending on the comparison.
    
        :param self: The first hand to compare
        :param other_hand: The second hand to compare
        :return: a negative number if self is worth LESS than other_hand,
        zero if they are worth the SAME (a tie), and a positive number if
        self is worth MORE than other_hand
        """
        classification_of_hand = self.determine_classification_of_hand()
        classification_of_other_hand = other_hand.determine_classification_of_hand()
        
        if classification_of_hand == "Flush" and classification_of_other_hand != "Flush":
            return 1 
        
        else:
            return 0
      
        

if __name__ == "__main__":
    hand = PokerHand([Card(8, "D"), Card(7,"D"), Card(2,"D"), Card(13,"D"), Card(10, "D")])
    hand1 = PokerHand([Card(8, "C"), Card(8,"D"), Card(3,"H"), Card(3,"S"), Card(5, "D")])
    print(hand)
    print(hand.is_flush())
    print(hand1.num_of_pairs())
    print(hand.determine_classification_of_hand())
    print(hand1.determine_classification_of_hand())