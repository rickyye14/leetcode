public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        int start = n - 1;
        for ( ; start >= 0 && s.charAt(start) == ' '; --start) {
            ;
        }
        if (start < 0) {
            return 0;
        }
        int end = start;
        for ( ; end >= 0 && s.charAt(end) != ' '; --end) {
            ;
        }
        return start - end;
    }
}
