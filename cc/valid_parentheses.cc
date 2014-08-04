#include "base_include.h"

class ValidParentheses {
public:
    bool isValid(string s) {
        int n = s.size();
        if (0 == n) {
            return true;
        }
        char *ch_stock = new char[n];
        int top = 0;
        for (int i = 0; i < n; ++i) {
            if (0 == top || '(' == s[i] || '{' == s[i] || '[' == s[i]) {
                ch_stock[top++] = s[i];
            } else {
                if ('(' == s[i - 1] && ')' == s[i] 
                        || '{' == s[i - 1] && '}' == s[i] 
                        || '[' == s[i - 1] && ']' == s[i]) {
                    --top;
                }
            }
        }
        delete[] ch_stock;
        return (0 == top);
    }
};
