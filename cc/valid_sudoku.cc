#include "base_include.h"

class ValidSudoku {
public:
    bool isValidSudoku(vector<vector<char> > &board) {
        if (board.size() != 9 || board[0].size() != 9) {
            return false;
        }
        vector<vector<bool> > rmark(9, vector<bool>(9, false));
        vector<vector<bool> > cmark(9, vector<bool>(9, false));
        vector<vector<bool> > bmark(9, vector<bool>(9, false));
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if ('.' == board[i][j]) {
                    continue;
                }
                int v = board[i][j] - '1';
                if (rmark[i][v] || cmark[j][v] || bmark[(i / 3) * 3 + (j / 3)][v]) {
                    return false;
                }
                rmark[i][v] = cmark[j][v] = bmark[(i / 3) * 3 + (j / 3)][v] = true;
            }
        }
        return true;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
