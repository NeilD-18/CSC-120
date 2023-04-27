def print_board():
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


def row_all_same(the_board, row):
    return (board[row][0] == board[row][1] == board[row][2])


def column_all_same(column):
    return (column[0] == column[1] == column[2])


def diagonal_all_same(diagonal):
    return (diagonal[0] == diagonal[1] == diagonal[2])


def get_back_slash():
    return [board[i][i] for i in range(len(board))]


def get_forward_slash():
    return [board[len(board)-i-1][i] for i in range(len(board))]


def columns(board):
    num_cols = len(board[0])
    num_rows = len(board)
    
    to_return = []
    
    for i in range(num_cols):
        col_str = ''
        for j in range(num_rows):
            col_str += board[j][i]
        to_return.append(col_str)
    return to_return


def check_winner():
    global winner
    for row_num, row in enumerate(board):
        if row_all_same(board, row_num):
            winner = board[row_num][0]
            return
        
    for col in columns(board):
        if column_all_same(col):
            winner = col[0]
            return
    
    if diagonal_all_same(get_back_slash()):
        winner = board[0][0]
        return
    
    if diagonal_all_same(get_forward_slash()):
        winner = board[2][0]
        return


def get_board_from_file(filename):
    board_list = []
    board_file = open(filename,"r")
    for line in board_file:
        board_list.append(line.strip())
    board_file.close()
    return board_list


inputfile = 'input.txt'
board = get_board_from_file(inputfile)

print_board()

winner = ''
check_winner()

if winner != '':    
    print(winner + ' WINS!!!!')
else:
    print("TIE GAME!!!!")
