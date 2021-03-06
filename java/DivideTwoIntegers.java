public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean sign = true;
        long ldividend = (long) dividend;
        long ldivisor = (long) divisor;
        if (ldividend < 0) {
            ldividend = -ldividend;
            sign = !sign;
        }
        if (ldivisor < 0) {
            ldivisor = -ldivisor;
            sign = !sign;
        }
        if (ldivisor == 1) {
            if (sign) {
                return (int) ldividend;
            } else {
                return (int) -ldividend;
            }
        }
        long quotient = 0;
        long token = 1;
        while (ldivisor != 0) {
            if (ldividend >= ldivisor) {
                ldividend -= ldivisor;
                quotient += token;
            }
            if (ldividend > ldivisor) {
                ldivisor <<= 1;
                token <<= 1;
            } else if (ldividend < ldivisor) {
                ldivisor >>= 1;
                token >>= 1;
            }
        }
        if (sign) {
            return (int) quotient;
        } else {
            return (int) -quotient;
        }
    }

    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(solution.divide(Integer.MAX_VALUE, -2));
        System.out.println(solution.divide(Integer.MIN_VALUE, 2));
    }
}
