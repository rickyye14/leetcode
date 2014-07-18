#include <string>
#include <iostream>
using std::string;
using std::max;
using std::cout;
using std::endl;

class LongestSubstringWithoutRepeatingCharacters {
public:
    int lengthOfLongestSubstring(string s) {        
        if (s.size() == 0) {
            return 0;
        }
        int n = s.size();

        bool flag[256];
        for (int i = 0; i < 256; ++i) {
            flag[i] = false;
        }

        int max_len = 0;
        for (int i = 0, j = 0; i < n; ++i) {    //be very careful to handle the movement of i and j
            int c = (int)s[i];
            if (flag[c]) {
                for ( ; j < i; ++j) {
                    if (s[j] == s[i]) {
                        ++j;
                        break;
                    } else {
                        flag[(int)s[j]] = false;
                    }
                }
            } else {
                flag[c] = true;
                max_len = max(max_len, i - j + 1);
            }
        }
        return max_len;
    }
};

int main(int argc, char *argv[]) {
    LongestSubstringWithoutRepeatingCharacters solver;
    string s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
    cout << solver.lengthOfLongestSubstring(s) << endl;
    return 0;
}
