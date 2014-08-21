#include "base_include.h"

class RemoveDuplicatesFromSortedArray {
public:
    int removeDuplicates(int A[], int n) {
        if (NULL == A) {
            return 0;
        }
        int back = 0;
        for (int i = 0; i < n; ++i) {
            A[i - back] = A[i];
            int j = i;
            for ( ; j < n && A[i] == A[j]; ++j) {}
            back += j - i - 1;
            i = j - 1;
        }
        return n - back;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
