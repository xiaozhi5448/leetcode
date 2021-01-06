class Solution:
    def calcEquation(self, equations, values, queries):
        map_factors = dict()
        if not queries:
            return []
        for equation, val in zip(equations, values):
            ch1 = equation[0]
            ch2 = equation[1]
            if ch1 not in map_factors:
                map_factors[ch1] = {ch1:1.0}
            map_factors[ch1][ch2] = val
            if ch2 not in map_factors:
                map_factors[ch2] = {ch2:1.0}
            map_factors[ch2][ch1] = 1.0 / val
        res = []
        for a,b in queries:
            if a not in map_factors or b not in map_factors:
                res.append(-1.0)
                continue
            commons = map_factors[a].keys() & map_factors[b].keys()
            if not commons:
                res.append(-1.0)
                continue
            else:
                factor = commons.pop()
                val = map_factors[a][factor] / map_factors[b][factor]
                res.append(val)
        return res

if __name__ == '__main__':
    equations = [["x1", "x2"], ["x2", "x3"], ["x3", "x4"], ["x4", "x5"]]
    values = [3.0, 4.0, 5.0, 6.0]
    querys = [["x1", "x5"], ["x5", "x2"], ["x2", "x4"], ["x2", "x2"], ["x2", "x9"], ["x9", "x9"]]
    so = Solution()
    res = so.calcEquation(equations, values, querys)
    print(res)
