class Solution:

    def __ge_recursion_util(self, s:str, left_count:int, right_count:int):
        if len(s) == 2*self.pair_count:
            return self.brackets.append(s)
        else:
            if right_count > left_count:
                if left_count > 0:
                    self.__ge_recursion_util(s+'(', left_count-1, right_count)
                if right_count > 0:
                    self.__ge_recursion_util(s+')', left_count, right_count-1)
            elif right_count == left_count:
                if left_count > 0:
                    self.__ge_recursion_util(s+'(', left_count-1, right_count)
    def generateParenthesis(self, n: int) ->list:
        self.brackets = []
        self.pair_count = n
        self.__ge_recursion_util("", n, n)
        return self.brackets

if __name__ == '__main__':
    so = Solution()
    res = so.generateParenthesis(1)
    print(res)