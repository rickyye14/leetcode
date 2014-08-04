#include "base_include.h"

class ThreeSumClosest {
public:
    int threeSumClosest(vector<int> &num, int target) {
        int n = num.size();
        assert(n >= 3);

        sort(num.begin(), num.end());
        int min_dist = numeric_limits<int>::max();
        int res = 0;
        for (int i = 0; i < n - 2 && min_dist != 0; ++i) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                int dist = abs(sum - target);
                if (min_dist > dist) {
                    min_dist = dist;
                    res = sum;
                }
                if (num[left] + num[right] < target - num[i]) {
                    ++left;
                } else if (num[left] + num[right] > target - num[i]) {
                    --right;
                } else {
                    break;
                }
            }
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
