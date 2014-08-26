#!/usr/bin/env python3

class Solution:
    def firstMissingPositive(self, A):
<<<<<<< HEAD
        n = len(A)
        for i in range(n):
            while 1 <= A[i] and A[i] <= n and A[i] != i + 1 and A[i] != A[A[i] - 1]:
                [A[A[i] - 1], A[i]] = [A[i], A[A[i] - 1]]
        res = 1
        for i in range(n):
            if i != A[i] - 1:
                break;
            res = res + 1
        return res

def main():
    solver = Solution()
    A = [1, 2, 0]
    print(solver.firstMissingPositive(A))
    A = [3, 4, 1, -1]
    print(solver.firstMissingPositive(A))
=======

def main():
    solver = Solution()
>>>>>>> 2bc44c3983579a698d0ef4332505d32020159440

if __name__ == '__main__':
    main()
