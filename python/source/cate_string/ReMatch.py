class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        res = s
        i = 0
        while i < len(p):
            if p[i] not in '.*':

                if i + 1 < len(p):
                    if p[i+1] == '*':
                        i+=1
                        continue
                if res[0] == p[i]:
                    res = res[1:]
                else:
                    return False
            elif p[i] == '*':
                if p[i-1] != '.':
                    res = res.lstrip(p[i-1])
                else:
                    res = ""
            elif p[i] == '.':
                if i+1 < len(p):
                    if p[i+1] == '*':
                        i+=1
                        continue
                res = res[1:]
            i+=1
            if not s:
                break
        if not res and i == len(p):
            return True
        else:
            return False

if __name__ == '__main__':
    so = Solution()

    res = so.isMatch("mississippi", "mis*is*p*.")
    res = so.isMatch("mississippi", "mis*is*ip*.")
    print(res)