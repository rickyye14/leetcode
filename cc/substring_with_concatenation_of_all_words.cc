#include "base_include.h"

class SubstringWithConcatenationOfAllWords {
public:
    vector<int> findSubstring(string str, vector<string> &words_list) {
        vector<int> result;
        int len = str.size();
        int n = words_list.size();
        if (0 == n) {
            return result;
        }
        int m = words_list[0].size();
        if (len < n * m) {
            return result;
        }
        unordered_map<string, int> hash;
        for (auto word : words_list) {
            ++hash[word];
        }
        int nm = n * m;
        for (int s = 0; s + nm <= len; ++s) {
            unordered_map<string, int> copy_hash = hash;
            int k = 0;
            for ( ; k < n; ++k) {
                if (--copy_hash[str.substr(s + k * m, m)] < 0) {
                    break;
                }
            }
            if (k == n) {
                result.push_back(s);
            }
        }
        return result;
    }
};

int main(int argc, char *argv[]) {
    SubstringWithConcatenationOfAllWords solver;
    string str;
    vector<string> words_list;

    str = string("barfoothefoobarman");
    words_list = vector<string>{"foo", "bar"};
    for (auto v : solver.findSubstring(str, words_list)) {
        cout << v << endl;
    }
    cout << endl;

    str = string("aaa");
    words_list = vector<string>{"a", "a"};
    for (auto v : solver.findSubstring(str, words_list)) {
        cout << v << endl;
    }
    cout << endl;
    return 0;
}
