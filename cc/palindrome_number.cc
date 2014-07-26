#include "base_include.h"

class PalindromeNumber {
public:
    bool isPalindrome(const int &x) {
        if (x < 0) {
            return false;
        }
        int res = 0;
        int t = x;
        while (t != 0) {
            res = res * 10 + t % 10;
            t /= 10;
        }
        return (res == x);
    }
};

int main(int argc, char *argv[]) {
    PalindromeNumber solver;
    cout << solver.isPalindrome(1) << endl;
    return 0;
}
