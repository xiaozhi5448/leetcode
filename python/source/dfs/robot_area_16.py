class Solution:
    def dfs(self, pos_x, pos_y, k, visited):
        if 0 <= pos_x < self.row and 0 <= pos_y < self.col:
            if visited[pos_x][pos_y]:
                return
            visited[pos_x][pos_y] = True
            x = sum([int(item) for item in list(str(pos_x))])
            y = sum([int(item) for item in list(str(pos_y))])
            if x+y <= k:
                self.count += 1
                self.dfs(pos_x - 1, pos_y, k, visited)
                self.dfs(pos_x + 1, pos_y, k, visited)
                self.dfs(pos_x, pos_y - 1, k, visited)
                self.dfs(pos_x, pos_y + 1, k, visited)
    def movingCount(self, m: int, n: int, k: int) -> int:
        visited = [[False] * n for _ in range(m)]
        self.count = 0
        self.row = m
        self.col = n
        self.dfs(0,0,k, visited)
        return self.count

if __name__ == '__main__':
    so = Solution()
    res = so.movingCount(11,8,16)
    print(res)