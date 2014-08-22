#!/usr/bin/env python3

class Solution:
    def minCut(self, s):
        n = len(s)
        dp = [n] * (n + 1);
        dp[n] = 0
        for i in range(n - 1, -1, -1):
            l = i
            r = i
            while 0 <= l and r < n and s[l] == s[r]:
                dp[l] = min(dp[l], dp[r + 1] + 1)
                l = l - 1
                r = r + 1
            l = i - 1
            r = i
            while 0 <= l and r < n and s[l] == s[r]:
                dp[l] = min(dp[l], dp[r + 1] + 1)
                l = l - 1
                r = r + 1
        return dp[0] - 1

def main():
    solver = Solution()
    print(solver.minCut("aab"))
    print(solver.minCut("ccaacabacb"))

if __name__ == "__main__":
    main()
