#include "base_include.h"

class LongestCommonPrefix {
public:
    string longestCommonPrefix(vector<string> &strs) {
        int n = strs.size();
        if (n == 0) {
            return "";
        }
        int ind = 0;
        bool flag = true;
        for ( ; flag; ++ind) {
            char ch = strs[0][ind];
            for (auto &s : strs) {
                if ('\0' == s[ind] || s[ind] != ch) {
                    flag = false;
                    break;
                }
            }
        }
        return strs[0].substr(0, ind - 1);
    }
};
