from sortedcontainers import SortedList
class Solution:
    def longestSubarray(self, nums, limit):
        length = len(nums)
        if not length:
            return 0
        left = right = ret = 0
        container = SortedList()
        while right < length:
            container.add(nums[right])
            while container[-1] - container[0] > limit:
                container.remove(nums[left])
                left += 1
            ret = max(ret, right-left+1)
            right+=1
        return ret

    def pushDominoes(self, dominoes: str) -> str:
        if len(dominoes) < 2:
            return dominoes
        left, right = 0, 1
        res = ['' for i in range(len(dominoes))]
        while left < len(dominoes):
            ele = dominoes[left]
            while right < len(dominoes) and dominoes[right] == '.':
                right += 1
            if right == len(dominoes):
                if ele == 'R':
                    for i in range(left, right):
                        res[i] = 'R'
                    return ''.join(res)
                elif ele == 'L':
                    for i in range(left, right):
                        res[i] = dominoes[i]
            else:
                if ele == '.':
                    if dominoes[right] == 'L':
                        for i in range(left, right):
                            res[i] = 'L'
                    elif dominoes[right] == 'R':
                        for i in range(left, right):
                            res[i] = dominoes[i]
                elif ele == 'L':
                    if dominoes[right] == 'L':
                        for i in range(left, right):
                            res[i] = 'L'
                    elif dominoes[right] == 'R':
                        for i in range(left, right):
                            res[i] = dominoes[i]
                elif ele == 'R':
                    if dominoes[right] == 'R':
                        for i in range(left, right):
                            res[i] = 'R'
                    elif dominoes[right] == 'L':
                        i, j = left, right
                        while i < j:
                            res[i], res[j] = 'R', 'L'
                            i += 1
                            j -= 1
                        if i == j:
                            res[i] = dominoes[i]
            left = right
            right += 1
        return ''.join(res)

if __name__ == '__main__':
    solution = Solution()
    print(solution.pushDominoes(".L.R."))
