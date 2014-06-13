public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null) {
            return 0;
        }
        int n = ratings.length;
        if (n == 0) {
            return 0;
        }
        int[] lessLeft = new int[n];
        lessLeft[0] = 0;
        for (int i = 1; i < n; ++i) {
            if (ratings[i - 1] < ratings[i]) {
                lessLeft[i] = lessLeft[i - 1] + 1;
            } else {
                lessLeft[i] = 0;
            }
        }
        int[] greaterRight = new int[n];
        greaterRight[n - 1] = 0;
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i + 1] < ratings[i]) {
                greaterRight[i] = greaterRight[i + 1] + 1;
            } else {
                greaterRight[i] = 0;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += 1 + Math.max(lessLeft[i], greaterRight[i]);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Candy solver = new Candy();
        int[] ratings = null;
        ratings = new int[] {1, 2, 2, 2, 3};
        System.out.println(solver.candy(ratings));

        ratings = new int[] {1, 2, 2};
        System.out.println(solver.candy(ratings));
    }
}
