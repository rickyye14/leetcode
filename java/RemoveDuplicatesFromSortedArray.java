public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] num) {
        if (num == null) {
            return 0;
        }
        int n = num.length;
        if (n < 2) {
            return n;
        }
        int m = 0;
        int count = 0;
        for (int start = 0, end = 0; start < n; start = end) {
            ++count;
            for (end = start; end < n && num[start] == num[end]; ++end) {
                ;
            }
            if (start != 0) {
                num[start - m] = num[start];
            }
            m += end - start - 1;
        }
        return count;
    }

    public void display(int[] num, int n) {
        for (int i = 0; i < Math.min(num.length, n); ++i) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        int[] num = null;
        int n = 0;

        num = new int[] {1, 1, 1, 2, 2, 3};
        n = solution.removeDuplicates(num);
        solution.display(num, n);
    }
}
