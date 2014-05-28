public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        int n = board.length;
        if (n != 9) {
            return false;
        }

        int m = board[0].length;
        if (m != 9) {
            return false;
        }
        for (int i = 1; i < n; ++i) {
            if (board[i].length != m) {
                return false;
            }
        }

        boolean[] marked = new boolean[4 * 81];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                int k = board[i][j] - '1';
                if (k < 0 || k > 8) {
                    return false;
                }
                int h = 0;
                h = 0 * 81 + i * 9 + j;
                if (marked[h]) {
                    return false;
                }
                marked[h] = true;

                h = 1 * 81 + i * 9 + k;
                if (marked[h]) {
                    return false;
                }
                marked[h] = true;

                h = 2 * 81 + j * 9 + k;
                if (marked[h]) {
                    return false;
                }
                marked[h] = true;

                h = 3 * 81 + ((i / 3) * 3 + j / 3) * 9 + k;
                if (marked[h]) {
                    return false;
                }
                marked[h] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();
        char[][] board = new char[9][9];
    }
}
