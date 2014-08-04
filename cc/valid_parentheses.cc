#include "base_include.h"

class ValidParentheses {
public:
    bool isValid(string s) {
        int n = s.size();
        if (0 == n) {
            return true;
        }
        char *ch_stack = new char[n];
        int top = 0;
        for (int i = 0; i < n; ++i) {
            //be careful to handle the stack
            if (top != 0 && ('(' == ch_stack[top - 1] && ')' == s[i] 
                        || '{' == ch_stack[top - 1] && '}' == s[i] 
                        || '[' == ch_stack[top - 1] && ']' == s[i])) {
                --top;
            } else {
                ch_stack[top++] = s[i];
            }
        }
        delete[] ch_stack;
        return (0 == top);
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
