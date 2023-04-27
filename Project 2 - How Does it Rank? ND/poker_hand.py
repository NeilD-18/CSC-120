from card import *
from deck import *
from copy import deepcopy
from collections import Counter
"""
Module containing a PokerHand class

:author: Neil Daterao
"""

max_cards_in_hand = 5

class PokerHand: 
    """
    Class that creates a poker hand object 
    """
    
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
        Function that adds card object passed in as a parameter to the hand. Will throw an error if hand is already full
        """
        #make so it can't add 6 cards
        if self.size() < 5:
            self.__hand.append(card)
        else:
            print("Error: Hand is full")
        
    
    def get_ith_card(self, index):
        """
        Return a card from the hand at the given index
        
        :return: a card object
        """
        if index < 0:
            print("Error: Invalid Index, must be >= 0")
            return None
        
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
    
   
    def __is_flush(self):
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
    
    
    def __num_of_pairs(self):
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
    
   
    def __determine_classification_of_hand(self):
        """
        Determines the classification of a hand. In other words, if the hand is a pair, 2 pair, flush, or high card.
        
        :return: A string of the classification of the hand

        """
        if self.__is_flush():
            return "Flush"
        elif self.__num_of_pairs() == 2:
            return "Two pair"
        elif self.__num_of_pairs() == 1:
            return "Pair"
        else:
            return "High card"
    
    
    def __translate_classification_of_hand_to_power_ranking(self):
        """
        Function to translate the hand type into a number, 4 (strongest, Flush) to 1 (Weakest, High Card)
        
        :return: Integer of power ranking
        """
        classification_of_hand = self.__determine_classification_of_hand()
        if classification_of_hand == "Flush":
            power_ranking = 4
        elif classification_of_hand == "Two pair":
            power_ranking = 3
        elif classification_of_hand == "Pair":
            power_ranking = 2
        else:
            power_ranking = 1
        return power_ranking
    
    
    def __get_ranks_of_hand_in_list(self):
        """
        Translates the ranks of the cards in the hand into a list
        
        :return: A list of the ranks of the cards in the hands
        """
        
        ranks_of_hand = []
        for index in range(max_cards_in_hand):
            ranks_of_hand.append(self.get_ith_card(index).get_rank())
        return ranks_of_hand
    
    
    def __determine_winning_flush(self, other_hand):
        """
        Function to determine a winning flush given two hands that are flushes. Returns 1 if the "self" hand wins, -1 if the other hand wins and 0 if the hands tie. 
        
        :param other_hand: A PokerHand object which is a flush 
        :return: 1 if the "self" hand wins, -1 if the other hand wins and 0 if the hands tie. 
        """
        #Since we alreay know this is a flush, we have to check the ranks of the card and we can use the same algorithm we used to check high cards. 
        
        return self.__determine_winning_high_card(other_hand)
            
            
    def __determine_winning_two_pair(self, other_hand):
        """
        Function to determine which hand of two pairs is stronger
        
        :param other_hand: Another PokerHand Object which is classified as a two pair 
        :return: Will return 1 if the "self" PokerHand is stronger, -1 if the other_hand PokerHand is stronger and 0 if they are of equal strength 
        """
        pairs_in_self = []
        extra_card_in_self = None
        pairs_in_other_hand = []
        extra_card_in_other_hand = None
        max_index = 2 #Magic number but since the function is private it's okay! The reason for this magic number is to account for hands where we are comparing 4 of a kind to a 2 regular 2 pair.
        
        ranks_in_self = self.__get_ranks_of_hand_in_list()
        ranks_in_other_hand = other_hand.__get_ranks_of_hand_in_list()
        
        counts_of_ranks_in_self = Counter(ranks_in_self)
        counts_of_ranks_in_other_hand = Counter(ranks_in_other_hand)
        
        for card in counts_of_ranks_in_self:
            if counts_of_ranks_in_self[card] >= 2:
                pairs_in_self.append(card)
            else:
                extra_card_in_self = card 
                
        for card in counts_of_ranks_in_other_hand:
            if counts_of_ranks_in_other_hand[card] >= 2:
                pairs_in_other_hand.append(card)
            else:
                extra_card_in_other_hand = card 
        
        pairs_in_self.sort(reverse=True)
        pairs_in_other_hand.sort(reverse=True)
        
        if len(pairs_in_self) != len(pairs_in_other_hand):
            max_index = 1
        
        for card_count in range(0,max_index):
            if pairs_in_self[card_count] > pairs_in_other_hand[card_count]:
                return 1
            elif pairs_in_self[card_count] < pairs_in_other_hand[card_count]:
                return -1
        
        return extra_card_in_self - extra_card_in_other_hand
        
        
    def __determine_winning_one_pair(self, other_hand):
        """
        Function to determine which hand of pairs is stronger
        
        :param other_hand: Another PokerHand Object which is classified as a Pair 
        :return: Will return 1 if the "self" PokerHand is stronger, -1 if the other_hand PokerHand is stronger and 0 if they are of equal strength 
        """
        pair_in_self = None
        extra_cards_in_self = []
        pair_in_other_hand = None
        extra_cards_in_other_hand = []
        max_index = 3 #Magic number again, but it's okay since it is a private function, this is to account for comparing three of a kind with one pair, the list of extra cards will be different lengths and we want to iterate through the smallest sorted array.
        
        ranks_in_self = self.__get_ranks_of_hand_in_list()
        ranks_in_other_hand = other_hand.__get_ranks_of_hand_in_list() 
        
        for card_rank in ranks_in_self:
            if card_rank in extra_cards_in_self:
                pair_in_self = card_rank
            else:
                extra_cards_in_self.append(card_rank)
        
        for card_rank in ranks_in_other_hand:
            if card_rank in extra_cards_in_other_hand:
                pair_in_other_hand = card_rank
            else:
                extra_cards_in_other_hand.append(card_rank)
                
        extra_cards_in_self.sort(reverse=True)
        extra_cards_in_other_hand.sort(reverse=True)
        
        if len(extra_cards_in_self) != len(extra_cards_in_other_hand):
            max_index = 2 
         
        if pair_in_self == pair_in_other_hand:
            for card_count in range(max_index):
                if extra_cards_in_self[card_count] > extra_cards_in_other_hand[card_count]:
                    return 1
                elif extra_cards_in_self[card_count] < extra_cards_in_other_hand[card_count]:
                    return -1 
                
        return pair_in_self - pair_in_other_hand
            
   
    def __determine_winning_high_card(self,other_hand):
        """
        Function to determine which hand of high cards is stronger
        
        :param other_hand: Another PokerHand Object which is classified as a High Card
        :return: Will return 1 if the "self" PokerHand is stronger, -1 if the other_hand PokerHand is stronger and 0 if they are of equal strength 
        """
        
        ranks_of_self_hand = self.__get_ranks_of_hand_in_list()
        ranks_of_other_hand = other_hand.__get_ranks_of_hand_in_list()
        
        ranks_of_self_hand.sort(reverse= True)
        ranks_of_other_hand.sort(reverse= True)
        
        card_count = 0 
        while card_count < max_cards_in_hand:
            if ranks_of_self_hand[card_count] == ranks_of_other_hand[card_count]:
                card_count += 1
            elif ranks_of_self_hand[card_count] > ranks_of_other_hand[card_count]:
                return 1
            elif ranks_of_self_hand[card_count] < ranks_of_other_hand[card_count]:
                return -1
        return 0
            

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
        classification_of_self_hand = self.__determine_classification_of_hand()
        classification_of_other_hand = other_hand.__determine_classification_of_hand()
        power_ranking_of_hand = self.__translate_classification_of_hand_to_power_ranking()
        power_ranking_of_other_hand = other_hand.__translate_classification_of_hand_to_power_ranking()
        
        if power_ranking_of_hand - power_ranking_of_other_hand == 0:
            if classification_of_self_hand == "Flush":
                return self.__determine_winning_flush(other_hand)
            elif classification_of_self_hand == "Two pair":
                return self.__determine_winning_two_pair(other_hand)
            elif classification_of_self_hand == "Pair":
                return self.__determine_winning_one_pair(other_hand)
            else:
                return self.__determine_winning_high_card(other_hand)
        
        else:
            return power_ranking_of_hand - power_ranking_of_other_hand
        

if __name__ == "__main__":
    #messy tests
    hand = PokerHand([Card(13, "D"), Card(10,"D"), Card(5,"D"), Card(4,"D"), Card(2, "D")])
    hand1 = PokerHand([Card(8, "C"), Card(8,"D"), Card(3,"H"), Card(3,"S"), Card(6, "D")])
    hand3 = PokerHand([Card(8, "C"), Card(8,"D"), Card(3,"H"), Card(3,"S"), Card(7, "D")])
    
    hand4 = PokerHand([Card(4, "D"), Card(4, "C"), Card(4, "S"), Card(4,"D"), Card(12, "S")])
    hand5 = PokerHand([Card(7, "D"), Card(7, "C"), Card(7, "S"), Card(6,"D"), Card(6, "S")])

    hand2 = PokerHand([Card(13, "D"), Card(10,"D"), Card(7,"D"), Card(4,"D"), Card(2, "D")])
    print(hand.compare_to(hand1))
    print(hand1.compare_to(hand3))
    print(hand4.compare_to(hand5))
  