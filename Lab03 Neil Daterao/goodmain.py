"""
Functions for a tic tac toe board and determining its winner

:author: Neil Daterao
:note: I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""

def print_board(board):
    """
    Prints a tic tac toe board
    :param board: A valid tic-tac-toe board
    :return: None
    """

    num_rows = len(board)
    num_cols = len(board[0])
    for row_num, row in enumerate(board):
        row_str = ''
        for col_num, marker in enumerate(row):
            row_str += marker
            if col_num < num_cols - 1:
                row_str += ' | '
        print(row_str)
        if row_num < num_rows - 1:
            print('---------')


def row_all_same(board, row):
    """
    Checks the board to see if the row is all the same
    :param board: A tic tac toe board
    :param row: A specific row on tic tac toe board
    :return: Boolean, True if all the same, false if not
    """
    return (board[row][0] == board[row][1] == board[row][2])


def column_all_same(column):
    """
    Checks the board to see if the column is all the same
    :param column: A column of the tic tac toe board
    :return: Boolean, True if all the same, false if not
    """
    return (column[0] == column[1] == column[2])


def diagonal_all_same(diagonal):
    """
    Checks the board to see if the diagonals are all the same
    :param diagonal: The diagonal of a tic tac toe board
    :return: Boolean, True if all the same, false if not
    """
    return (diagonal[0] == diagonal[1] == diagonal[2])


def get_back_slash(board):
    """
    Gets diagonal that looks like a back slash on a tic tac toe board

    :param board: A valid tic tac toe board
    :return: A list of the the characters of the diagonal back slash of the tic tac toe board
    """
    return [board[i][i] for i in range(len(board))]


def get_forward_slash(board):
    """
    Gets diagonal that looks like a forward slash on a tic tac toe board

    :param board: A valid tic tac toe board
    :return: A list of the the characters of the diagonal forward slash of the tic tac toe board
    """
    return [board[len(board)-i-1][i] for i in range(len(board))]


def columns(board):
    """
    Gets the columns from the board
    :param board: A valid tic tac toe board
    :return: The columns from the board stored in a list
    """
    num_cols = len(board[0])
    num_rows = len(board)
    
    columns_of_board = []
    
    for i in range(num_cols):
        col_str = ''
        for j in range(num_rows):
            col_str += board[j][i]
        columns_of_board.append(col_str)

    return columns_of_board


def check_winner(board):
    """
    Determines if there's a winner given a tic tac toe board

    :param board: A valid tic tac toe board
    :return: The winner as a string
    """
    for row_num, row in enumerate(board):
        if row_all_same(board, row_num):
            winner = board[row_num][0]
            return winner

    for col in columns(board):
        if column_all_same(col):
            winner = col[0]
            return winner
    
    if diagonal_all_same(get_back_slash(board)):
        winner = board[0][0]
        return winner
    
    if diagonal_all_same(get_forward_slash(board)):
        winner = board[2][0]
        return winner
    return "No winner"

def get_board_from_file(filename):
    """
    Get a tic tac toe board from a file
    :param filename: A text file holding a tic tac toe board
    :return: The board as a list
    """
    board_list = []
    board_file = open(filename,"r")
    for line in board_file:
        board_list.append(line.strip())
    board_file.close()
    return board_list


def main():
    """
    1. Why is the logic inside badmain's main-line code ambiguous and hard to follow? Although the code inside
    badmain works, it's hard to follow because it uses a cluster of global variables. The most confusing was
    declaring a global "winner" variable as an empty string. Additionally, the check winner function is updating the
    global variable and then returning nothing, making the code hard to read. Additionally, most of the functions
    take parameters and just access a global board variable. The columns function was especially confusing since it
    was returning a list called "to_return". You would have to go throgh the lines of code to actually decipher what
    the function was returning, making the code harder to follow.

    2. How does your refactoring remove this ambiguity? I removed all the global variables and passed parameters to
    all the functions. This made it clear in my main function that I was performing certain actions on a certain
    board. This also made my functions more reusable since they weren't accessing a global board variable. I changed
    check winnner by getting rid of the global winner variable and made it so that the function would return the
    actual winner of the board. If there was no winner, the function will return "No winner". This also makes my main
    function easier to read because instead of winner being an empty string, the if statement will check if winner !=
    "No winner." The empty string in badmain made that conditional very confusing. I also changed the "to_return"
    list in the columns function to a list named "columns_of_board." This makes it clear to the person readng the
    code as to what that function is returning. Additionally, all the main code is placed in a main function and then
    that function is called, eliminating all variables from the global scope.


    """


    board = get_board_from_file('input.txt')
    print_board(board)
    winner = check_winner(board)

    if winner != 'No winner':
        print(winner + ' WINS!!!!')
    else:
        print("TIE GAME!!!!")


if __name__ == "__main__":
    main()

