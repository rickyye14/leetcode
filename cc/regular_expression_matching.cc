#include "base_include.h"

class RegularExpressionMathching {
public:
    bool isMatch(const char *s, const char *p) {
        assert(s != NULL && p != NULL);
        if ('\0' == *s && '\0' == *p) {
            return true;
        }
        if ('\0' == *s) {
            return '*' == *(p + 1) && isMatch(s, p + 2);
        }
        if ('\0' == *p) {
            return false;
        }
        if ('*' == *(p + 1)) {
            if (*s == *p || '.' == *p) {
                return isMatch(s, p + 2) || isMatch(s + 1, p);
            } else {
                return isMatch(s, p + 2);
            }
        } else {
            return (*s == *p || '.' == *p) && isMatch(s + 1, p + 1);
        }
        return false;
    }
};

int main(int argc, char *argv[]) {
    RegularExpressionMathching solver;
    char *s = NULL;
    char *p = NULL;
    s = "aa";
    p = "a";
    cout << solver.isMatch(s, p) << endl;

    s = "aa";
    p = "aa";
    cout << solver.isMatch(s, p) << endl;

    s = "aa";
    p = "aaa";
    cout << solver.isMatch(s, p) << endl;

    s = "aa";
    p = "a*";
    cout << solver.isMatch(s, p) << endl;

    s = "aa";
    p = ".*";
    cout << solver.isMatch(s, p) << endl;

    s = "ab";
    p = ".*";
    cout << solver.isMatch(s, p) << endl;

    s = "aab";
    p = "c*a*b*";
    cout << solver.isMatch(s, p) << endl;

    s = "bbbba";
    p = ".*a*a";
    return 0;
}
