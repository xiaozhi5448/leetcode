class Solution:

    def combRecursion(self, candidates,nums, index,  bound):
        if bound == 0:
            self.res.append(nums.copy())
        elif index >= self.length or bound < 0:
            return
        else:
            self.combRecursion(candidates, nums, index+1, bound)
            nums.append(candidates[index])
            self.combRecursion(candidates, nums, index, bound - candidates[index])
            # self.combRecursion(candidates, nums, index+1, bound - candidates[index])
            nums.pop(-1)
    def combRecursion2(self, candidates, nums, index, bound):
        if bound == 0:
            self.res.append(nums.copy())
        elif index >= self.length or bound < 0:
            return
        else:
            for i in range(self.num_dict[candidates[index]] + 1):
                nums.extend([candidates[index]] * i)
                self.combRecursion2(candidates, nums, index+1, bound-i*candidates[index])
                for _ in range(i):
                    nums.pop(-1)

            # self.combRecursion(candidates, nums, index+1, bound - candidates[index])

    def combinationSum(self, candidates: list, target: int):
        self.res = []
        self.length = len(candidates)
        candidates.sort()
        self.combRecursion(candidates, [], 0, target)
        return self.res

    def combinationSum2(self, candidates:list, target:int):
        self.num_dict = {}

        for num in candidates:
            if num not in self.num_dict:
                self.num_dict[num] = 1
            else:
                self.num_dict[num] += 1
        new_candidates = list(self.num_dict.keys())
        self.length = len(new_candidates)
        new_candidates.sort()
        self.res = []
        self.combRecursion2(new_candidates, [], 0, target)
        return self.res

if __name__ == '__main__':
    so = Solution()
    tests = [{'candidates':[2,3,6,7], 'target': 7},
             {'candidates':[2,3,5], 'target': 8},
             {'candidates':[10,1,2,7,6,1,5], 'target':8}]
    for test in tests:
        res = so.combinationSum2(test['candidates'], test['target'])
        print(res)