#!/usr/bin/env python3

class Solution:
    def multiply(self, num1, num2):
<<<<<<< HEAD
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
=======
        res = ''
        if num1 == '0' or num2 == '0':
            return '0'
        if num1 == '1':
            return num2
        if num2 == '1':
            return num1
        num1 = num1[::-1]
        num2 = num2[::-1]
        n = len(num1)
        m = len(num2)
        arr = [0] * (n + m)
        for i in range(n):
            for j in range(m):
                arr[i + j] += int(num1[i]) * int(num2[j])
        c = 0
        for i in range(n + m):
            s = arr[i] + c
            c = s // 10
            res += str(s % 10)
        if c != 0:
            res += str(c)
        return res[::-1].lstrip('0')

def main():
    solver = Solution()
    print(solver.multiply('56', '12'))
    print(solver.multiply('9369162965141127216164882458728854782080715827760307787224298083754', '7204554941577564438'))

if __name__ == '__main__':
>>>>>>> 2bc44c3983579a698d0ef4332505d32020159440
    main()
