import java.util.Arrays;
import java.util.ArrayList;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null) {
            return res;
        }
        int n = num.length;
        if (n < 3) {
            return res;
        }
        Arrays.sort(num);
        for (int i = 0; i < n - 2; ++i) {
            if (i != 0 && num[i] == num[i + 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 1; ++j) {
                int target = -num[i] - num[j];
                /**
                 * Mistake in target < num[j]
                 */
                if (target < num[j + 1]) {
                    break;
                }
                if (target > num[n - 1]) {
                    break;
                }
                int low = j + 1;
                int high = n - 1;
                int mid = (low + high) / 2;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (num[mid] == target) {
                        ArrayList<Integer> token = new ArrayList<Integer>();
                        token.add(num[i]);
                        token.add(num[j]);
                        token.add(num[mid]);
                        if (res.size() == 0) {
                            res.add(token);
                        } else {
                            ArrayList<Integer> last = res.get(res.size() - 1);
                            if (token.get(0) != last.get(0) 
                                    || token.get(1) != last.get(1) 
                                    || token.get(2) != last.get(2)) {
                                res.add(token);
                            }
                        }
                        break;
                    } else if (num[mid] < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return res;
    }

    public void displayResult(ArrayList<ArrayList<Integer>> res) {
        if (res == null) {
            return;
        }
        int n = res.size();
        for (int i = 0; i < n; ++i) {
            String token = "";
            for (int j = 0; j < res.get(i).size(); ++j) {
                System.out.print(token + res.get(i).get(j));
                token = ", ";
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] num = null;

        num = new int[] {-1, 0, 1, 2, -1, -4};
        solution.displayResult(solution.threeSum(num));

        num = new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        solution.displayResult(solution.threeSum(num));

        num = new int[] {1, -1, -1, 0};
        solution.displayResult(solution.threeSum(num));

    }
}
