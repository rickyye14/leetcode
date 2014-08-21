#include "base_include.h"

class LongestValidParentheses {
public:
    int longestValidParentheses(string s) {
        int n = s.size();
        if (0 == n) {
            return 0;
        }
        int result = 0;
        stack<int> S;
        vector<int> dp(n + 1, 0);
        if ('(' == s[0]) {
            S.push(1);
        }
        for (int i = 1; i < n; ++i) {
            if ('(' == s[i]) {
                S.push(i + 1);
            } else {
                if (!S.empty()) {
                    int len = i - S.top() + 2;
                    dp[i + 1] = dp[S.top() - 1] + len;
                    S.pop();
                }
            }
        }
        for (int i = 0; i <= n; ++i) {
            result = max(result, dp[i]);
        }
        return result;
    }
};

int main(int argc, char *argv[]) {
    LongestValidParentheses solver;
    string s;

    s = "()(())";
    cout << solver.longestValidParentheses(s) << endl;
    return 0;
}
