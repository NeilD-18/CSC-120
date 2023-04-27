from cmath import exp
from poker_hand import *
from testing import *

"""
Test cases for the PokerHand class, specifically the compare_to function

:author: Neil Daterao
"""


def test_compare_to():
    """
    Test the compare_to function in the PokerHand class such that it successfully compares various hands
    """
    start_tests("Testing compare_to function")
    __test_one_pair_aces_v_fours()
    __test_two_pair_94_v_93()
    __test_two_pair_ace_v_ace_high_card_win()
    __test_two_pair_ace_v_ace_high_card_tie_second_win()
    __test_two_pair_58_v_76()
    __test_two_pair_of_same_pairs_diff_high_card()
    __test_9_high_flush_v_6_high_flush()
    __test_king_10_7_flush_v_king_10_5_flush()
    __test_flush_actual_tie()
    __test_high_card_tie()
    __test_two_pair_tie()
    __test_one_pair_tie()
    __test_flush_vs_high_card()
    __test_two_pair_vs_one_pair()
    __test_full_house_vs_straight()
    __test_royal_flush_vs_straight_flush()
    __test_four_of_a_kind_vs_two_pair()
    __test_high_card_tie_up_to_third_card()
    __test_one_pair_tie_up_to_fourth_card()
    __test_three_of_a_kind_vs_two_pair()
    finish_tests()
    


def __test_one_pair_aces_v_fours():
    """
    Testing hands of 1 pairs, aces v fours
    """
    poker_hand = PokerHand([Card(14, "S"), Card(14,"C"), Card(5,"H"), Card(4,"D"), Card(2, "D")])
    other_poker_hand = PokerHand([Card(4, "S"), Card(4,"C"), Card(5,"H"), Card(3,"D"), Card(2, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 10
    assert_equals("Testing hands of 1 pairs, aces v fours.", expected, actual)

def __test_two_pair_94_v_93():
    """
    Testing hands of 2 pairs, 9 and 4 v 9 and 3 
    """
    poker_hand = PokerHand([Card(9, "S"), Card(9,"C"), Card(4,"H"), Card(4,"D"), Card(2, "D")])
    other_poker_hand = PokerHand([Card(9, "S"), Card(9,"C"), Card(3,"H"), Card(3,"D"), Card(2, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 1
    assert_equals("Testing hands of 2 pairs, 9 and 4 v 9 and 3 .", expected, actual)

def __test_two_pair_ace_v_ace_high_card_win():
    """
    Testing hands of 1 pairs where the aces tie but the high card wins
    """
    poker_hand = PokerHand([Card(14, "S"), Card(14,"C"), Card(7,"H"), Card(2,"D"), Card(9, "D")])
    other_poker_hand = PokerHand([Card(14, "S"), Card(14,"C"), Card(8,"H"), Card(4,"D"), Card(2, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 1
    assert_equals("Testing hands of 1 pairs where the aces tie but the high card wins ", expected, actual)

def __test_two_pair_ace_v_ace_high_card_tie_second_win():
    """
    Testing hands of 1 pairs where the aces tie and the high card ties, but the second high card wins
    """
    poker_hand = PokerHand([Card(14, "S"), Card(14,"C"), Card(7,"H"), Card(2,"D"), Card(9, "D")])
    other_poker_hand = PokerHand([Card(14, "S"), Card(14,"C"), Card(9,"H"), Card(4,"D"), Card(2, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 1
    assert_equals("Testing hands of 1 pairs where the aces tie and the high card ties, but the second high card wins ", expected, actual)

def __test_two_pair_58_v_76():
    """
    Testing hands of 2 pairs, 5 and 8 v 7 and 6 
    """
    poker_hand = PokerHand([Card(5, "S"), Card(5,"C"), Card(8,"H"), Card(8,"D"), Card(9, "D")])
    other_poker_hand = PokerHand([Card(7, "S"), Card(7,"C"), Card(6,"H"), Card(6,"D"), Card(2, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 1
    assert_equals("Testing hands of 2 pairs, 5 and 8 v 7 and 6 ", expected, actual)

def __test_two_pair_of_same_pairs_diff_high_card():
    """
    Testing hands of 2 pairs, of the same pairs but the high card wins it
    """
    poker_hand = PokerHand([Card(10, "S"), Card(10,"C"), Card(2,"H"), Card(2,"D"), Card(13, "D")])
    other_poker_hand = PokerHand([Card(10, "S"), Card(10,"C"), Card(2,"H"), Card(2,"D"), Card(4, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 9
    assert_equals(" Testing hands of 2 pairs, of the same pairs but the high card wins it ", expected, actual)

def __test_9_high_flush_v_6_high_flush():
    """
    Testing hands of flushes, 9 high v 6 high
    """
    poker_hand = PokerHand([Card(8, "S"), Card(9,"S"), Card(3,"S"), Card(2,"S"), Card(7, "S")])
    other_poker_hand = PokerHand([Card(6, "C"), Card(2,"C"), Card(3,"C"), Card(5,"C"), Card(4, "C")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 1
    assert_equals(" Testing hands of flushes, 9 high v 6 high ", expected, actual)

def __test_king_10_7_flush_v_king_10_5_flush():
    """
    Testing hands of flushes, King-10-7 v King-10-5
    """
    poker_hand = PokerHand([Card(13, "S"), Card(10,"S"), Card(7,"S"), Card(2,"S"), Card(6, "S")])
    other_poker_hand = PokerHand([Card(13, "C"), Card(10,"C"), Card(5,"C"), Card(2,"C"), Card(4, "C")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 1
    assert_equals(" Testing hands of flushes, King-10-7 v King-10-5 ", expected, actual)

def __test_flush_actual_tie():
    """
    Test a tie between two poker hands with flush as the winning criteria.
    """
    poker_hand = PokerHand([Card(13, "S"), Card(10,"S"), Card(7,"S"), Card(2,"S"), Card(6, "S")])
    other_poker_hand = PokerHand([Card(13, "C"), Card(10,"C"), Card(7,"C"), Card(2,"C"), Card(6, "C")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 0
    assert_equals(" Testing flush actual tie ", expected, actual)

def __test_high_card_tie():
    """
    Test a tie between two poker hands with high card as the winning criteria.
    """
    poker_hand = PokerHand([Card(13, "D"), Card(10,"H"), Card(7,"S"), Card(2,"C"), Card(6, "S")])
    other_poker_hand = PokerHand([Card(13, "S"), Card(10,"C"), Card(7,"D"), Card(2,"C"), Card(6, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 0
    assert_equals("Testing high card tie", expected, actual)

def __test_two_pair_tie():
    """
    Test a tie between two poker hands with two pair as the winning criteria.
    """
    poker_hand = PokerHand([Card(13, "S"), Card(13,"C"), Card(7,"S"), Card(7,"C"), Card(2, "S")])
    other_poker_hand = PokerHand([Card(13, "D"), Card(13,"H"), Card(7,"D"), Card(7,"H"), Card(2, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 0
    assert_equals("Testing two-pair tie", expected, actual)

def __test_one_pair_tie():
    """
    Test a tie between two poker hands with one pair as the winning criteria.
    """
    poker_hand = PokerHand([Card(13, "S"), Card(13,"C"), Card(7,"S"), Card(2,"D"), Card(6, "S")])
    other_poker_hand = PokerHand([Card(13, "D"), Card(13,"H"), Card(7,"D"), Card(2,"C"), Card(6, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 0
    assert_equals("Testing one-pair tie", expected, actual)

def __test_flush_vs_high_card():
    """
    Test a comparison between a flush and a high card.
    """
    poker_hand = PokerHand([Card(13, "S"), Card(10, "S"), Card(7, "S"), Card(2, "S"), Card(6, "S")])
    other_poker_hand = PokerHand([Card(13, "D"), Card(11, "S"), Card(8, "H"), Card(5, "C"), Card(2, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 3
    assert_equals("Testing flush vs high card", expected, actual)

def __test_two_pair_vs_one_pair():
    """
    Test a comparison between two poker hands, one with two pairs and the other with one pair.
    """
    poker_hand = PokerHand([Card(13, "S"), Card(13, "C"), Card(7, "S"), Card(7, "C"), Card(2, "S")])
    other_poker_hand= PokerHand([Card(13, "D"), Card(13, "H"), Card(9, "D"), Card(6, "C"), Card(4, "D")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 1
    assert_equals("Testing two pair vs one pair", expected, actual)

def __test_full_house_vs_straight():
    """
    Test a comparison between a full house and a straight.
    """
    poker_hand = PokerHand([Card(13, "S"), Card(13, "C"), Card(13, "D"), Card(7, "S"), Card(7, "C")])
    other_poker_hand = PokerHand([Card(10, "S"), Card(9, "D"), Card(8, "C"), Card(7, "S"), Card(6, "H")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 2
    assert_equals("Testing full house vs straight", expected, actual)

def __test_royal_flush_vs_straight_flush():
    """
    Test a comparison between a royal flush and a straight flush.
    """
    poker_hand = PokerHand([Card(10, "S"), Card(11, "S"), Card(12, "S"), Card(13, "S"), Card(14, "S")])
    other_poker_hand = PokerHand([Card(9, "H"), Card(8, "H"), Card(7, "H"), Card(6, "H"), Card(5, "H")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 1
    assert_equals("Testing royal flush vs straight flush", expected, actual)

def __test_four_of_a_kind_vs_two_pair():
    """
    Test a comparison between a four of a kind and a two pair.
    """
    poker_hand = PokerHand([Card(13, "S"), Card(13, "C"), Card(13, "D"), Card(13, "H"), Card(7, "S")])
    other_poker_hand = PokerHand([Card(10, "H"), Card(10, "S"), Card(9, "D"), Card(9, "C"), Card(4, "H")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 1
    assert_equals("Testing four of a kind vs two pair", expected, actual)

def __test_high_card_tie_up_to_third_card():
    """
    Test a comparison between two high card hands that tie up until the third card.
    """
    poker_hand = PokerHand([Card(13, "S"), Card(10, "C"), Card(8, "H"), Card(5, "D"), Card(2, "S")])
    other_poker_hand = PokerHand([Card(13, "C"), Card(10, "D"), Card(8, "S"), Card(6, "H"), Card(3, "C")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = -1
    assert_equals("Testing high card tie up to third card", expected, actual)

def __test_one_pair_tie_up_to_fourth_card():
    """
    Test a comparison between two one pair hands that tie up until the fourth card.
    """
    poker_hand = PokerHand([Card(10, "S"), Card(10, "C"), Card(9, "H"), Card(7, "D"), Card(2, "S")])
    other_poker_hand = PokerHand([Card(10, "D"), Card(10, "H"), Card(9, "S"), Card(6, "H"), Card(3, "C")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = 1
    assert_equals("Testing one pair tie up to fourth card", expected, actual)

def __test_three_of_a_kind_vs_two_pair():
    """
    Test a comparison between a three of a kind hand and a two pair hand.
    """
    poker_hand = PokerHand([Card(9, "S"), Card(9, "C"), Card(9, "D"), Card(5, "H"), Card(2, "S")])
    other_poker_hand = PokerHand([Card(10, "H"), Card(10, "S"), Card(9, "D"), Card(9, "C"), Card(4, "H")])
    actual = poker_hand.compare_to(other_poker_hand)
    expected = -1
    assert_equals("Testing three of a kind vs two pair", expected, actual)


test_compare_to()

