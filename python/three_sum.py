#!/usr/bin/env python3

class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        res = list()
        if num is None:
            return res
        num = sorted(num)
        n = len(num)
        for i in range(n - 2):
            if i != 0 and num[i] == num[i - 1]:
                continue
            l, r = i + 1, n - 1
            while l < r:
                if num[l] + num[r] <= -num[i]:
                    if num[l] + num[r] == -num[i]:
                        res.append([num[i], num[l], num[r]])
                        tmp = num[l]
                        while l < r and num[l] == tmp:
                            l += 1
                    else:
                        l += 1
                else:
                    r -= 1
        return res

def main():
    solver = Solution()
    num = [-1, 0, 1, 2, -1, -4]
    print(solver.threeSum(num))

if __name__ == '__main__':
    main()
