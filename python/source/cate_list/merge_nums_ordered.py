from typing import List

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        dest = m + n - 1
        m_pivot = m - 1
        n_pivot = n - 1
        res = nums1
        while dest >= 0:

            if m_pivot < 0:
                res[dest] = nums2[n_pivot]
                n_pivot -= 1
                dest -= 1
                continue

            if n_pivot < 0:
                res[dest] = nums1[m_pivot]
                m_pivot -= 1
                dest -= 1
                continue

            if nums1[m_pivot] > nums2[n_pivot]:
                res[dest] = nums1[m_pivot]
                m_pivot -= 1

            elif nums1[m_pivot] < nums2[n_pivot]:
                res[dest] = nums2[n_pivot]
                n_pivot -= 1

            else:
                res[dest] = nums1[m_pivot]
                dest -= 1
                res[dest] = nums2[n_pivot]
                m_pivot -= 1
                n_pivot -= 1
            dest -= 1


if __name__ == '__main__':
    nums1 = [2,0]
    solution = Solution()
    solution.merge(nums1, 1, [1], 1)
    print(nums1)