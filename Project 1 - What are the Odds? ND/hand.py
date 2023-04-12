"""
Functions relating to poker hands

:author: Neil Daterao

"""
""":self-reflection-on-refactoring: I didn't find a need to refactor much at all in this module. As I was going 
through this module I went back to the cards module to add getter functions to ensure I maintained information 
hiding. This also made my code a lot easier to understand and much easier to program in my opinion. This module was 
also a lot simpler than I had imagined. We weren't assigned to check every single poker hand. We were essentially 
only checking for high card, pair, two pair, and flush. These 4 hands had different hands grouped between them. 
Looking back on it, this didn't really make sense, for example, why would high card and straight be grouped in the 
same category when straights are much more powerful than high card. In fact, to fulfill the requirements of this 
project, you only had to check for a flush and the amount of pairs, which is what I did. You don't need to create a 
function to determine high card since you're checking if the hand is a flush or pair first and if not, 
then it defaults to high card. Additionally, we didn't really care about the rank of the high card. For example, 
we didn't care if the hand had an Ace or a 2, we just wanted to know if the hand was a high card. Checking the pairs 
was quite simple as well. I used Counter, which creates a dictionary of each rank with it's count and I checked each 
key. If a hand had a key with 4 occurrences or 2 keys with 2 or occurrences, it was a 4-of-a-kind, 2 pair, 
or full house; however, they were all grouped as 2-pair. I believe that using the dictionary was the best way to go 
about determining the pairs. """

from cards import *
from collections import Counter 


def create_hand(deck):
    """
    Create a poker hand from a deck

    :param deck: A deck of cards as a list
    :return: A hand of 5 cards from the deck also stored as a list

    """
    
    hand = []
    max_cards_in_hand = 5
    for count in range(0,max_cards_in_hand):
        hand.append(deal_card(deck))
    return hand


def get_first_card_in_hand(hand):
    """
    Get the first card in a hand

    :param hand: A hand of 5 cards as a list
    :return: The first card in the hand as a tuple
    """
    return hand[0]

def is_flush(hand):

    """
    Determines if hand is a flush

    :param hand: A hand of 5 cards as a list
    :return: Boolean, True if a flush and False if not
    """

    previous = get_suit_of_card(get_first_card_in_hand(hand))
    for card in hand:
        if get_suit_of_card(card) != previous:
            return False
        previous = get_suit_of_card(card)
    return True 

def num_of_pairs(hand):
    """
    Determines number of pairs in a hand

    :param hand: A hand of 5 cards as a list
    :return: An integer representing the number of pairs 
    """
    
    rank_of_cards = []
    for card in hand: 
        rank_of_cards.append(get_card_rank(card))
    
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

    
def determine_classification_of_hand(hand):
    """
    Determines the classification of a hand. In other words, if the hand is a pair, 2 pair, flush, or high card.
    
    :param hand: A hand of 5 cards as a list
    :return: A string of the classification of the hand

    """
    if is_flush(hand):
        return "Flush"
    elif num_of_pairs(hand) == 2:
        return "Two pair"
    elif num_of_pairs(hand) == 1:
        return "Pair"
    else:
        return "High card"
    


if __name__ == '__main__':
    #tests
    deck = create_deck_of_cards()
    hand = create_hand(deck)
    print(hand)
    print(num_of_pairs([(1, 'Clubs'), (4, 'Clubs'), (3, 'Clubs'), (5, 'Clubs'), (2, 'Clubs')]))

    print(determine_classification_of_hand([(8, 'Diamonds'), (4, 'Diamonds'), (3, 'Diamonds'), (7, 'Diamonds'), (2, 'Diamonds')])) #Flush
    print(determine_classification_of_hand([(1, 'Clubs'), (4, 'Spades'), (6, 'Hearts'), (2,'Diamonds'), (9, 'Clubs')])) #High Card 
    print(determine_classification_of_hand([(4, 'Clubs'), (4, 'Spades'), (6, 'Hearts'), (2,'Diamonds'), (9, 'Clubs')])) #Pair
    print(determine_classification_of_hand([(4, 'Clubs'), (4, 'Spades'), (6, 'Hearts'), (6,'Diamonds'), (9, 'Clubs')])) #Two pair 

