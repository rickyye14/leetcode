#!/usr/bin/env python3

class Solution:
    # @param x, a float
    # @param n, a integer
    # @return a float
    def pow(self, x, n):
        sign = True
        if n < 0:
            sign = False
            n = -n
        if n == 0:
            return 1
        if n == 1:
            return x if sign else 1 / x
        p = 1
        t = x
        while n != 0:
            if n % 2 != 0:
                p *= t
            t *= t
            n >>= 1
        return p if sign else 1 / p

def main():

if __name__ == '__main__':
    main()
