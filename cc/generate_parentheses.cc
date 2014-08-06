#include "base_include.h"

class GenerateParentheses {
public:
    vector<string> generateParenthesis(int n) {
        if (0 == n) {
            return vector<string>();
        }
        string s;
        return generateParenthesis(n, s, 0, 0);
    }

private:
    vector<string> generateParenthesis(int n, string &s, int left_num, int right_num) {
        if (s.size() == 2 * n) {
            return vector<string>{s};
        }
        vector<string> res;
        vector<string> token;
        if (left_num < n) {
            s += "(";
            token = generateParenthesis(n, s, left_num + 1, right_num);
            res.insert(res.end(), token.begin(), token.end());
            s.erase(s.end() - 1);
        }
        if (right_num < left_num) {
            s += ")";
            token = generateParenthesis(n, s, left_num, right_num + 1);
            res.insert(res.end(), token.begin(), token.end());
            s.erase(s.end() - 1);
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
