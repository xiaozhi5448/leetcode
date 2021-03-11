import string
from typing import *
class Solution:

    def __init__(self):
        self.index = 0
        self.ops = {'+':1,'-':1,'*':2,'/':2}
        self.funcs = {'+':lambda num1,num2: num1+num2, '-': lambda num1, num2: num1-num2, '*': lambda num1,num2: num1*num2,
                      '/': lambda num1,num2:num1/num2}
    def parseInt(self, s):
        if self.index >= len(s) or s[self.index] > '9' or s[self.index] < '0':
            return 0
        left_index = self.index
        right_index = self.index
        while right_index < len(s) and '0' <= s[right_index] <= '9':
            right_index += 1
        self.index = right_index
        return int(s[left_index:right_index])

    def inFixToSuffix(self, s):
        operators = list()
        res = list()
        while self.index < len(s):
            if s[self.index] in self.ops:
                if len(operators) == 0 or operators[-1] == '(' or self.ops[s[self.index]] > self.ops[operators[-1]]:
                    operators.append(s[self.index])
                else:
                    while len(operators) != 0 and operators[-1] != '(' and self.ops[operators[-1]] >= self.ops[s[self.index]]:
                        res.append(operators.pop(-1))
                    operators.append(s[self.index])
            elif s[self.index] == '(':
                operators.append('(')
            elif s[self.index] >= '0' and s[self.index] <= '9':
                res.append(self.parseInt(s))
                self.index -= 1
            elif s[self.index] == ')':
                while len(operators) != 0 and operators[-1] != '(':
                    res.append(operators.pop(-1));
                operators.pop(-1)
            self.index += 1
        while len(operators) > 0:
            res.append(operators.pop(-1))
        return res

    def calVal(self, suffixEval:List):
        stack = list()
        for item in suffixEval:
            if type(item) == int:
                stack.append(item)
            else:
                num1 = stack.pop(-1)
                num2 = 0 if len(stack)==0 else stack.pop(-1)
                stack.append( self.funcs[item](num2, num1))
        return stack[0]
    def calculate(self, s: str) -> int:
        self.index = 0
        suffixExp = self.inFixToSuffix(s)
        return self.calVal(suffixExp)

if __name__ == '__main__':
    so = Solution()
    suffixExp = so.inFixToSuffix("-3+2*(2+5)")
    print(suffixExp)
    res = so.calVal(suffixExp)
    print(res)