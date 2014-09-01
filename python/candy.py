#!/usr/bin/env python3

class Solution:
    # @param ratings, a list of integer
    # @return an integer
    def candy(self, ratings):
        res = 0
        n = len(ratings)
        lm = [0] * n
        rm = [0] * n
        for i in range(1, n):
            lm[i] = lm[i - 1] + 1 if ratings[i] > ratings[i - 1] else 0
        for i in reversed(range(0, n - 1)):
            rm[i] = rm[i + 1] + 1 if ratings[i] > ratings[i + 1] else 0
        for i in range(n):
            res += 1 + max(lm[i], rm[i])
        return res

def main():
    solver = Solution()
    ratings = [1, 2, 2]
    print(solver.candy(ratings))

if __name__ == '__main__':
    main()
