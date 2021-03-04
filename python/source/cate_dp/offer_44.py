class Solution:
    def findNthDigit(self, n: int) -> int:
        if n == 0:
            return 0
        str_len = 0
        current_bit_len = 1
        start_point = 0
        while str_len < n:
            num_count = 9 * pow(10, current_bit_len-1)
            step = num_count * current_bit_len
            if step + str_len >= n:
                break
            start_point += num_count
            str_len += step
            current_bit_len += 1
        step_len = n - str_len
        res = step_len // current_bit_len
        remainder = step_len % current_bit_len
        if remainder:
            res += 1
        res += start_point
        chs = list(str(res))
        # chs.reverse()
        return int(chs[remainder-1])

if __name__ == '__main__':
    so = Solution()
    res = so.findNthDigit(1000)
    print(res)