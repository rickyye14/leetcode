class ReverseInteger {
public:
    int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    return 0;
}
