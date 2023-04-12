"""
Functions related to manipulating a deck of cards

:author: Neil Daterao

"""

""":self-reflection-on-refactoring: I didn't refactor much within this module. I knew I wanted to represent cards as 
tuples which stored the card rank and suit before I even started the project. I felt this would be the easiest way to 
represent the cards since I'm not editing the features of the cards themselves, therefore I can use an immutable data 
type. The little bit of refactoring I did came to the card ranks. At first I was going to label the cards from 1-13, 
where 11 represented Jack, 12 represented Queen and 13 represented King; however, I decided to use a combination of 
strings and integers. Integers for cards 2-10 and strings for cards Jack-Ace. I stored this data in a list and 
iterated through the list to create each card with the corresponding suit. Other than that, this module was very 
simple to create. """

import random as r 


def create_card(card_rank, suit):
    """
    Creates a card of a given suit and number 

    :param: card_type: Integer or string which represents the number/type of the card (2-10) or "Jack", "Queen", "King", "Ace"
    :param: suit: String which represents the suit of the card, could be Hearts, Spades, Diamonds or Clubs
    :return: The card as a tuple
    """
    return (card_rank, suit)


def create_deck_of_cards():
    """
    Function creates a deck of cards 
    
    :param: None
    :return: a deck of cards as a list
    """
    deck = []
    rank_of_cards = [2,3,4,5,6,7,8,9,10, "Jack", "Queen", "King", "Ace"]
    suits = ["Hearts", "Spades", "Diamonds", "Clubs"]

    for suit in suits:
        for rank_of_card in rank_of_cards:
            card = create_card(rank_of_card, suit)
            deck.append(card)
    return deck


def get_card_rank(card):
    """
    Gets card rank, i.e if the card is (2-10) or "Jack", "Queen", "King", "Ace"
    
    :param card: A card as a tuple
    :return: An integer or string depending on the type of card
    """
    return card[0]


def get_suit_of_card(card):
    """
    Gets suit of card, i.e if the card is Hearts, Spades, Diamonds or Clubs
    
    :param card: A card as a tuple
    :return: The suit of the card as a string
    """
    return card[1]


def get_deck_size(deck):
    """
    Gets the amount of cards in the deck

    :param deck: A deck of cards as a list
    :return: An integer of the amount of cards in the deck 
    """
    return len(deck)


def shuffle_cards(deck):
    """
    Function will shuffle a deck of cards. Note, this doesn't create a new shuffled deck of cards, it just shuffles
    the given deck of cards.

    :param deck: A deck of cards as a list
    :return: None
    """
    r.shuffle(deck)


def deal_card(deck):
    """
    Deal a random card from a deck of cards. The card dealt will be removed from the deck of cards. 

    :param deck: A deck of cards as a list
    :return: A card as a tuple
    """
    card_dealt = r.choice(deck)
    deck.remove(card_dealt) 

    return card_dealt


if __name__ == "__main__":
    #tests
    deck = create_deck_of_cards()
    print(deck)
    
    print("\n \n Shuffling Cards....")
    shuffle_cards(deck)
    
    print(get_deck_size(deck))
    print(deal_card((deck)))
    print(get_deck_size(deck))
    print(deck)
    
    print("\n \n Shuffling Again ....")
    shuffle_cards(deck)
    print(deck)
    print(get_deck_size(deck))
    print(deal_card((deck)))
    print(get_deck_size(deck))


    card = deal_card(deck)
    print(card)
    print(get_card_rank(card))
    print(get_suit_of_card(card))