"""
:author: Neil Daterao
"""

from tictactoe_board import *
from testing import *


def test_get_winner():
    start_tests("Tests for tictactoe_board.get_winner()")
    test_get_winner_horiz_X()
    test_get_winner_incomplete_board()
    test_get_winner_empty()
    test_get_winner_backwards_slash_diag_O()
    test_get_winner_forwards_slash_diag_X()
    test_get_winner_vertical_winner_O()
    finish_tests()

"""
Individual unit tests start here
"""

def test_get_winner_horiz_X():
    a_board = Tictactoe_board(['XXX',
                               'OOX',
                               'XOO'])
    assert_equals("\n" + str(a_board) + "Three Xs in a row horizontally",
                  'X',
                  a_board.get_winner())


def test_get_winner_incomplete_board():
    a_board = Tictactoe_board(['XXX',
                               'OOX',
                               'XOO'])
    a_board.clear_cell(0, 0)
    assert_equals("\n" + str(a_board) + "Incomplete board, no winner yet",
                  None,
                  a_board.get_winner())


def test_get_winner_empty():
    a_board = Tictactoe_board(None)
    assert_equals("\n" + str(a_board) + "Empty board, no winner yet",
                  None,
                  a_board.get_winner())

def test_get_winner_backwards_slash_diag_O():
    a_board = Tictactoe_board(['OXX',
                               'OOX',
                               'XOO'])
    assert_equals("\n" + str(a_board) + "Three Os in a row diagonally, (backslash)",
                  'O',
                  a_board.get_winner())

def test_get_winner_forwards_slash_diag_X():
    a_board = Tictactoe_board(['OXX',
                               'OXX',
                               'XOO'])
    assert_equals("\n" + str(a_board) + "Three Xs in a row diagonally, (forward slash)",
                  'X',
                  a_board.get_winner())
def test_get_winner_vertical_winner_O():
    a_board = Tictactoe_board(['OXX',
                               'OOX',
                               'OXO'])
    assert_equals("\n" + str(a_board) + "Three Os in a row vertically",
                  'O',
                  a_board.get_winner())



if __name__ == "__main__":
    test_get_winner()
