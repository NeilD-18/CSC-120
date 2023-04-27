"""
Module that has a Card class 

:author: Neil Daterao
"""
#constants for cards 
RANKS = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
SUITS = ["C", "D", "H", "S"]


class Card:
    """
    Class that creates a card object of a specific rank and suit
    """
    
    def __init__(self, rank, suit):
        """
        Initialize a card object with a given rank (an integer from 2-14) and a suit (a single character ["H", "D", "S", "C"])
        """
    
        self.__card = {"rank" : rank, "suit" : suit}
        
        
    def get_rank(self):
        """
        Function that returns the rank of the card
        
        :return: Rank of card
        """

        return self.__card["rank"]

    def get_suit(self):
        """
        Function that returns the rank of the card
        
        :return: Suit of card
        """

        return self.__card["suit"]
    
    def __rank_as_face_card(self):
        """
        Function that translates the rank into a face card if it applies
        
        :return: Rank as a string of face card
        """
        rank = self.get_rank()
        if rank == 11:
            new_rank = "Jack"
        elif rank == 12:
            new_rank = "Queen"
        elif rank == 13:
            new_rank = "King"
        elif rank == 14:
            new_rank = "Ace"
        return new_rank 
    
    
    def __suit_full_name(self):
        """
        Function that translates the suit of the card into the full name of the suit, ex: "Jack of Clubs", "Ace of Diamonds", "3 of Spades" etc...
        
        :return: Full suit name of the card 
        """
        suit = self.get_suit()
        if suit == "H":
            full_suit = "Hearts"
        elif suit == "D":
            full_suit = "Diamonds"
        elif suit == "S":
            full_suit = "Spades"
        elif suit == "C":
            full_suit = "Clubs"
        return full_suit
           
    
    def __str__(self):
        """
        Function to turn the card object into a readable string form
        
        :return: Readable string version of the card    
        """
        rank = self.get_rank()
        suit = self.__suit_full_name()
        if rank > 10:
            rank = self.__rank_as_face_card()
        
        return str(rank) + " of " + suit 
        

if __name__ == "__main__":
    #messy tests
    card = Card(12, "D")
    print(card)

    print(card.get_rank())
    print(card.get_suit())
    