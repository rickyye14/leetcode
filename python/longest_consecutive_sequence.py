#!/usr/bin/env python3

class Solution:
    # @param num, a list of integer
    # @return an integer
    def longestConsecutive(self, num):
        if num is None:
            return 0
        n = len(num)
        if n < 2:
            return n
        track = dict()
        res = 0
        for v in num:
            if v in track:
                continue
            leftmost = track[v - 1] if (v - 1) in track else 0
            rightmost = track[v + 1] if (v + 1) in track else 0
            track[v - leftmost] = track[v + rightmost] = track[v] = leftmost + rightmost + 1
            res = max(res, track[v])
        return res

def main():
    solver = Solution()
    print(solver.longestConsecutive([100, 4, 200, 1, 3, 2]))

if __name__ == '__main__':
    main()
