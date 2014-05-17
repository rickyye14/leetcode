public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int temp = num;
        while (temp >= 1000) {
            builder.append("M");
            temp -= 1000;
        }
        while (temp >= 900) {
            builder.append("CM");
            temp -= 900;
        }
        while (temp >= 500) {
            builder.append("D");
            temp -= 500;
        }
        while (temp >= 400) {
            builder.append("CD");
            temp -= 400;
        }
        while (temp >= 100) {
            builder.append("C");
            temp -= 100;
        }
        while (temp >= 90) {
            builder.append("XC");
            temp -= 90;
        }
        while (temp >= 50) {
            builder.append("L");
            temp -= 50;
        }
        while (temp >= 40) {
            builder.append("XL");
            temp -= 40;
        }
        while (temp >= 10) {
            builder.append("X");
            temp -= 10;
        }
        while (temp >= 9) {
            builder.append("IX");
            temp -= 9;
        }
        while (temp >= 5) {
            builder.append("V");
            temp -= 5;
        }
        while (temp >= 4) {
            builder.append("IV");
            temp -= 4;
        }
        while (temp >= 1) {
            builder.append("I");
            temp -= 1;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
        System.out.println(solution.intToRoman(49));
        System.out.println(solution.intToRoman(1606));
    }
}
