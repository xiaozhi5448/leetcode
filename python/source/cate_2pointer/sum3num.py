class Solution:
    # 排序加双指针
    def threeSum(self, nums: list) -> list:

        nums.sort()
        res = []
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            right = len(nums) - 1
            for j in range(i+1, len(nums)-1):
                if j > i+1 and nums[j] == nums[j-1]:
                    continue
                while nums[i] + nums[j] + nums[right] >0 and right > j:
                    right -= 1
                if right ==j:
                    break
                if nums[i] + nums[j] + nums[right] == 0:
                    res.append([nums[i], nums[j], nums[right]])
        return res

if __name__ == '__main__':
    test = [0,0,0,0]
    so = Solution()
    res = so.threeSum(test)
    print(res)
