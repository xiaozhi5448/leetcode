from typing import List
class SortUtil(object):
    def __init__(self):
        pass

    def quicksort(self, items:list, low, high):
        def partition(arr, low, high):
            i = (low - 1)  # 最小元素索引
            pivot = arr[high]
            for j in range(low, high):
                # 当前元素小于或等于 pivot
                if arr[j] <= pivot:
                    i = i + 1
                    arr[i], arr[j] = arr[j], arr[i]
            arr[i + 1], arr[high] = arr[high], arr[i + 1]
            return (i + 1)
        if low < high:
            pi = partition(items, low, high)
            self.quicksort(items, low, pi - 1)
            self.quicksort(items, pi + 1, high)

    def quick_sort(self, nums, start, end):
        def partition(nums, start, end):
            if start < end:
                pivot = nums[end]
                index = start-1
                for i in range(start, end):
                    if nums[i] <= pivot:
                        index += 1
                        nums[index], nums[i] = nums[i], nums[index]
                nums[index+1], nums[end] = nums[end], nums[index+1]
                return index+1
            return start
        if start < end:
            mid = partition(nums, start, end)
            self.quicksort(nums, start, mid-1)
            self.quicksort(nums, mid+1, end)

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        mul_left = [0] * len(nums)
        mul_right = [0] * len(nums)
        mul_left[0] = 1
        mul_right[-1] = 1
        for i in range(1, len(nums)):
            mul_left[i] = nums[i-1] * mul_left[i-1]

        for i in range(len(nums)-2, -1, -1):
            mul_right[i]  = nums[i+1] * mul_right[i+1]

        res = [0] * len(nums)
        for i in range(i):
            res[i] = mul_left[i] * mul_right[i]
        return res



if __name__ == '__main__':
    import random
    nums = [6,2,6,5,1,2]
    random.shuffle(nums)
    so = SortUtil()
    so.quick_sort(nums, 0, len(nums) - 1)
    print(nums)

    so.productExceptSelf([1,2,3,4])

