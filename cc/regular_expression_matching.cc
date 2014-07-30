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
    const int MAX_LEN = 1000;
    RegularExpressionMathching solver;
    char s[MAX_LEN];
    char p[MAX_LEN];
    strcpy(s, "aa");
    strcpy(p, "a");
    cout << solver.isMatch(s, p) << endl;

    strcpy(s, "aa");
    strcpy(p, "aa");
    cout << solver.isMatch(s, p) << endl;

    strcpy(s, "aa");
    strcpy(p, "aaa");
    cout << solver.isMatch(s, p) << endl;

    strcpy(s, "aa");
    strcpy(p, "a*");
    cout << solver.isMatch(s, p) << endl;

    strcpy(s, "aa");
    strcpy(p, ".*");
    cout << solver.isMatch(s, p) << endl;

    strcpy(s, "aab");
    strcpy(p, "c*a*b*");
    cout << solver.isMatch(s, p) << endl;

    strcpy(s, "bbbba");
    strcpy(p, ".*a*a");
    cout << solver.isMatch(s, p) << endl;
    return 0;
}
