#include "base_include.h"

class LetterCombinationsOfAPhoneNumber {
public:
    vector<string> letterCombinations(const string &digits) {
        int n = digits.size();
        vector<string> res;
        if (0 == n) {
            res.push_back("");
            return res;
        }
        int d = digits[0] - '0';
        int m = strs[d].size();
        vector<string> sub = letterCombinations(digits.substr(1));
        for (int i = 0; i < m; ++i) {
            for (auto &s : sub) {
                res.push_back(strs[d][i] + s);
            }
        }
        return res;
    }
private:
    string strs[10]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
};

int main(int argc, char *argv[]) {
    return 0;
}
