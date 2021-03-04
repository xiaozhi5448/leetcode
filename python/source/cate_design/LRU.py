#
# lru design
# @param operators int整型二维数组 the ops
# @param k int整型 the k
# @return int整型一维数组
#
from collections import OrderedDict


class LRUCache(object):
    def __init__(self, capacity):
        self.capacity = capacity
        self.container = OrderedDict()
        self.size = 0

    def get(self, key):
        if key not in self.container:
            return -1
        else:
            val = self.container.pop(key)
            self.container[key] = val
            return val

    def set(self, key, val):
        if self.size >= self.capacity:
            self.container.popitem(last=False)
            self.size -= 1
        if key not in self.container:
            self.container[key] = val
            self.size += 1
        else:
            self.container.pop(key)
            self.container[key] = val


class Solution:
    def LRU(self, operators, k):
        cache = LRUCache(k)
        res = []
        for command in operators:
            if command[0] == 2:
                res.append(cache.get(command[1]))
            elif command[0] == 1:
                cache.set(command[1], command[2])
        print(res)
        return res