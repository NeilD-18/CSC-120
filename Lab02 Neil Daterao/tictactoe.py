"""
functions related to creating, printing,
and evaluating tic-tac-toe boards

:author: Neil Daterao
:note: I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""


def remove_blank_lines(list_of_strings):
    """
    Given a list of strings, return a copy
    with all empty strings removed
    :param list_of_strings: list of strings, some of which may be ''; this list is unchanged
    :return: list identical to list_of_strings, but all empty strings removed
    """
    result = list()
    for s in list_of_strings:
        if s != '':
            result.append(s)
    return result


def get_board_from_file(filename):
    """
    Reads board, returns a list of rows.
    :param filename: text file with a tic-tac-toe board such as
    X X X
    O X O
    X O O
    where each line is one row
    :return: list of strings where each string is a
    row from filename; any blank lines in the file are removed
    Example: ["X X X", "O X O", "X O O"]
    """
    board_list = []
    board_file = open(filename, "r")
    for line in board_file:
        board_list.append(line.strip())
    board_file.close()
    board_list = remove_blank_lines(board_list)
    return board_list


def print_row(row):
    """
    Nicely prints a row of the board.
    :param row: string of Xs and Os
    """
    nice_row = ''
    for i in range(0, len(row)):
        nice_row += row[i]
        if i != len(row) - 1:
            nice_row += ' | '
    print(nice_row)


def print_board(board):
    """
    prints the tic-tac-toe board
    :param board: list of rows
    """
    for i in range(0, len(board)):
        row = board[i]
        print_row(row)
        if i != len(board) - 1:
            print('----------')


def three_in_row(board, player, start_x, start_y, dx, dy):
    """
    Determines if a player has three in a row, starting
    from a starting position (start_x, start_y) and going
    in the direction indicated by (dx, dy). Example:
    (start_x, start_y) = (2,2) means we start at the lower
    right (row 2, col 2). (dx, dy) = (-1, 0) means the next
    square we check is (2+dx, 2+dy) = (1,2).  And the last
    square we check is (1+dx, 2+dy) = (0,2).  So we've just
    checked the rightmost column - (2,2), (1,2), and (0,2).
    :param board: list of rows
    :param player: string -- either "X" or "O"
    :param start_x: row to start checking at; first row is row 0
    :param start_y: col to start checking at; first col is col 0
    :param dx: 1 if checking downward, -1 if checking upward, 0 if checking this row
    :param dy: 1 if checking rightward, -1 if checking leftward, 0 if checking this col
    """
    x = start_x
    y = start_y
    for i in range(0, 3):
        if board[x][y] != player:
            return False
        x += dx
        y += dy
    return True


def is_winner(board, player):
    """
    Returns True if and only if the given player has won.
    :param board: list of row strings
    :param player: string - "X" or "O"
    :return: True if player won; False if player lost or tied
    """
    if three_in_row(board, player, 0, 0, 1, 1) or three_in_row(board, player, 0, 2, 1, -1):
        return True
    else:
        for i in range(0, 3):
            if (three_in_row(board, player, 0, i, 1, 0)
                    or three_in_row(board, player, i, 0, 0, 1)):

                return True
        return False


def get_winner(board):
    """
    Returns the name of the winner, or None if there is no winner
    :param board: list of row strings
    :return: "X" if X is winner, "O" if O is winner, None if tie
    """
    if is_winner(board, 'X'):
        return 'X'
    elif is_winner(board, 'O'):
        return 'O'
    else:
        return None

def confirm_result(board, expected_winner):
    """
    Tests if the winner of the tic-tae-toe game is supposed to be the actual winner. If so, function will print PASS.
    If not, the function will print FAIL accompanied by the failed test case.


    :param board: Takes tic-tac-toe board as a string
    :param expected_winner: Expected winning player of tic tac toe game
    :return: None
    """

    actual_winner = get_winner(board)
    if actual_winner == expected_winner:
        print("PASS")
    else:
        print("FAIL")
        print_board(board)
        print("Actual Winner: %s wins" % actual_winner)
        print("Expected Winner: %s wins" % expected_winner)


def main():
    """
    Reads boards from test case files and tests them
    :return: None
    """
    test_cases = [("X_wins.txt","X"), ("O_wins.txt", "O"), ("X_diag_wins_left2right.txt","X"), ("X_diag_wins_right2left.txt","X"), ("O_diag_wins_right2left.txt","O"), ("O_diag_wins_left2right.txt", "O"), ("Draw.txt", None)]
    for test in test_cases:
        board = get_board_from_file(test[0])
        expected_winner = test[1]
        confirm_result(board, expected_winner)


def main2():
    """
    Runs hard-coded test cases

    :return: None
    """
    x_wins = ["XXX",
              "OOX",
              "XOO"]
    confirm_result(x_wins, "X")

    o_wins = ["OXX",
              "OOO",
              "XXO"]
    confirm_result(o_wins, "O")

    x_diag_wins_left2right = ["XOX",
                              "OXO",
                              "OOX"]
    confirm_result(x_diag_wins_left2right, "X")

    x_diag_wins_right2left= ["XOX",
                             "OXO",
                             "XOO"]
    confirm_result(x_diag_wins_right2left, "X")

    o_diag_wins_right2left = ["OXO",
                              "XOX",
                              "OXX" ]
    confirm_result(o_diag_wins_right2left, "O")

    o_diag_wins_left2right = ["OXO",
                              "XOX",
                              "XXO"]
    confirm_result(o_diag_wins_left2right, "O")

    draw = ["OOX",
            "XXO",
            "OXO"]
    confirm_result(draw, None)



if __name__ == "__main__":
    main()
    print("\nMain2:")
    main2()
