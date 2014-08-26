#include "base_include.h"

class PermutationsII {
public:
    vector<vector<int> > permuteUnique(vector<int> &num) {
        vector<vector<int> > res;
        int n = num.size();
        if (n < 1) {
            return res;
        }
        vector<int> mark(num);
        auto cmp_vec = [](const vector<int> &v1, const vector<int> &v2) {
            int n = v1.size();
            int m = v2.size();
            if (n != m) {
                return false;
            }
            for (int i = 0; i < n; ++i) {
                if (v1[i] != v2[i]) {
                    return false;
                }
            }
            return true;
        };
        do {
            int i = n - 1;
            for ( ; i > 0; --i) {
                if (num[i - 1] < num[i]) {
                    for (int j = n - 1; j >= i; --j) {
                        if (num[j] > num[i - 1]) {
                            swap(num[j], num[i - 1]);
                            break;
                        }
                    }
                    break;
                }
            }
            int j = n - 1;
            for ( ; i < j; ++i, --j) {
                swap(num[i], num[j]);
            }
            res.push_back(num);
        } while (!cmp_vec(mark, num));
        return res;
    }
};

int main(int argc, char *argv[]) {
    PermutationsII solver;
    vector<int> num{1, 1, 2};
    for (auto vec : solver.permuteUnique(num)) {
        for (auto v : vec) {
            cout << v << " ";
        }
        cout << endl;
    }
    return 0;
}
