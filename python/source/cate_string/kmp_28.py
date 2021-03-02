class Solution:

    def cal_next(self, search):
        def next(info):
            if not info or len(info) == 1:
                return 0
            start_ch = info[0]
            val = 0
            start = 1
            while True:
                val = 0
                try:
                    start = search[start:].index(start_ch)
                except ValueError as e:
                    break
                left = 0
                right = start
                while search[left] == search[right] and right < len(search):
                    left += 1
                    right += 1
                    val += 1
                if right == len(search):
                    break
            return val





        res = [0] * len(search)
        for i in range(0, len(search)):
            res[i] = next(search[0:i+1])

    def strStr(self, haystack: str, needle: str) -> int:
        pass