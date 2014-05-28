import java.util.ArrayList;

public class NQueens {
    private String[] token;
    private ArrayList<String[]> res;

    private String generateRow(int n, int col) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            strBuilder.append('.');
        }
        strBuilder.setCharAt(col, 'Q');
        return strBuilder.toString();
    }

    private int bitIndex(int x) {
        if (x == 0) {
            return -1;
        }
        int index = 0;
        while (x % 2 == 0) {
            ++index;
            x /= 2;
        }
        return index;
    }

    private void searchQueens(int n, int row, 
            int fullState, int colState, int diagonalState, int backState) {
        if (colState == fullState) {
            String[] temp = new String[n];
            for (int i = 0; i < n; ++i) {
                temp[i] = new String(token[i]);
            }
            res.add(temp);
            return;
        }
        int current = fullState & ~(colState | diagonalState | backState);
        while (current != 0) {
            int colBin = current & -current;
            int col = bitIndex(colBin);
            token[row] = generateRow(n, col);
            searchQueens(n, row + 1, fullState, 
                    colState | colBin, (diagonalState | colBin) << 1, (backState | colBin) >> 1);
            current &= ~colBin;
        }
    }

    public ArrayList<String[]> solveNQueens(int n) {
        token = new String[n];
        res = new ArrayList<String[]>();
        searchQueens(n, 0, (1 << n) - 1, 0, 0, 0);
        return res;
    }

    public void display(ArrayList<String[]> res) {
        for (String[] token : res) {
            int n = token.length;
            for (int i = 0; i < n; ++i) {
                System.out.println(token[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();
        solver.display(solver.solveNQueens(4));
    }
}
