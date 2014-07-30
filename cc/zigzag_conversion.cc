#include "base_include.h"

class ZigZagCoversion {
private:
    struct CharPosition {
        char ch;
        int x;
        int y;

        CharPosition() {}

        CharPosition(int ch, int x, int y):
            ch(ch), x(x), y(y) {}
    };

public:
    string convert(string s, int nRows) {
        int n = s.size();
        if (0 == n) {
            return s;
        }
        if (1 == nRows) {
            return s;
        }
        CharPosition cp[n];
        for (int index = 0, x = 0, y = 0; index < n; ) {
            for (int i = 0 ; index < n && i < nRows - 1; ++i, ++index) {
                cp[index] = CharPosition(s[index], x, y);
                ++x;
            }
            if (index == n) {
                break;
            }
            for (int i = 0; index < n && i < nRows - 1; ++i, ++index) {
                cp[index] = CharPosition(s[index], x, y);
                --x;
                ++y;
            }
        }
        sort(cp, cp + n, [](const CharPosition &cp1, const CharPosition &cp2){ return cp1.x != cp2.x ? cp1.x < cp2.x : cp1.y < cp2.y; });
        string res;
        for (int i = 0; i < n; ++i) {
            res += cp[i].ch;
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
