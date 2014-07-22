#include <iostream>
#include <string>
using namespace std;

class LongestPalindromicSubstring {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        if (0 == n) {
            return "";
        }
        int max_left = 0;
        int max_right = 0;
        int max_len = 0;
        for (int i = 0; i < n; ++i) {
            int left = i;
            int right = i;
            for ( ; 0 <= left && right < n - 1 && s[left] == s[right]; --left, ++right) {
                ;
            }
            ++left;
            --right;
            if (right - left + 1 > max_len) {
                max_len = right - left + 1;
                max_left = left;
                max_right = right;
            }
            left = i;
            right = i + 1;
            if (right < n && s[left] == s[right]) {
                for ( ; 0 <= left && right < n - 1 && s[left] == s[right]; --left, ++right) {
                    ;
                }
                ++left;
                --right;
                if (right - left + 1 > max_len) {
                    max_len = right - left + 1;
                    max_left = left;
                    max_right = right;
                }
                left = i;
                right = i + 1;
            }
        }
        //string substr (size_t pos = 0, size_t len = npos) const;
        return s.substr(max_left, max_right - max_left + 1);
    }
};

int main(int argc, char *argv[]) {
    LongestPalindromicSubstring solver;
    string s = "abcbe";
    cout << solver.longestPalindrome(s) << endl;
    return 0;
}
