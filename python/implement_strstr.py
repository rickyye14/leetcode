#!/usr/bin/env python3

class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return a string or None
    def strStr(self, s, p):
        if s is None or p is None:
            return None
        n, m = len(s), len(p)
        if m == 0:
            return s
        res = None
        fails = [-1] * m
        ptr = -1
        for i in range(1, m):
            while ptr != -1 and p[ptr + 1] != p[i]:
                ptr = fails[ptr]
            if p[ptr + 1] == p[i]:
                ptr += 1
            fails[i] = ptr
        ptr = -1
        for i in range(0, n):
            while ptr != -1 and p[ptr + 1] != s[i]:
                ptr = fails[ptr]
            if p[ptr + 1] == s[i]:
                ptr += 1
            if ptr == m - 1:
                res = s[i - m + 1:]
                break
        return res

def main():
    solver = Solution()
    print(solver.strStr('abedfsdfl', 'dfs'))

if __name__ == '__main__':
    main()
