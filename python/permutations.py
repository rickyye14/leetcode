#!/usr/bin/env python3

class Solution:
    def permute(self, num):
        res = []
        n = len(num)
        perm = list(num)
        while True:
            print(perm)
            for i in reversed(range(1, n)):
                if perm[i - 1] < perm[i]:
                    for j in reversed(range(i, n)):
                        if perm[j] > perm[i - 1]:
                            break
                    perm[i - 1], perm[j] = perm[j], perm[i - 1]
                    break
            j = n - 1
            while i < j:
                perm[i], perm[j] = perm[j], perm[i]
                i += 1
                j -= 1
            res.append(list(perm))
            if perm == num:
                break
        return res

def main():
    solver = Solution()
    print(solver.permute([1, 2, 3]))

if __name__ == '__main__':
    main()
