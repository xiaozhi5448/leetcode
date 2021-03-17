from collections import defaultdict
from typing import List
class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        res = [-1] * len(rains)
        prevRains = dict()
        sunny = []
        for i in range(len(rains)):
            if rains[i] == 0:
                sunny.append(i)
            else:
                if rains[i] not in prevRains:
                    prevRains[rains[i]] = i
                else:
                    prevRainDate = prevRains[rains[i]]
                    for j in range(len(sunny)):
                        if sunny[j] > prevRainDate:
                            res[sunny[j]] = rains[i]
                            sunny.remove(sunny[j])
                            prevRains[rains[i]] = -1
                            break
                    if prevRains[rains[i]] == -1:
                        prevRains[rains[i]] = i
                    else:
                        return []
        while sunny:
            res[sunny.pop(-1)] = 1
        return res

if __name__ == '__main__':
    so = Solution()
    res = so.avoidFlood([1,2,0,0,2,1])
    print(res)