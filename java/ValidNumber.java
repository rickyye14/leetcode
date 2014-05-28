public class ValidNumber {
    public boolean isNumber(String s) {
        String p = "^\\s*[-+]?\\d*\\.?(\\d*|\\d+([eE][-+]?\\d+)?)\\s*$";
        //return !s.matches("^\\s*.\\s*$") && s.matches(p);
        return s.matches(p);
    }

    public static void main(String[] args) {
        ValidNumber solver = new ValidNumber();
        System.out.println(solver.isNumber("e9"));
        System.out.println(solver.isNumber("."));
    }
}
