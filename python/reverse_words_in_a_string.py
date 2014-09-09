#!/usr/bin/env python3

class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        words = list()
        n = len(s)
        left, right = n - 1, n - 1
        tokens = list()
        while right >= 0:
            while right >= 0 and s[right] == ' ':
                right -= 1
            if right < 0:
                break
            left = right
            while left >= 0 and s[left] != ' ':
                left -= 1
            tokens.append(s[left+1:right+1])
            right = left
        return ' '.join(tokens)

def main():
    solver = Solution()
    print(solver.reverseWords("the sky is blue"))
    print(solver.reverseWords("the sky  is    blue"))

if __name__ == '__main__':
    main()
