#!/usr/bin/env python3

class Solution:
    # @return a boolean
    def isInterleave(self, s1, s2, s3):
        if s1 is None or s2 is None or s3 is None:
            return False
        n, m = len(s1), len(s2)
        if n + m != len(s3):
            return False
        if n == 0:
            return s2 == s3
        if m == 0:
            return s1 == s3
        dp = [ [False for x in range(m + 1)] for x in range(n + 1)]
        dp[0][0] = True
        for i in range(n):
            if s1[i] == s3[i]:
                dp[i + 1][0] = True
            else:
                break
        for j in range(m):
            if s2[j] == s3[j]:
                dp[0][j + 1] = True
            else:
                break
        for i in range(n):
            for j in range(m):
                dp[i + 1][j + 1] = dp[i][j + 1] and s1[i] == s3[i + j + 1] or dp[i + 1][j] and s2[j] == s3[i + j + 1]
        return dp[n][m]

def main():
    solver = Solution()
    s1 = 'aabcc'
    s2 = 'dbbca'
    s3 = 'aadbbcbcac'
    print(solver.isInterleave(s1, s2, s3))
    s3 = 'aadbbbaccc'
    print(solver.isInterleave(s1, s2, s3))

if __name__ == '__main__':
    main()
