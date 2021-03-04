class Solution:
    def dfs(self, rank:list, visited:list):
        if len(rank) == self.length:
            self.res.append(rank.copy())
        else:
            for i, num in enumerate(self.nums):
                if visited[i]:
                    continue
                else:
                    visited[i] = True
                    rank.append(self.nums[i])
                    self.dfs(rank, visited)
                    visited[i] = False
                    rank.pop(-1)
    def permute(self, nums):
        self.length = len(nums)
        self.res = []
        self.nums = nums
        visited = [False] * self.length
        self.dfs([], visited)
        return self.res

if __name__ == '__main__':
    so = Solution()
    res = so.permute([1,2,3])
    print(res)