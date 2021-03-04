class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        length = 1
        left = 0
        right = 1
        ch_dict = {}
        ch_dict[s[0]]  = 1
        while left < len(s):
            if right < len(s):
                if s[right] not in ch_dict:
                    ch_dict[s[right]] = 0
                ch_dict[s[right]] += 1
                if ch_dict[s[right]] > 1:
                    length = max(length, right - left)
                    while s[left] != s[right]:
                        ch_dict[s[left]] -= 1
                        left += 1
                    ch_dict[s[left]] -= 1
                    left += 1
                    right += 1
                else:
                    right += 1
            else:
                length = max(length, right - left)
                break
        return length

if __name__ == '__main__':
    so = Solution()
    tests = [ "bbbbb", "pwwkew", "abcabcbb"]
    for test in tests:
        res = so.lengthOfLongestSubstring(test)
        print("{}: {}".format(test, res))