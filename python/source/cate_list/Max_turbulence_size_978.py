from enum import Enum, unique
from typing import List

@unique
class Operator(Enum):
    Greater = 0
    Less = 1
    Equal = 2
    Any = 3


class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:

        if len(arr) < 2:
            return len(arr)
        left = 0
        while left + 1 < len(arr) and arr[left] == arr[left + 1]:
            left += 1
        right = left + 1
        max_len = 2
        if right >= len(arr):
            return 1
        operator = Operator.Greater if arr[right] > arr[right - 1] else Operator.Less
        while right < len(arr) - 1:
            if operator == Operator.Greater:
                operator = Operator.Less
                if arr[right + 1] < arr[right]:
                    right += 1
                    continue
                else:
                    max_len = max(max_len, right - left+1)
                    right += 1
                    left = right - 1
                    if arr[right] < arr[left]:
                        operator = Operator.Less
                    elif arr[right] == arr[left]:
                        operator = Operator.Equal
                    else:
                        operator = Operator.Greater
            elif operator == Operator.Less:
                operator = Operator.Greater
                if arr[right + 1] > arr[right]:
                    right += 1
                    continue
                else:
                    max_len = max(max_len, right - left+1)
                    right += 1
                    left = right - 1
                    if arr[right] < arr[left]:
                        operator = Operator.Less
                    elif arr[right] == arr[left]:
                        operator = Operator.Equal
                    else:
                        operator = Operator.Greater
            elif operator == Operator.Equal:
                right += 1
                left = right - 1
                if arr[right] < arr[left]:
                    operator = Operator.Less
                elif arr[right] == arr[left]:
                    operator = Operator.Equal
                else:
                    operator = Operator.Greater
        return max_len

if __name__ == '__main__':
    so = Solution()
    tests = [{
        'arr': [0,1,1,0,1,0,1,1,0,0]
    },{
        'arr':[9,9]
    },{
        'arr':[9,9,999]
    }]
    for nums in tests:
        res = so.maxTurbulenceSize(nums['arr'])
        print('{}:{}'.format( nums['arr'], res))