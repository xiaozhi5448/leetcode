from queue import Queue

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        q = Queue()
        chs = set(nums)
        [q.put([num]) for num in nums]
        q.put(None)
        for _ in range(len(nums)-1):
            while True:
                item = q.get(timeout=0)
                if item == None:
                    q.put(None)
                    break
                else:
                    extras = chs - set(item)
                    for num in extras:
                        item.append(num)
                        q.put(list(item))
                        item.pop(-1)
        res = []
        while True:
            item = q.get(timeout=0)
            if item:
                res.append(item)
            else:
                break
        return res

if __name__ == '__main__':
    so = Solution()
    nums = list(range(3))
    res = so.permute(nums)
    print(res)

