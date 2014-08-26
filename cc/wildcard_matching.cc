#include "base_include.h"

class WildcardMatching {
public:
    bool isMatch(const char *s, const char *p) {
        if (nullptr == s || nullptr == p) {
            return false;
        }
        const char *ss = nullptr;
        const char *pp = nullptr;
        while (*s != '\0') {
            if (*s == *p || '?' == *p) {
                ++s;
                ++p;
            } else if ('*' == *p) {
                pp = p++;
                ss = s;
            } else {
                if (nullptr == pp) {
                    return false;
                }
                s = ss + 1;
                p = pp;
            }
        }
        while ('*' == *p) {
            ++p;
        }
        return ('\0' == *p);
    }
};

int main(int argc, char *argv[]) {
    const int MAXN = 10002;
    WildcardMatching solver;
    char s[MAXN];
    char p[MAXN];
    while (cin >> s >> p) {
        cout << solver.isMatch(s, p) << endl;
    }
    return 0;
}
