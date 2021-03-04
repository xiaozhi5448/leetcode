class Solution:
    # 解法1，选择可能是回文串的中心位置，向两边扩散
    def longestPalindrome(self, s: str) -> str:

        length = len(s)
        max_palindrome = ""
        max_len = 1
        if length < 2:
            return s
        max_palindrome = s[0]
        count_pos = (length - 2) * 2 + 1
        for i in range(count_pos):
            if i % 2 == 0:
                length = 0
                left_index = i // 2
                right_index = left_index + 1
                while left_index >= 0 and right_index < len(s):
                    if s[left_index] == s[right_index]:
                        length += 2
                    else:
                        break
                    left_index -= 1
                    right_index += 1
                if length > max_len:
                    max_len = length
                    max_palindrome = s[left_index + 1:right_index]
            else:
                mid_index = (i + 1) // 2
                left_index = mid_index - 1
                right_index = mid_index + 1
                length = 1
                while left_index >= 0 and right_index < len(s):
                    if s[left_index] == s[right_index]:
                        length += 2
                    else:
                        break
                    left_index -= 1
                    right_index += 1
                if length > max_len:
                    max_len = length
                    max_palindrome = s[left_index + 1:right_index]
        return max_palindrome

    def solution2(self, s):
        # 动态规划： 如果s[i:j]是回文串，那么s[i+1:j-1]也是回文串
        n = len(s)
        dp = [[False] * n for _ in range(n)]
        ans = ""
        # 枚举子串的长度 l+1
        for l in range(n):
            # 枚举子串的起始位置 i，这样可以通过 j=i+l 得到子串的结束位置
            for i in range(n):
                j = i + l
                if j >= len(s):
                    break
                if l == 0:
                    dp[i][j] = True
                elif l == 1:
                    dp[i][j] = (s[i] == s[j])
                else:
                    dp[i][j] = (dp[i + 1][j - 1] and s[i] == s[j])
                if dp[i][j] and l + 1 > len(ans):
                    ans = s[i:j + 1]
        return ans

if __name__ == '__main__':
    so = Solution()
    res = so.solution2("aaaaa")
    print(res)
