public class SqrtX {
    public int sqrt(int x) {
        int low = 0;
        int high = 46340;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (mid * mid > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        SqrtX solver = new SqrtX();
        System.out.println(solver.sqrt(0));
        System.out.println(solver.sqrt(15));
        System.out.println(solver.sqrt(16));
        System.out.println(solver.sqrt(17));
    }
}
