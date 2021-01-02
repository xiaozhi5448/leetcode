# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        preHead = ListNode(-1)
        prev = preHead
        while l1 and l2:
            if l1.val > l2.val:
                prev.next = l2
                l2 = l2.next;
            else:
                prev.next = l1
                l1 = l1.next
            prev = prev.next
        l = l1 if l1 else l2
        prev.next = l
        return preHead.next
def print_list(head:list):
    node = head
    while node:
        print(node.val, end=',')
        node = node.next
if __name__ == '__main__':
    l1 = ListNode(1,ListNode(3,ListNode(4, None)))
    l2 = ListNode(1, ListNode(2, ListNode(4,None)))
    so = Solution()
    l3 = so.mergeTwoLists(l1, l2)
    print_list(l3)