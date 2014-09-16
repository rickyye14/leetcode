#!/usr/bin/env python3

class Solution:
    # @return a string
    def minWindow(self, S, T):
        if not S or not T:
            return ''
        n, m = len(S), len(T)
        buckets = [0] * 256
        for c in T:
            buckets[ord(c)] += 1
        num_chs = sum([x != 0 for x in buckets])
        l, r = 0, 0
        k = 0
        min_range = [0, n + 1]
        while r < n:
            while r < n and k != num_chs:
                v = ord(S[r])
                buckets[v] -= 1
                if buckets[v] == 0:
                    k += 1
                r += 1
            if k != num_chs:
                break
            while l < n and k == num_chs:
                v = ord(S[l])
                if buckets[v] == 0:
                    k -= 1
                buckets[v] += 1
                l += 1
            if r - l < min_range[1] - min_range[0]:
                min_range = [l - 1, r]
        if min_range == [0, n + 1]:
            return ''
        return S[min_range[0]:min_range[1]]

def main():
    solver = Solution()
    print(solver.minWindow('ADOBECODEBANC', 'ABC'))

if __name__ == '__main__':
    main()
