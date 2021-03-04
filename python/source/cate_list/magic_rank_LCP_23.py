class Solution:
    def isMagic(self, target) -> bool:
        count = len(target)
        original_nums = list(range(1, len(target) + 1))
        first_sorted = []
        odd_nums = [original_nums[i] for i in range(count) if i % 2 == 0]
        other_nums = [original_nums[i] for i in range(count) if i %2 != 0]
        first_sorted = other_nums + odd_nums

        prefix = 0
        while prefix < count and  first_sorted[prefix] == target[prefix]:
            prefix += 1
        if not prefix:
            return False
        elif prefix == count:
            return True
        prev_sorted = first_sorted
        counter = 0
        def same(nums1, nums2):
            for num1, num2 in zip(nums1, nums2):
                if num1 != num2:
                    return False
            return True
        while prev_sorted:
            if not same(target[counter:counter + prefix], prev_sorted[:prefix]):
                return False
            prev_sorted = prev_sorted[prefix:]
            odd_nums = [prev_sorted[i] for i in range(len(prev_sorted)) if i % 2 == 0]
            other_nums = [prev_sorted[i] for i in range(len(prev_sorted)) if i %2 != 0]
            prev_sorted = other_nums + odd_nums
            counter += prefix
        return True



if __name__ == '__main__':
    so = Solution()
    nums = [2,4,3,1,5]
    res = so.isMagic(nums)
    print(res)