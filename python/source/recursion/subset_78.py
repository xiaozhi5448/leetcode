class Solution(object):
    length = 0
    res = []
    t = []
    # 使用递归，每个位置可以考虑或者不考虑
    def dfs(self, cur: int, nums: list):
        if cur == self.length:
            self.res.append(self.t.copy())
        else:
            self.t.append(nums[cur])
            self.dfs(cur + 1, nums)
            self.t.pop(-1)
            self.dfs(cur + 1, nums)

    # 使用二进制，某个位置为1表示选择该数
    def bruteforce(self, nums):
        res = []
        length = len(nums)
        for i in range(2**length):
            t = []
            for bit_index in range(length):
                if i >> bit_index & 1:
                    t.append(nums[bit_index])
            res.append(t)
        return res


    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        self.t = list()
        self.res = []
        self.length = len(nums)
        self.dfs(0, nums)
        return self.res

if __name__ == '__main__':
    so = Solution()
    l2 = list(range(3))
    res = so.bruteforce(l2)
    print(res)
