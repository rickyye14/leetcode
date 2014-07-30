#include "base_include.h"

class LongestConsecutiveSequence {
public:
    int longestConsecutive(vector<int> &num) {
        unordered_map<int, int> hash;
        int leftmost = 0;
        int rightmost = 0;
        int max_len = 0;
        int len = 0;
        for (auto &v : num) {
            if (hash[v] != 0) {
                continue;
            }
            hash[v] = 1;
            leftmost = hash[v - 1];
            rightmost = hash[v + 1];
            len = 1 + leftmost + rightmost;
            if (max_len < len) {
                max_len = len;
            }
            hash[v - leftmost] = len;
            hash[v + rightmost] = len;
        }
        return max_len;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
