public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] buckets = new int[1 << 8];
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int c = 0;
        while (end < n) {
            while (end < n) {
                c = (int) s.charAt(end);
                ++buckets[c];
                ++end;
                if (buckets[c] > 1) {
                    break;
                }
            }

            if (end < n) {
                maxLength = Math.max(maxLength, end - start - 1);
            } else {
                if (buckets[c] > 1) {
                    maxLength = Math.max(maxLength, end - start - 1);
                } else {
                    maxLength = Math.max(maxLength, end - start);
                }
                break;
            }

            do {
                c = (int) s.charAt(start);
                --buckets[c];
                ++start;
            } while (buckets[c] != 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = null;
        LongestSubstringWithoutRepeatingCharacters solution
            = new LongestSubstringWithoutRepeatingCharacters();
        s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));

        s = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(s));

        s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        System.out.println(solution.lengthOfLongestSubstring(s));

        s = "qopubjguxhxdipfzwswybgfylqvjzhar";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
