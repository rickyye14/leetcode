public class MultiplyStrings {
    private String plus(String num1, String num2) {
        if (num1.equals("0")) {
            return num2;
        }
        if (num2.equals("0")) {
            return num1;
        }
        int n = num1.length();
        int m = num2.length();
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int i = n - 1;
        int j = m - 1;
        for ( ; i >= 0 && j >= 0; --i, --j) {
            int s = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            sum.append(s % 10);
            carry = s / 10;
        }
        for ( ; i >= 0; --i) {
            int s = num1.charAt(i) - '0' + carry;
            sum.append(s % 10);
            carry = s / 10;
        }
        for ( ; j >= 0; --j) {
            int s = num2.charAt(j) - '0' + carry;
            sum.append(s % 10);
            carry = s / 10;
        }
        if (carry != 0) {
            sum.append(carry);
        }
        return sum.reverse().toString();
    }

    private String multiplyWithDigit(String num, int digit) {
        if (digit == 0) {
            return "0";
        }
        StringBuilder product = new StringBuilder();
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; --i) {
            int p = (num.charAt(i) - '0') * digit + carry;
            product.append(p % 10);
            carry = p / 10;
        }
        if (carry != 0) {
            product.append(carry);
        }
        return product.reverse().toString();
    }

    public String multiply(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        int n = num1.length();
        int m = num2.length();
        if (n == 0) {
            return num2;
        }
        if (m == 0) {
            return num1;
        }
        if (n > m) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        n = num1.length();
        m = num2.length();
        String res = new String("0");
        for (int i = n - 1; i >= 0; --i) {
            int digit = num1.charAt(i) - '0';
            StringBuilder product = new StringBuilder(multiplyWithDigit(num2, digit));
            for (int j = 0; j < n - i - 1; ++j) {
                product.append(0);
            }
            res = plus(res, product.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        MultiplyStrings solver = new MultiplyStrings();
        System.out.println(solver.multiply("123", "23"));
    }
}
