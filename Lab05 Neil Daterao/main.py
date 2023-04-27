from tictactoe_board import *

def main():
    the_board = Tictactoe_board(['XOX',
                                 'OXO',
                                 'XOO'])
    print(the_board)
    print("The winner is %s" % the_board.get_winner())
    print()

    the_board.place_piece(2, 0, 'O')
    print(the_board)
    print("The winner is %s" % the_board.get_winner())

if __name__ == "__main__":
    main()
