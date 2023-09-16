from typing import List,Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    @classmethod
    def build_from_list(cls, vals:List):
        if not vals:
            return None
        header = None
        tailer = None
        for val in vals:
            node = ListNode(val)
            if header is None:
                header = node
                tailer = node
            else:
                tailer.next = node
                tailer = node
        return header

    @classmethod
    def show_list(cls, header):
        nums = []
        node = header
        while node:
            nums.append(node.val)
            node = node.next
        print(nums)


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1
        h1 = list1
        h2 = list2
        res_header = ListNode()
        res_end = res_header
        while h1 or h2:
            if not h1:
                res_end.next = h2
                break
            if not h2:
                res_end.next = h1
                break

            if h1.val <= h2.val:
                res_end.next = h1
                h1 = h1.next
                res_end = res_end.next
                res_end.next = None
            else:
                res_end.next = h2
                h2 = h2.next
                res_end = res_end.next
                res_end.next = None
        return res_header.next


if __name__ == '__main__':
    so = Solution()

    ListNode.show_list(ListNode.build_from_list([1,2,4]))
    res = so.mergeTwoLists(ListNode.build_from_list([1,2,4]), ListNode.build_from_list([1,3,4]))
    ListNode.show_list(res)