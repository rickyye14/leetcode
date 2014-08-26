#include "base_include.h"

class DivideTwoIntegers {
public:
    int divide(int dividend, int divisor) {
        if (1 == divisor) {
            return dividend;
        }
        if (-1 == divisor) {
            return -dividend;
        }
        long long ldd = (long long) dividend;
        long long ldv = (long long) divisor;
        long long lq = 0;
        long long bin = 1;

        int sign = 1;
        if (ldd < 0) {
            sign = -sign;
            ldd = -ldd;
        }
        if (ldv < 0) {
            sign = -sign;
            ldv = -ldv;
        }
        while (ldd != 0) {
            if (ldd >= ldv) {
                ldd -= ldv;
                lq += bin;
                ldv <<= 1;
                bin <<= 1;
            } else {
                ldv >>= 1;
                bin >>= 1;
            }
        }
        if (-1 == sign) {
            return (int) -lq;
        } else {
            return (int) lq;
        }
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
