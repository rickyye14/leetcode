#include <unordered_map>
#include <vector>

#include <iostream>

using std::unordered_map;
using std::vector;
using std::cout;
using std::endl;

class TwoSum {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        unordered_map<int, int> hash;
        vector<int> res;
        size_t n = numbers.size();
        for (size_t i = 0; i < n; ++i) {
            if (i != n - 1 && numbers[i] + numbers[i + 1] == target) {
                res.push_back(i + 1);
                res.push_back(i + 2);
                return res;
            } else {
                hash[numbers[i]] = i;
            }
        }
        for (size_t i = 0; i < n; ++i) {
            if (hash.find(target - numbers[i]) != hash.end()) {
                res.push_back(i + 1);
                res.push_back(hash[target - numbers[i]] + 1);
                return res;
            }
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    TwoSum solver;
    int arr[] = {2, 7, 11, 15};
    vector<int> numbers;
    numbers = vector<int>(arr, arr + sizeof(arr) / sizeof(arr[0]));
    vector<int> res;
    res = solver.twoSum(numbers, 9);
    for (size_t i = 0; i < res.size(); ++i) {
        cout << res[i] << "\t";
    }
    cout << endl;
    return 0;
}
