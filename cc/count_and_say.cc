#include "base_include.h"

class CountAndSay {
public:
    string countAndSay(int n) {
        string res = "1";
        for (int i = 1; i < n; ++i) {
            res = next_word(res);
        }
        return res;
    }

private:
    string itos(int n) {
        if (0 == n) {
            return "0";
        }
        string res;
        while (n) {
            res.append(1, (char) ('0' + n % 10));
            n /= 10;
        }
        reverse(res.begin(), res.end());
        return res;
    }

    string next_word(string s) {
        string res;
        for (int i = 0, j = 0; s[i] != '\0'; ++i) {
            for (j = i; s[j] != '\0' && s[j] == s[i]; ++j) {}
            res += itos(j - i);
            res.append(1, s[i]);
            i = j - 1;
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    CountAndSay solver;
    cout << solver.countAndSay(3) << endl;
    cout << solver.countAndSay(4) << endl;
    cout << solver.countAndSay(5) << endl;
    return 0;
}
