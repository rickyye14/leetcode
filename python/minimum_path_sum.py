#!/usr/bin/env python3

class Solution:
    # @param grid, a list of lists of integers
    # @return an integer
    def minPathSum(self, grid):
        if grid is None:
            return 0
        n = len(grid)
        if n == 0:
            return 0
        m = len(grid[0])
        if m == 0:
            return 0
        for i in range(1, n):
            grid[i][0] += grid[i - 1][0]
        for j in range(1, m):
            grid[0][j] += grid[0][j - 1]
        for i in range(1, n):
            for j in range(1, m):
                grid[i][j] += min(grid[i - 1][j], grid[i][j - 1])
        return grid[n - 1][m - 1]

def main():
    solver = Solution()
    grid = [ [1, 2, 1], [3, 2, 1], [4, 2, 3] ]

if __name__ == '__main__':
    main()
