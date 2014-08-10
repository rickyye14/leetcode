#include "base_include.h"

class ImplementStrstr {
public:
    char *strStr(char *s, char *p) {
        if (NULL == s || NULL == p) {
            return NULL;
        }
        size_t n = strlen(p);
        if (0 == n) {
            return s;
        }
        int *fail = new int[n];
        int ptr = -1;
        fail[0] = ptr;
        for (int i = 1; *(p + i) != '\0'; ++i) {
            for ( ; ptr != -1 && *(p + ptr + 1) != *(p + i); ptr = fail[ptr]) {}
            if (*(p + ptr + 1) == *(p + i)) {
                ++ptr;
            }
            fail[i] = ptr;
        }
        ptr = -1;
        char *res = NULL;
        for (int i = 0; *(s + i) != '\0'; ++i) {
            for ( ; ptr != -1 && *(p + ptr + 1) != *(s + i); ptr = fail[ptr]) {}
            if (*(p + ptr + 1) == *(s + i)) {
                ++ptr;
            }
            if (ptr == n - 1) {
                res = s + i - ptr;
                break;
            }
        }
        delete[] fail;
        return res;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
