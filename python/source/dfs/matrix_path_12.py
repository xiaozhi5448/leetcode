class Solution(object):

    def dfs(self, board, visited, ch_index, row, col):
        if row < 0 or row >= self.row_count or col < 0 or col >= self.col_count or board[row][col] != self.chs[
            ch_index] or visited[row][col]:
            return False
        else:
            visited[row][col] = True
            if ch_index == len(self.chs) - 1:
                return True
            res = self.dfs(
                board, visited, ch_index + 1, row - 1, col) or self.dfs(
                board, visited, ch_index + 1, row + 1, col) or self.dfs(
                board,visited,ch_index + 1,row,col - 1) or self.dfs(
                board, visited, ch_index + 1, row, col + 1)
            visited[row][col] = False
            return res

    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if len(word) == 0 and len(board) == 0:
            return True
        elif not board:
            return False
        self.row_count = len(board)
        self.col_count = len(board[0])
        visited = [[False] * self.col_count for _ in range(self.row_count)]
        self.chs = list(word)
        for row in range(self.row_count):
            for col in range(self.col_count):
                if board[row][col] == word[0]:
                    res = self.dfs(board, visited, 0, row, col)
                    if res:
                        return True
        return False

    def exist2(self, board, word: str) -> bool:
        def dfs(i, j, k):
            if not 0 <= i < len(board) or not 0 <= j < len(board[0]) or board[i][j] != word[k]: return False
            if k == len(word) - 1: return True
            board[i][j] = ''
            res = dfs(i + 1, j, k + 1) or dfs(i - 1, j, k + 1) or dfs(i, j + 1, k + 1) or dfs(i, j - 1, k + 1)
            board[i][j] = word[k]
            return res

        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, 0): return True
        return False


if __name__ == '__main__':
    so = Solution()
    board = [['a', 'a']]
    word = 'aaa'
    res = so.exist(board, word)
    print(res)
