#!/usr/bin/env python3

class Solution:
    # @return a string
    def minWindow(self, S, T):
        hist_t = [0] * 256
        hist_s = [0] * 256
        for c in T:
            hist_t[ord(c)] += 1
        n = len(S)
        i, j = 0, 0
        while j < n:

def main():
    solver = Solution()

if __name__ == '__main__':
    main()
