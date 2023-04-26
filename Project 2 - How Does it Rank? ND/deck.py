from card import *
from random import shuffle

"""
Module that contains a deck class

:author: Neil Daterao
"""

class Deck: 
    """
    Class that creates a deck object
    """
    
    def __init__(self):
        """
        Constructor that initializes a deck object
        """
        
        self.__deck_contents = []
        for rank in RANKS:
            for suit in SUITS:
                card = Card(rank,suit)
                self.__deck_contents.append(card)
    
    def shuffle(self):
        """
        Function that shuffles the contents of the deck
        
        :return: None
        """
        shuffle(self.__deck_contents)
    
    def deal(self):
        """
        Function that deals a card of the top off the deck, will return None if deck is empty
        
        :return: A card object
        """
        
        if self.size == 0:
            return None
        
        else:
            card_to_be_dealt = self.__deck_contents[self.size()-1]
            self.__deck_contents.pop()
            return card_to_be_dealt
    
    def size(self):
        """
        Function to return the current length of the deck 
        
        :return: Integer representing the length of the deck 
        """
        return len(self.__deck_contents)
    
    
    def __str__(self):
        """
        Return string version of deck with one card per line
        
        :return: String version of the deck with one card per line
        """
        
        string_version_of_deck = ""
        for card in self.__deck_contents:
            string_version_of_deck += str(card) + "\n"
        return string_version_of_deck

if __name__ == "__main__":
    deck = Deck()
    print(deck)
    deck.shuffle()
    print("\n \n \n")
    print(deck)
    print(deck.size())
    print(deck.deal())
    print(deck.size())
    print("\n" ,deck)