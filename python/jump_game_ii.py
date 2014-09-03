#!/usr/bin/env python3

class Solution:
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


if __name__ == '__main__':
    main()
