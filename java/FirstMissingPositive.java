public class FirstMissingPositive {
    public int firstMissingPositive(int[] num) {
        if (num == null) {
            return 1;
        }
        int n = num.length;
        if (n == 0) {
            return 1;
        }
        for (int i = 0; i < n; ++i) {
            // make sure number in range [1, n] in right position
            while (1 <= num[i] && num[i] <= n 
                    && i + 1 != num[i] 
                    // avoid such case [1, 1]
                    && num[i] != num[num[i] - 1]) {
                int temp = num[num[i] - 1];
                num[num[i] - 1] = num[i];
                num[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (num[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive solver = new FirstMissingPositive();
        int[] num = null;

        num = new int[] {3, 4, -1, 1};
        System.out.println(solver.firstMissingPositive(num));

        num = new int[] {1, 1};
        System.out.println(solver.firstMissingPositive(num));
    }
}
