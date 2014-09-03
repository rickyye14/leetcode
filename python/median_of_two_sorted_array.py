#!/usr/bin/env python3

class Solution:
    # @return a float
    def findMedianSortedArrays(self, A, B):
        n, m = len(A), len(B)
        if (n + m) % 2 != 0:
            return self.findKthElementInTwoArrays(A, B, (n + m + 1) // 2)
        else:
            return (self.findKthElementInTwoArrays(A, B, (n + m) // 2) + \
                    self.findKthElementInTwoArrays(A, B, (n + m) // 2 + 1)) * 0.5

    def findKthElementInTwoArrays(self, A, B, k):
        l1, r1, m1 = 0, len(A) - 1, 0
        l2, r2, m2 = 0, len(B) - 1, 0
        while l1 <= r1 and l2 <= r2:
            m1, m2 = (l1 + r1) // 2, (l2 + r2) // 2
            if A[m1] <= B[m2]:
                if k > m1 - l1 + m2 - l2 + 1:
                    k -= m1 - l1 + 1
                    l1 = m1 + 1
                else:
                    r2 = m2 - 1
            else:
                if k > m1 - l1 + m2 - l2 + 1:
                    k -= m2 - l2 + 1
                    l2 = m2 + 1
                else:
                    r1 = m1 - 1
        if l1 <= r1:
            return A[l1 + k - 1]
        else:
            return B[l2 + k - 1]

def main():
    solver = Solution()
    print(solver.findMedianSortedArrays([1], [1]))
    print(solver.findMedianSortedArrays([1, 1], [1, 1]))

if __name__ == '__main__':
    main()
