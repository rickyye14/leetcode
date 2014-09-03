#!/usr/bin/env python3

class Solution:
    def combinationSum2(self, candidates, target):
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
            res = res + self.helper(candidates, i + 1, target - candidates[i], comb)
            comb.pop()
        return res

def main():
    solver = Solution()
    candidates = [10, 1, 2, 7, 6, 1, 5]
    for comb in solver.combinationSum2(candidates, 8):
        print(str(comb));

if __name__ == '__main__':
    main()
