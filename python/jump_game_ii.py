#!/usr/bin/env python3

class Solution:
<<<<<<< HEAD
    def jump(self, A):
        if A is None:
            return -1
        res = 0
        n = len(A)
        last = 0
        curr = 0
        for i in range(n):
            if i > last:
                last = curr
                res += 1
            curr = max(curr, i + A[i])
        return res

def main():
    solver = Solution()
    print(solver.jump([2, 3, 1, 1, 4]))
=======
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
        if A is None:
            return 0
        n = len(A)
        if n == 0:
            return 0

def main():
    solver = Solution()
>>>>>>> 2bc44c3983579a698d0ef4332505d32020159440

if __name__ == '__main__':
    main()
