class Solution:
    def removeDuplicates(self, nums: list) -> int:
        i = 0
        j = 1
        while j < len(nums):
            if nums[j] == nums[i]:
                j += 1
            else:
                nums[i+1] = nums[j]
                i += 1
        return i+1

    # 给你一个数组
    # nums 和一个值
    # val，你需要
    # 原地
    # 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    #
    # 不要使用额外的数组空间，你必须仅使用
    # O(1)
    # 额外空间并
    # 原地
    # 修改输入数组。
    #
    # 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

    def removeElement(self, nums:list, val:int):
        i = 0
        j = 0
        length = len(nums)
        while j < length and i < length:
            while i < length and nums[i] != val:
                i += 1
            if i == length:
                return i
            j = i+1
            while j < length and nums[j] == val:
                j += 1
            if j == length:
                return i
            nums[i] = nums[j]
            nums[j] = val
        return i



import random

if __name__ == '__main__':
    so = Solution()
    l = [0,0,1,1,1,2,2,3,3,4]
    # res = so.removeDuplicates(l)
    random.shuffle(l)
    res = so.removeElement(l, 1)
    print(l)
    print(res)