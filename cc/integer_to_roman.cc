#include "base_include.h"

class IntegerToRoman {
public:
    string intToRoman(int num) {
        int token = num;
        string roman = "";
        for (int i = 0; token != 0 && i < 13; ++i) {
            while (token >= values[i]) {
                token -= values[i];
                roman += digits[i];
            }
        }
        return roman;
    }

private:
    int values[13] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    string digits[13] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
};

int main(int argc, char *argv[]) {
    return 0;
}
