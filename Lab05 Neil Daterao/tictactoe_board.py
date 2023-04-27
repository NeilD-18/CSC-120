"""
defines the behavior of a tic-tac-toe board
"""

NUM_ROWS = 3

class Tictactoe_board:

    def __init__(self, rows):
        """
        Constructor. Creates a tictactoe board with given cell values.
        If no initial cell values are given, creates an empty tictactoe board.

        :param rows: A list of three 3-character strings, where each character
        is either 'X', 'O', or ' '.  Each of the
        3-character strings represents a row of the tictactoe board.
        Example: [" X ", "O O", "XXO"] is the board
           | X |
        -----------
         O |   | O
        -----------
         X | X | O
        """
        self.__board = []
        if rows is None:
            empty_row = [' ', ' ', ' ']
            for i in range(NUM_ROWS):
                self.__board.append(empty_row)
        else:
            for i in range(NUM_ROWS):
                row = []
                for j in range(NUM_ROWS):
                    row.append(rows[i][j])
                self.__board.append(row)

    def place_piece(self, i, j, piece):
        """
        Places a piece (either 'X' or 'O') on the board.

        :param i: The row in which to place a piece (0, 1, or 2)
        :param j: The column in which to place a piece (0, 1, or 2)
        :param piece: The piece to place ('X' or 'O')
        """
        self.__board[i][j] = piece

    def clear_cell(self, i, j):
        """
        Clears a cell on the tictactoe board.

        :param i: The row of the cell to clear
        :param j: The column of the cell to clear
        """
        self.place_piece(i, j, ' ')

    def __row_as_string(self,row):
        """
        returns row in a format suitable for printing
        :param row: row of board as list of strings
        :return: row in prettified string format
        """
        str = ''
        for column in row[:len(row)-1]:
            str += column + ' | '
        str += row[len(row)-1]
        return str

    def __str__(self):
        """
        Produces a string representation of a board, returns it.

        :return: The string version of the board.
        """
        result = ''
        for row in self.__board[:len(self.__board)-1]:
            result += self.__row_as_string(row)
            result += '\n----------\n'
        result += self.__row_as_string(self.__board[len(self.__board)-1])
        result += '\n'
        return result

    def __three_in_row(self, player, start_x, start_y, dx, dy):
        """
        Determines if a player has three in a row, starting
        from a starting position (start_x, start_y) and going
        in the direction indicated by (dx, dy)
        """
        x = start_x; y = start_y
        for i in range(0,NUM_ROWS):
            if self.__board[y][x] != player:
                return False
            x += dx
            y += dy
        return True


    def __is_winner(self, player):
        """Returns True if and only if the given player has won"""

        if self.__three_in_row(player, 0, 0, 1, 1):
            return True
        elif self.__three_in_row(player, 2, 0, -1, 1):
            return True
        else:
            for i in range(0, NUM_ROWS):
                if (self.__three_in_row(player, 0, i, 1, 0)
                    or self.__three_in_row(player, i, 0, 0, 1)):
                    return True
            return False


    def get_winner(self):
        """
        Determines if there is a winner and returns the player who has won.
        :param board: A tictactoe board.
        :return: 'X' if player X is the winner; 'O' if player O is the winner; None if there is no winner.
        """
        if self.__is_winner('X'):
            return 'X'
        elif self.__is_winner('O'):
            return 'O'
        else:
            return None



