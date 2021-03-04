# Definition for singly-linked list.
from cate_list.Node import ListNode

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        def build_list(nums: list, index):
            if index >= len(nums):
                return None
            node = ListNode(nums[index])
            next = build_list(nums, index + 1)
            node.next = next
            return node

        nums1 = []
        nums2 = []
        node_ptr = l1
        while node_ptr:
            nums1.append(node_ptr.val)
            node_ptr = node_ptr.next
        node_ptr = l2
        while node_ptr:
            nums2.append(node_ptr.val)
            node_ptr = node_ptr.next
        length1 = len(nums1)
        length2 = len(nums2)
        if length2 < length1:
            nums2 = [0] * abs(length1 - length2) + nums2
        else:
            nums1 = [0] * abs(length1 - length2) + nums1
        bits = []
        carrier = 0
        for i in range(len(nums1)-1, -1, -1):
            current_res = nums1[i] + nums2[i] + carrier
            current_bit = current_res % 10
            carrier = current_res // 10
            bits.insert(0, current_bit)
        if carrier != 0:
            bits.insert(0, 1)
        root = build_list(bits, 0)
        return root

if __name__ == '__main__':
    so = Solution()
    l1 = ListNode.build_from_array([7,2,4,3],0)
    l2 = ListNode.build_from_array([7,5,6,4],0)
    l3 = so.addTwoNumbers(l1, l2)
    ListNode.show_list(l3)


