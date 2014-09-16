#!/usr/bin/env python3

class Solution:
    def multiply(self, num1, num2):
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
    main()
