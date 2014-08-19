#include "base_include.h"

class NextPermutation {
public:
    void nextPermutation(vector<int> &num) {
        int n = num.size();
        if (n <= 1) {
            return;
        }
        int i = n - 1;
        for ( ; i > 0; --i) {
            if (num[i - 1] < num[i]) {
                for (int j = n - 1; j >= i; --i) {
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
    }
};

int main(int argc, char *argv[]) {
    NextPermutation solver;
    vector<int> num;

    num = vector<int>{1, 2};
    solver.nextPermutation(num);
    for (auto n : num) {
        cout << n << endl;
    }
    cout << endl;

    num = vector<int>{1, 2, 3};
    solver.nextPermutation(num);
    for (auto n : num) {
        cout << n << endl;
    }
    cout << endl;

    return 0;
}
