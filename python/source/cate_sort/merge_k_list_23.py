# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:

    def merge_two_list(self, l1, l2):
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

    def mergeKLists(self, lists: list) -> ListNode:
        if not lists:
            return None
        res = []
        head = ListNode(0, None)
        node = head
        while None in lists:
            lists.remove(None)
        while lists:
            lists.sort(key=lambda node: node.val)
            node.next = lists[0]
            if lists[0].next is None:
                lists.pop(0)
            else:
                lists[0] = lists[0].next
            node = node.next
            node.next = None
            while None in lists:
                lists.remove(None)
        return head.next