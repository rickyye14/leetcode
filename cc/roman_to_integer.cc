class RomanToInteger {
public:
    int romanToInt(string s) {
        int hash[128];
        hash['M'] = 1000;
        hash['D'] = 500;
        hash['C'] = 100;
        hash['L'] = 50;
        hash['X'] = 10;
        hash['V'] = 5;
        hash['I'] = 1;
        int num = 0;
        int n = s.size();
        for (int i = 0; i < n - 1; ++i) {
            if (hash[s[i]] < hash[s[i + 1]]) {
                num -= hash[s[i]];
            } else {
                num += hash[s[i]];
            }
        }
        num += hash[s[n - 1]];
        return num;
    }
};
