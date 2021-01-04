class Solution(object):

    def dfs(self, land, visited, row, col):
        # out of bound
        if row < 0 or row >= self.row_count or col < 0 or col >= self.col_count:
            return
        if not visited[row][col] and land[row][col] == 0:
            visited[row][col] = True
            self.pond_size += 1
            for row_index in range(row - 1, row + 2):
                for col_index in range(col - 1, col + 2):
                    if row_index == row and col_index == col:
                        continue
                    else:
                        self.dfs(land, visited, row_index, col_index)
        else:
            return

    def pondSizes(self, land):
        """
        :type land: List[List[int]]
        :rtype: List[int]
        """
        if not land:
            return []
        self.area = list()
        self.row_count = len(land)
        self.col_count = len(land[0])
        self.pond_size = 0
        visited = [[False] * self.col_count for _ in range(self.row_count)]
        for row in range(0, self.row_count):
            for col in range(0, self.col_count):
                self.pond_size = 0
                self.dfs(land, visited, row, col)
                if self.pond_size != 0:
                    self.area.append(self.pond_size)
        self.area.sort()
        return self.area


if __name__ == '__main__':
    so = Solution()
    l = [
        [0, 2, 1, 0],
        [0, 1, 0, 1],
        [1, 1, 0, 1],
        [0, 1, 0, 1]
    ]
    res = so.pondSizes(l)
    print(res)