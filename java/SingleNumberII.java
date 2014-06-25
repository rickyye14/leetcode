public class SingleNumberII {
    public int singleNumber(int[] A) {
        if (A == null) {
            return 0;
        }
        int[] bits = new int[32];
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            int x = A[i];
            for (int j = 0; j < 32; ++j) {
                if ( (x & (1 << j) ) != 0) {
                    ++bits[j];
                }
            }
        }
        int s = 0;
        for (int i = 0; i < 32; ++i) {
            s |= (bits[i] % 3) << i;
        }
        return s;
    }

    public static void main(String[] args) {
        SingleNumberII solver = new SingleNumberII();
        int[] A = null;

        A = new int[] {-2,-2,1,1,-3,1,-3,-3,-4,-2};
        System.out.println(solver.singleNumber(A));
    }
}
