class Solution:

    def subq(self, nums, start, end):
        if start >= end:
            return True
        root = nums[end]
        index = end
        for i in range(start, end):
            if nums[i] > root:
                index = i
                break
        for i in range(start, index):
            if nums[i] > root:
                return False
        for i in range(index, end):
            if nums[i] < root:
                return False

        return self.subq(nums, start, index - 1) and self.subq(nums, index, end - 1)

    def verifyPostorder(self, postorder) -> bool:
        res = self.subq(postorder, 0, len(postorder) - 1)
        return res

if __name__ == '__main__':
    so = Solution()
    res = so.verifyPostorder([4,6,7,5])
    print(res)