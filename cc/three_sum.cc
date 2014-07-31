#include "base_include.h"

class ThreeSum {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        vector<vector<int> > res;
        int n = num.size();
        if (0 == n) {
            return res;
        }
        sort(num.begin(), num.end());
        for (int i = 0; i < n - 2; ++i) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            pair<int, int> prev(numeric_limits<int>::min(), numeric_limits<int>::min());
            int left = i + 1;
            int right = n - 1;
            int sum = 0;
            while (left < right) {
                sum = num[left] + num[right];
                if (sum < -num[i]) {
                    ++left;
                } else if (sum > -num[i]) {
                    --right;
                } else {
                    if (num[left] != prev.first) {
                        res.push_back(vector<int>{ num[i], num[left], num[right] });
                        prev = pair<int, int>(num[left], num[right]);
                    }
                    ++left;
                }
            }
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    ThreeSum solver;
    vector<int> num{-1, 0, 1, 2, -1, -4};
    for (auto &vec : solver.threeSum(num)) {
        for (auto &v : vec) {
            cout << v << "\t";
        }
        cout << endl;
    }
    return 0;
}
