public class WordSearch {
    private class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean[][] marked;
    private int[][] dirs = new int[][] {
        {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        int n = board.length;
        if (n == 0) {
            return false;
        }
        int m = board[0].length;
        int len = word.length();
        if (n * m < len) {
            return false;
        }
        if (len == 0) {
            return true;
        }
        marked = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    marked[i][j] = true;
                    if (search(board, new Position(i, j), word, 1)) {
                        return true;
                    }
                    marked[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, Position current, String word, int ptr) {
        int len = word.length();
        if (ptr == len) {
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        for (int k = 0; k < 4; ++k) {
            Position next = new Position(current.x + dirs[k][0], 
                    current.y + dirs[k][1]);
            if (next.x < 0 || next.x >= n 
                    || next.y < 0 || next.y >= m) {
                continue;
            }
            if (board[next.x][next.y] == word.charAt(ptr) 
                    && !marked[next.x][next.y]) {
                marked[next.x][next.y] = true;
                if (search(board, next, word, ptr + 1)) {
                    return true;
                }
                marked[next.x][next.y] = false;
            }
        }
        return false;
    }
}
