public class NextPermutation {
    public void nextPermuation(int[] num) {
        if (num == null) {
            return;
        }
        int n = num.length;
        if (n < 2) {
            return;
        }
        int start = n - 1;
        int end = n - 1;
        while (start > 0) {
            if (num[start - 1] < num[start]) {
                for (int i = n - 1; i >= start; --i) {
                    if (num[i] > num[start - 1]) {
                        int temp = num[i];
                        num[i] = num[start - 1];
                        num[start - 1] = temp;
                        break;
                    }
                }
                break;
            }
            --start;
        }
        while (start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] num = null;

        num = new int[] {1, 1, 5};
        solution.nextPermuation(num);
        for (int i = 0; i < num.length; ++i) {
            System.out.printf("%4d", num[i]);
        }
        System.out.println();
    }
}
