#!/usr/bin/env python3

class Solution:
    def trap(self, A):
        if A is None:
            return 0
        n = len(A)
        if n == 0:
            return 0
        left_high = [0] * n
        left_high[0] = A[0]
        for i in range(1, n):
            left_high[i] = max(left_high[i - 1], A[i])
        right_high = [0] * n
        right_high[n - 1] = A[n - 1]
        for i in reversed(range(0, n - 1)):
            right_high[i] = max(right_high[i + 1], A[i])
        res = 0
        for i in range(1, n - 1):
            res = res + max(0, min(left_high[i - 1], right_high[i + 1]) - A[i])
        return res

def main():
    solver = Solution()
    A = [0,1,0,2,1,0,1,3,2,1,2,1]
    print(solver.trap(A))
    A = [0]
    print(solver.trap(A))
    A = [0, 1]
    print(solver.trap(A))
    A = [2, 1, 2]
    print(solver.trap(A))
    A = None
    print(solver.trap(A))
    A = []
    print(solver.trap(A))

if __name__ == '__main__':
    main()
