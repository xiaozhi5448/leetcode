
class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s
        if not s:
            return ''
        length = len(s)
        count = length // (numRows+numRows-2)
        if length % (numRows + numRows-2) != 0:
            count += 1
        chs = [[" "] * (count)*2 for _ in range(numRows)]
        for i in range(count):
            start_index = i * (numRows + numRows-2)

            for index in range(numRows):
                if start_index + index >= length:
                    break
                chs[index][i*2] = s[start_index+index]

            for index in range(numRows-2, 0, -1):
                if start_index+numRows  + numRows-2 - index >= length:
                    break
                chs[index][2*i+1] = s[start_index+numRows  + numRows-2 - index]
        res = []
        for items in chs:
            res.extend([ch for ch in items if ch != ' '])
        return ''.join(res)

if __name__ == '__main__':
    so = Solution()
    res = so.convert("PAYPALISHIRING", 3)
    print(res)