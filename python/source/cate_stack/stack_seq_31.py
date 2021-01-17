class Solution:
    def validateStackSequences(self, pushed, popped) -> bool:
        if not pushed or not popped:
            return True
        pushed_index = 1
        lA = []
        lA.append(pushed[0])
        pop_index = 0
        length = len(pushed)
        while pop_index < length:
            while lA and lA[-1] != popped[pop_index] and pushed_index < length:
                lA.append(pushed[pushed_index])
                pushed_index += 1
            if pushed_index == length and lA[-1] != popped[pop_index]:
                return False
            else:
                lA.pop(-1)
                pop_index += 1
                if pop_index >= length:
                    break
                if not lA and pushed_index < length:
                    lA.append(pushed[pushed_index])
                    pushed_index += 1
        return True


if __name__ == '__main__':
    tests = [{
        'pushed': [4,0,1,2,3],
        'popped': [4,2,3,0,1]
    }]
    so = Solution()
    res = so.validateStackSequences(tests[0]['pushed'], tests[0]['popped'])
    print(res)