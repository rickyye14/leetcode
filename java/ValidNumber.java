public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        int expIndex = -1;
        expIndex = s.indexOf("e");
        if (expIndex != -1) {
            return isNumberWithoutExp(s.substring(0, expIndex), true) 
                && isNumberWithoutExp(s.substring(expIndex + 1), false);
        }
        expIndex = s.indexOf("E");
        if (expIndex != -1) {
            return isNumberWithoutExp(s.substring(0, expIndex), true) 
                && isNumberWithoutExp(s.substring(expIndex + 1), false);
        }
        return isNumberWithoutExp(s, true);
    }

    private boolean isNumberWithoutExp(String s, boolean allowDecimal) {
        int len = s.length();
        if (len == 0) {
            return false;
        }
        int ptr = 0;
        if ('-' == s.charAt(ptr) || '+' == s.charAt(ptr)) {
            ++ptr;
        }
        if (ptr == len) {
            return false;
        }
        int decimalIndex = s.indexOf(".");
        if (decimalIndex != -1) {   //s contains '.'
            if (len - ptr == 1 || !allowDecimal) {  //notice this case: "."
                return false;
            }
            for ( ; ptr < decimalIndex && isDigit(s.charAt(ptr)); ++ptr) {}
            if (ptr != decimalIndex) {
                return false;
            }
            ++ptr;  //skip the '.'
        }
        for ( ; ptr < len && isDigit(s.charAt(ptr)); ++ptr) {}
        return ptr == len;
    }

    private boolean isDigit(char ch) {
        return '0' <= ch && ch <= '9';
    }

    public static void main(String[] args) {
        ValidNumber solver = new ValidNumber();
        System.out.println(solver.isNumber("e9"));
        System.out.println(solver.isNumber("."));
        System.out.println(solver.isNumber(" +2OO805.8"));
    }
}
