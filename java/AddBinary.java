public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int n = a.length();
        int m = b.length();
        int i = n - 1;
        int j = m - 1;
        int carry = 0;
        for ( ; i >= 0 && j >= 0; --i, --j) {
            int s = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            sum.append(s % 2);
            carry = s / 2;
        }
        for ( ; i >= 0; --i) {
            int s = a.charAt(i) - '0' + carry;
            sum.append(s % 2);
            carry = s / 2;
        }
        for ( ; j >= 0; --j) {
            int s = b.charAt(j) - '0' + carry;
            sum.append(s % 2);
            carry = s / 2;
        }
        if (carry != 0) {
            sum.append(1);
        }
        return sum.reverse().toString();
    }
}
