from collections import OrderedDict

class LRUCache:
    def __init__(self, size):
        self.capacity = size
        self.map = OrderedDict()

    def get(self,k):
        if k not in self.map:
            return -1
        self.map.move_to_end(k)
        return self.map[k]

    def put(self, k, v):
        if k in self.map:
            self.map.pop(k)
        map[k] = v
        if len(self.map) > self.capacity:
            self.map.popitem(last=False)