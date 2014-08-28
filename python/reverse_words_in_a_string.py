#!/usr/bin/env python3

class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        if s is None:
            return None
        s = s.strip()
        n = len(s)
        ls = list(s[::-1])
        i = 0
        while i < n:
            while i < n and ls[i] == ' ':
                i += 1
            if i == n:
                break
            j = i
            while j < n and ls[j] != ' ':
                j += 1
            ls[i:j] = ls[i:j][::-1]
            i = j
        return ''.join(ls)

def main():
    solver = Solution()
    print(solver.reverseWords("the sky is blue"))

if __name__ == '__main__':
    main()
