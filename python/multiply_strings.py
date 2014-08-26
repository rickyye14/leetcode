#!/usr/bin/env python3

class Solution:
    def multiply(self, num1, num2):
        s = '0'
        return s

    def multiplyByOneDigt(self, num, d):
        res = ''
        n = len(num)
        c = 0
        for i in reversed(range(n)):
            p = int(num[i]) * d + c
            c = p // 10
            res += str(p % 10)
        if c != 0:
            res += str(c)
        return res[::-1]

    def add(self, num1, num2):
        res = ''
        n = len(num1)
        m = len(num2)
        i = n - 1
        j = m - 1
        c = 0
        while 0 <= i and 0 <= j:
            s = int(num1[i]) + int(num2[j]) + c
            c = s // 10
            res += str(s % 10)
            i -= 1
            j -= 1
        while 0 <= i:
            s = int(num1[i]) + c
            c = s // 10
            res += str(s % 10)
            i -= 1
        while 0 <= j:
            s = int(num2[j]) + c
            c = s // 10
            res += str(s % 10)
            j -= 1
        if c != 0:
            res += str(c)
        return res[::-1]

def main():
    solver = Solution()
    print(solver.multiplyByOneDigt('99', 9))
    print(solver.add('45', '86'))

if __name__ == "__main__":
    main()
