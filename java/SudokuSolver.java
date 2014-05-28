public class SudokuSolver {
    private boolean[] marked = new boolean[81 * 4];

    private void display(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                System.out.printf("%4c", board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean search(char[][] board, int count) {
        System.out.println("count = " + count);
        if (count == 81) {
            return true;
        }
        for (int x = 0; x < 9; ++x) {
            for (int y = 0; y < 9; ++y) {
                if (board[x][y] != '.') {
                    continue;
                }
                for (int n = 0; n < 9; ++n) {
                    if (mark(x, y, n)) {
                        board[x][y] = (char) (n + '1');
                        if (search(board, count + 1)) {
                            return true;
                        }
                        unmark(x, y, n);
                    }
                    board[x][y] = '.';
                }
            }
        }
        return false;
    }

    private boolean mark(int x, int y, int n) {
        int[] h = new int[4];
        h[0] = 81 * 0 + x * 9 + y;
        h[1] = 81 * 1 + x * 9 + n;
        h[2] = 81 * 2 + y * 9 + n;
        h[3] = 81 * 3 + (x / 3 * 3 + y / 3) * 9 + n;
        if (!marked[h[0]] && !marked[h[1]] && !marked[h[2]] && !marked[h[3]]) {
            for (int i = 0; i < 4; ++i) {
                marked[h[i]] = true;
            }
            return true;
        }
        return false;
    }

    private void unmark(int x, int y, int n) {
        int[] h = new int[4];
        h[0] = 81 * 0 + x * 9 + y;
        h[1] = 81 * 1 + x * 9 + n;
        h[2] = 81 * 2 + y * 9 + n;
        h[3] = 81 * 3 + (x / 3 * 3 + y / 3) * 9 + n;
        for (int i = 0; i < 4; ++i) {
            marked[h[i]] = false;
        }
    }

    public void solveSudoku(char[][] board) {
        if (board == null) {
            return;
        }
        int count = 0;
        for (int x = 0; x < 9; ++x) {
            for (int y = 0; y < 9; ++y) {
                int n = board[x][y] - '1';
                if (0 <= n && n < 9) {
                    ++count;
                    if (!mark(x, y, n)) {
                        return;
                    }
                }
            }
        }
        System.out.println("0");
        search(board, count);
    }

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
        char[][] board = new char[9][9];
        board[0] = "..9748...".toCharArray();
        board[1] = "7........".toCharArray();
        board[2] = ".2.1.9...".toCharArray();
        board[3] = "..7...24.".toCharArray();
        board[4] = ".64.1.59.".toCharArray();
        board[5] = ".98...3..".toCharArray();
        board[6] = "...8.3.2.".toCharArray();
        board[7] = "........6".toCharArray();
        board[8] = "...2759..".toCharArray();
        solver.solveSudoku(board);
        solver.display(board);
    }
}
