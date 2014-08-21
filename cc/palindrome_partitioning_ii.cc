#include "base_include.h"

class PalindromePartitioningII {
public:
    int minCut(string s) {
        int n = s.size();
        vector<int> dp(n + 1, n);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; --i) {
            int l = i, r = i;
            for ( ; 0 <= l && r < n && s[l] == s[r]; --l, ++r) {
                dp[l] = min(dp[l], dp[r + 1] + 1);
            }
            l = i - 1, r = i;
            for ( ; 0 <= l && r < n && s[l] == s[r]; --l, ++r) {
                dp[l] = min(dp[l], dp[r + 1] + 1);
            }
        }
        return dp[0] - 1;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
