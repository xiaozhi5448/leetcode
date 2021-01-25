def bin_search( nums, start, end, target):
    if start > end:
        return -1
    if start == end:
        if nums[start] == target:
            return start
        return -1
    mid = start + (end-start) // 2
    if nums[mid] == target:
        return mid
    elif nums[mid] < target:
        return bin_search(nums, mid + 1, end, target)
    elif nums[mid] > target:
        return bin_search(nums, start, mid - 1, target)

if __name__ == '__main__':
    nums = [0,1,2,4,5,6,7]
    for index, num in enumerate(nums):
        res = bin_search(nums,0, 6, num)
        print("finding {}; correct: {}; return: {}".format(num, index, res))
    res = bin_search(nums, 0, 6, 3)
    print("finding {}; correct: {}; return: {}".format(3, -1, res))
