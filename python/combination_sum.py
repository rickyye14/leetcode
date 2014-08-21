#!/usr/bin/env python3

class Solution:
    def combinationSum(self, candidates, target):
        candidates.sort()
        return self.helper(candidates, 0, target)

    def helper(self, candidates, index, target, comb=[]):
        res = []
        if target == 0:
            res.append(list(comb))
            return res
        n = len(candidates)
        for i in range(index, n):
            if candidates[i] > target:
                break
            if i != index and candidates[i - 1] == candidates[i]:
                continue
            comb.append(candidates[i])
            res = res + self.helper(candidates, i, target - candidates[i], comb)
            comb.pop()
        return res

def main():
    solver = Solution()
    candidates = [2, 3, 6, 7]
    for comb in solver.combinationSum(candidates, 7):
        print(str(comb));

if __name__ == '__main__':
    main()
