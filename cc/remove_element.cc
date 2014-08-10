#include "base_include.h"

class RemoveElement {
public:
    int removeElement(int A[], int n, int elem) {
        int back = 0;
        for (int i = 0; i < n; ++i) {
            A[i - back] = A[i];
            if (A[i] == elem) {
                ++back;
            }
        }
        return n - back;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
