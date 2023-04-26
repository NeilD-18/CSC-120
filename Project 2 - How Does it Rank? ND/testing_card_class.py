from card import *
from testing import *

"""
Test cases for the card class

:author: Neil Daterao
"""

def test_card_as_string():
    """
    Test the card class such that it correctly returns the string version of a card object
    """
    start_tests("Testing the string version of the card class")
    __test_card_as_string_for_clubs_suit()
    __test_card_as_string_for_diamonds_suit()
    __test_card_as_string_for_hearts_suit
    __test_card_as_string_for_spades_suit()
    __test_card_as_string_for_nonface_card()
    __test_card_as_string_for_jack_rank()
    __test_card_as_string_for_queen_rank()
    __test_card_as_string_for_king_rank()
    __test_card_as_string_for_ace_rank()
    finish_tests()

       
def __test_card_as_string_for_clubs_suit():
    """
    Test a card that has a clubs suit, i.e "C"
    """
    rank = 14
    suit = "C"
    card = Card(rank, suit)
    actual = str(card)
    expected = "Ace of Clubs"
    assert_equals("String of clubs suited card", expected, actual)

def __test_card_as_string_for_nonface_card():
    """
    Test a card thats a non face card
    """
    rank = 10
    suit = "H"
    card = Card(rank, suit)
    actual = str(card)
    expected = "10 of Hearts"
    assert_equals("String of non-face card", expected, actual)
    
def __test_card_as_string_for_diamonds_suit():
    """
    Test a card that has a diamond as a suit, i.e "D"
    """
    rank = 3
    suit = "D"
    card = Card(rank, suit)
    actual = str(card)
    expected = "3 of Diamonds"
    assert_equals("String of diamond suited card", expected, actual)
    
def __test_card_as_string_for_spades_suit():
    """
    Test a card that has a spades as a suit, i.e "S"
    """
    rank = 8
    suit = "S"
    card = Card(rank, suit)
    actual = str(card)
    expected = "8 of Spades"
    assert_equals("String of spade suited card", expected, actual)

def __test_card_as_string_for_hearts_suit():
    """
    Test a card that has hearts as a suit, i.e "H"
    """
    rank = 9
    suit = "H"
    card = Card(rank, suit)
    actual = str(card)
    expected = "9 of Hearts"
    assert_equals("String of hearts suited card", expected, actual)

def __test_card_as_string_for_jack_rank():
    """
    Test a card that has jack as a rank, i.e "11"
    """
    rank = 11
    suit = "C"
    card = Card(rank, suit)
    actual = str(card)
    expected = "Jack of Clubs"
    assert_equals("String of jack ranked card", expected, actual)
    
    
def __test_card_as_string_for_queen_rank():
    """
    Test a card that has a queen as a rank, i.e "12"
    """
    rank = 12
    suit = "H"
    card = Card(rank, suit)
    actual = str(card)
    expected = "Queen of Hearts"
    assert_equals("String of queen ranked card", expected, actual)
    
def __test_card_as_string_for_king_rank():
    """
    Test a card that has a king as a rank, i.e "13"
    """
    rank = 13
    suit = "D"
    card = Card(rank, suit)
    actual = str(card)
    expected = "King of Diamonds"
    assert_equals("String of king ranked card", expected, actual)
    
def __test_card_as_string_for_ace_rank():
    """
    Test a card that has an ace as a rank, i.e "14"
    """
    rank = 14
    suit = "D"
    card = Card(rank, suit)
    actual = str(card)
    expected = "Ace of Diamonds"
    assert_equals("String of ace ranked card", expected, actual)

test_card_as_string()