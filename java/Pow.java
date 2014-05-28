public class Pow {
    public double pow(double x, int n) {
        boolean sign = true;
        if (x == 1) {
            return 1;
        }
        if (x == -1) {
            if (n % 2 != 0) {
                return -1;
            }
            return 1;
        }
        if (n < 0) {
            sign = false;
            n = -n;
        }
        double p = 1;
        double t = x;
        while (n != 0) {
            if (n % 2 == 1) {
                p *= t;
            }
            t *= t;
            n >>= 1;
        }
        if (!sign) {
            return 1 / p;
        }
        return p;
    }

    public static void main(String[] args) {
        Pow solver = new Pow();
        System.out.println(solver.pow(4, -3));
        System.out.println(solver.pow(4.5, 0));
    }
}
