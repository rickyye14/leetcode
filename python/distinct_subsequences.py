#!/usr/bin/env python3

class Solution:
    # @param two strings
    # @return an integer
    def numDistinct(self, S, T):
        n = len(S)
        m = len(T)
        if n < m:
            return 0
        dp = [0] * (m + 1)
        dp[m] = 1
        for i in reversed(range(n)):
            for j in range(m - min(m, n - i), m):
                if S[i] == T[j]:
                    dp[j] += dp[j + 1]
        return dp[0]

def main():
    solver = Solution()
    print(solver.numDistinct('rabbbit', 'rabbit'))

if __name__ == '__main__':
    main()
