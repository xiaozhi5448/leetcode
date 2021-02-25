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


if __name__ == '__main__':
    import random
    nums = [6,2,6,5,1,2]
    random.shuffle(nums)
    so = SortUtil()
    so.quick_sort(nums, 0, len(nums) - 1)
    print(nums)
