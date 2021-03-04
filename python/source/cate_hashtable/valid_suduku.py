class Solution:
    def isValidSudoku(self, board) -> bool:
        row_sets = [set() for _ in range(len(board))]
        col_sets = [set() for _ in range(len(board[0]))]
        sub_sudu = [set() for _ in range(9)]
        for row in range(9):
            for col in range(9):
                sub_index = row //3 * 3 + col // 3
                if board[row][col] != '.':
                    if board[row][col] not in sub_sudu[sub_index]:
                        sub_sudu[sub_index].add(board[row][col])
                    else:
                        return False
                    if board[row][col] not in row_sets[row]:
                        row_sets[row].add(board[row][col])
                    else:
                        return False
                    if board[row][col] not in col_sets[col]:
                        col_sets[col].add(board[row][col])
                    else:
                        return False
        return True
