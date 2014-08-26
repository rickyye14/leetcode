#!/usr/bin/env python3

import collections

class Solution:
    # @param board, a 2D array
    # Capture all regions by modifying the input board in-place.
    # Do not return any value.
    def solve(self, board):
        if board is None:
            return
        rows = len(board)
        if rows == 0:
            return
        cols = len(board[0])
        if cols == 0:
            return
        queue = collections.deque()
        empty_coord = lambda x, y: board[x][y] == 'O'
        valid_coord = lambda x, y: 0 <= x and x < rows and 0 <= y and y < cols
        for i in range(rows):
            if empty_coord(i, 0):
                queue.append([i, 0])
            if empty_coord(i, cols - 1):
                queue.append([i, cols - 1])
        for j in range(cols):
            if empty_coord(0, j):
                queue.append([0, j])
            if empty_coord(rows - 1, j):
                queue.append([rows - 1, j])
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        while queue:
            [cx, cy] = queue.popleft()
            board[cx][cy] = '$'
            for k in range(4):
                [px, py] = [cx + dirs[k][0], cy + dirs[k][1]]
                if not valid_coord(px, py):
                    continue
                if empty_coord(px, py):
                    queue.append([px, py])
        for i in range(rows):
            for j in range(cols):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == '$':
                    board[i][j] = 'O'

def main():
    solver = Solution()
    board = [['X', 'X', 'O'], ['X', 'O', 'X'], ['X', 'X', 'X']]
    solver.solve(board)
    print(board)

if __name__ == '__main__':
    main()
