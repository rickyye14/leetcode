public class ReverseInteger {
    public int reverse(int x) {
        int t = 0;
        while (x != 0) {
            t = t * 10 + x % 10;
            x /= 10;
        }
        return t;
    }

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        int x;
        x = -123;
        System.out.println(solution.reverse(x));
    }
}
