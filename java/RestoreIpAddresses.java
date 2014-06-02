import java.util.ArrayList;

public class RestoreIpAddresses {
    private StringBuilder buffer;
    private ArrayList<String> res;

    public ArrayList<String> restoreIpAddresses(String s) {
        buffer = new StringBuilder();
        res = new ArrayList<String>();
        if (s == null) {
            return res;
        }
        searchIpAddresses(s, 0, 4, "");
        return res;
    }

    private void searchIpAddresses(String s, int start, int k, String dot) {
        int n = s.length();
        if (n - start < k || n - start > 3 * k) {
            return;
        }
        if (k == 0) {
            if (start == n) {
                res.add(buffer.toString());
            }
            return;
        }
        int num = 0;
        for (int i = 0; i < 3 && start + i < n; ++i) {
            int digit = s.charAt(start + i) - '0';
            num = num * 10 + digit;
            if (num > 255) {
                continue;
            }
            buffer.append(dot);
            buffer.append(String.valueOf(num));
            int t = dot.length() + i + 1;
            searchIpAddresses(s, start + i + 1, k - 1, ".");
            for (int j = 0; j < t; ++j) {
                buffer.deleteCharAt(buffer.length() - 1);
            }
            if (num == 0) {
                break;
            }
        }
    }
}
