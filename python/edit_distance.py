#!/usr/bin/env python3

class Solution:
    # @param two strings
    # @return an integer
    def minDistance(self, word1, word2):
        if len(word1) > len(word2):
            word1, word2 = word2, word1
        n, m = len(word1), len(word2)
        dp = [ [n for j in range(m + 1)] for i in range(n + 1)]
        for i in range(n + 1):
            dp[i][m] = n - i
        for j in range(m + 1):
            dp[n][j] = m - j
        for i in reversed(range(n)):
            for j in reversed(range(m)):
                if word1[i] == word2[j]:
                    dp[i][j] = dp[i + 1][j + 1]
                else:
                    dp[i][j] = min(dp[i + 1][j + 1] + 1, dp[i + 1][j] + 1, dp[i][j + 1] + 1)
        return dp[0][0]

def main():
    solver = Solution()
    print(solver.minDistance('abcdef', 'adf'))
    print(solver.minDistance('ab', 'a'))
    print(solver.minDistance('spartan', 'part'))

if __name__ == '__main__':
    main()
