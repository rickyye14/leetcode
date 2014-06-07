public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null) {
            return;
        }
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        if (m == 0) {
            return;
        }
        int[] set = new int[n * m];
        for (int i = 0; i < n * m; ++i) {
            set[i] = i;
        }
        boolean[] marked = new boolean[n * m];
        for (int i = 1; i < n; ++i) {
            if (board[i][0] == 'O' && board[i - 1][0] == 'O') {
                union(set, getIndex(m, i, 0), getIndex(m, i - 1, 0));
            }
        }
        for (int j = 1; j < m; ++j) {
            if (board[0][j] == 'O' && board[0][j - 1] == 'O') {
                union(set, getIndex(m, 0, j), getIndex(m, 0, j - 1));
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (board[i][j] != 'O') {
                    continue;
                }
                if (board[i - 1][j] == 'O') {
                    union(set, getIndex(m, i, j), getIndex(m, i - 1, j));
                }
                if (board[i][j - 1] == 'O') {
                    union(set, getIndex(m, i, j), getIndex(m, i, j - 1));
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (board[i][0] == 'O') {
                marked[find(set, getIndex(m, i, 0))] = true;
            }
            if (board[i][m - 1] == 'O') {
                marked[find(set, getIndex(m, i, m - 1))] = true;
            }
        }
        for (int j = 0; j < m; ++j) {
            if (board[0][j] == 'O') {
                marked[find(set, getIndex(m, 0, j))] = true;
            }
            if (board[n - 1][j] == 'O') {
                marked[find(set, getIndex(m, n - 1, j))] = true;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (!marked[find(set, getIndex(m, i, j))]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int getIndex(int m, int i, int j) {
        return i * m + j;
    }

    private int find(int[] set, int x) {
        int t = x;
        while (x != set[x]) {
            x = set[x];
        }
        while (t != x) {
            int s = set[t];
            set[t] = x;
            t = s;
        }
        return x;
    }

    private void union(int[] set, int x, int y) {
        int rx = find(set, x);
        int ry = find(set, y);
        if (rx < ry) {
            set[ry] = rx;
        } else {
            set[rx] = ry;
        }
    }
}
