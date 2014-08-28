#/usr/bin/env python3

class Solution:
    # @param board, a list of lists of 1 length string
    # @param word, a string
    # @return a boolean
    def exist(self, board, word):
        if board is None or word is None:
            return False
        n = len(board)
        if n == 0:
            return False
        m = len(board[0])
        if m == 0:
            return False
        if len(word) == 0:
            return True
        for i in range(n):
            for j in range(m):
                if board[i][j] == word[0]:
                    board[i][j] = '#'
                    if self.search(board, word, i, j, 1):
                        return True
                    board[i][j] = word[0]
        return False

    def search(self, board, word, cx, cy, p):
        if p == len(word):
            return True
        n = len(board)
        m = len(board[0])
        dirs = ( (-1, 0), (0, -1), (1, 0), (0, 1) )
        for k in range(4):
            nx, ny = cx + dirs[k][0], cy + dirs[k][1]
            if 0 <= nx and nx < n and 0 <= ny and ny < m and board[nx][ny] == word[p]:
                board[nx][ny] = '#'
                if self.search(board, word, nx, ny, p + 1):
                    return True
                board[nx][ny] = word[p]
        return False

def main():
    solver = Solution()

if __name__ == '__main__':
    main()
