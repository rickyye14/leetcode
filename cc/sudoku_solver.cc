#include "base_include.h"

class SudokuSolver {
public:
    SudokuSolver() {
        rmark = vector<vector<bool> >(9, vector<bool>(9, false));
        cmark = vector<vector<bool> >(9, vector<bool>(9, false));
        bmark = vector<vector<bool> >(9, vector<bool>(9, false));
    }

    void solveSudoku(vector<vector<char> > &board) {
        int num_filled = 0;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if ('.' == board[i][j]) {
                    continue;
                }
                int v = board[i][j] - '1';
                rmark[i][v] = true;
                cmark[j][v] = true;
                bmark[(i / 3) * 3 + (j / 3)][v] = true;
                ++num_filled;
            }
        }
        searchSudoku(board, num_filled);
    }

    bool searchSudoku(vector<vector<char> > &board, int num_filled) {
        if (81 == num_filled) {
            return true;
        }
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if ('.' == board[i][j]) {
                    for (int k = 0; k < 9; ++k) {
                        int b = (i / 3) * 3 + (j / 3);
                        if (rmark[i][k] || cmark[j][k] || bmark[b][k]) {
                            continue;
                        }
                        rmark[i][k] = true;
                        cmark[j][k] = true;
                        bmark[b][k] = true;
                        board[i][j] = (char) ('1' + k);
                        if (searchSudoku(board, num_filled + 1)) {
                            return true;
                        }
                        rmark[i][k] = false;
                        cmark[j][k] = false;
                        bmark[b][k] = false;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return false;
    }

private:
    vector<vector<bool> > rmark;
    vector<vector<bool> > cmark;
    vector<vector<bool> > bmark;
};

int main(int argc, char *argv[]) {
    return 0;
}
