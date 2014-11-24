#include "base_include.h"

class WildcardMatching {
public:
    bool isMatch(const char *s, const char *p) {
        if (nullptr == s || nullptr == p) {
            return false;
        }
        int len_s = strlen(s);
        int len_p = strlen(p);
        int non_star_in_p = 0;
        for (int j = 0; j < len_p; ++j) {
            if (p[j] != '*') {
                ++non_star_in_p;
            }
        }
        if (non_star_in_p > len_s) {
            return false;
        }

        bool matched[2][len_p + 1];     //loop array, memory compression
        memset(matched, false, sizeof(matched));
        matched[0][len_p] = true;

        for (int j = len_p - 1; j >= 0 && '*' == p[j]; --j) {   //match the trailing '*' in p
            matched[0][j] = true;
        }

        for (int i = len_s - 1; i >= 0; --i) {
            memcpy(&matched[1][0], &matched[0][0], sizeof(matched[0])); //swap matched array
            memset(&matched[0][0], false, sizeof(matched[0]));
            for (int j = len_p - 1; j >= 0; --j) {
                if ('*' == p[j]) {
                    matched[0][j] = matched[1][j] || matched[0][j + 1]; //use one char in s to match '*' or skip '*'
                } else if (s[i] == p[j] || '?' == p[j]) {
                    matched[0][j] = matched[1][j + 1];  //must match one
                }
            }
        }
        return matched[0][0];
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
