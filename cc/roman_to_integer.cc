#include "base_include.h"

class RomanToInteger {
public:
    int romanToInt(string s) {
        int hash[128];
        hash['M'] = 1000;
        hash['D'] = 500;
        hash['C'] = 100;
        hash['L'] = 50;
        hash['X'] = 10;
        hash['V'] = 5;
        hash['I'] = 1;
        int num = 0;
        int n = s.size();
        for (int i = 0; i < n - 1; ++i) {
            if (hash[(int) s[i]] < hash[(int) s[i + 1]]) {
                num -= hash[(int) s[i]];
            } else {
                num += hash[(int) s[i]];
            }
        }
        num += hash[(int) s[n - 1]];
        return num;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
