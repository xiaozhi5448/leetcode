from typing import List
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    @classmethod
    def build_from_array(cls, nums:List[int], index:int):
        if index >= len(nums):
            return
        node = ListNode(nums[index])
        node.next = cls.build_from_array(nums, index+1)
        return node

    @classmethod
    def show_list(cls, node):
        nums = []
        node_ptr = node
        while node_ptr:
            nums.append(str(node_ptr.val))
            node_ptr = node_ptr.next
        print('->'.join(nums))

    def __str__(self):
        return 'Node({})'.format(self.val)
