#include "base_include.h"

class FourSum {
public:
    vector<vector<int> > fourSum(vector<int> &num, int target) {
        vector<vector<int> > res;
        set<vector<int> > vset;
        int n = num.size();
        if (n < 4) {
            return res;
        }
        sort(num.begin(), num.end());
        for (int i = 0; i < n - 3; ++i) {
            if (i != 0 && num[i - 1] == num[i]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j != i + 1 && num[j - 1] == num[j]) {
                    continue;
                }
                int l = j + 1;
                int r = n - 1;
                int token = target - num[i] - num[j];
                while (l < r) {
                    if (num[l] + num[r] < token) {
                        ++l;
                    } else if (num[l] + num[r] > token) {
                        --r;
                    } else {
                        vector<int> token{num[i], num[j], num[l], num[r]};
                        vset.insert(token);
                        ++l;
                    }
                }
            }
        }
        for (auto &v : vset) {
            res.push_back(v);
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
