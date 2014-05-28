public class NQueensII {
    private int searchQueens(int fullState, int colState, int diagonalState, int backState) {
        if (colState == fullState) {
            return 1;
        }
        int res = 0;
        int current = fullState & ~(colState | diagonalState | backState);
        while (current != 0) {
            int col = current & -current;
            res += searchQueens(fullState, colState | col, (diagonalState | col) << 1, (backState | col) >> 1);
            current &= ~col;
        }
        return res;
    }

    public int totalNQueens(int n) {
        return searchQueens((1 << n) - 1, 0, 0, 0);
    }

    public static void main(String[] args) {
        NQueensII solver = new NQueensII();
        System.out.println(solver.totalNQueens(4));
    }
}
