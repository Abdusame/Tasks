package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("-  234"));
        System.out.println(myAtoi("4193 with words"));

        /*String str = "-  2334";
        Pattern pattern = Pattern.compile("[ \\f\\n\\r\\t\\v]+");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
        System.out.println(str.substring(matcher.start(), matcher.end()));*/
    }

    public static int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if (s.length() == 0) return 0;

        //Discard whitespaces in the beginning
        s = s.trim();

        // Check if optional sign if it exists
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }

        // Build the result and check for overflow/underflow condition
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return result * sign;
    }

    /**
     * '+' = 43
     * '-' = 45
     * '.' = 46
     * */
    public static int myAtoiOld2(String s) {
        s = s.trim();
        System.out.println(s);
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            Pattern pattern0 = Pattern.compile("[^0-9]");
            Matcher matcher0 = pattern0.matcher(s);
            if (matcher0.find()) {
                System.out.println("совпадение с патерном 0");
                return 0;
            }
        }
        Pattern pattern1 = Pattern.compile("^[^\\+\\-0-9]+");
        Matcher matcher1 = pattern1.matcher(s);
        if (matcher1.find()) {
            System.out.println("совпадение с патерном 1");
            return 0;
        }
        Pattern pattern11 = Pattern.compile("^[\\-\\+]{2,}");
        Matcher matcher11 = pattern11.matcher(s);
        if (matcher11.find()) {
            System.out.println("совпадение с патерном 11");
            return 0;
        }
        Pattern pattern12 = Pattern.compile("[ \\f\\n\\r\\t\\v]+[0-9]+");
        Matcher matcher12 = pattern12.matcher(s);
        if (matcher12.find()) {
            System.out.println("совпадение с патерном 12");
            return 0;
        }
        Pattern pattern2 = Pattern.compile("[-+]?([0-9]*\\.[0-9]+|[0-9]+)");
        Matcher matcher2 = pattern2.matcher(s);
        String result = "";
        if (matcher2.find()) {
            result = s.substring(matcher2.start(), matcher2.end());
            long r;
            if (result.charAt(0) == '-') {
                r = (long) Double.parseDouble(result.substring(1)) * (-1);
            } else if (result.charAt(0) == '+') {
                r = (long) Double.parseDouble(result.substring(1));
            } else {
                r = (long) Double.parseDouble(result);
            }
            return check(r);
        } else {
            return 0;
        }
    }

    private static int check(long value) {
        if (value <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (value >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) value;
        }
    }

    public static int myAtoiOld(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            if (s.charAt(0) < 48 || s.charAt(0) > 57) {
                return 0;
            }
        }
        s = s.trim();
        int firstSymbol = s.charAt(0);
        if ((firstSymbol < 48 || firstSymbol > 57) && firstSymbol != 46 && firstSymbol != 45) {
            return 0;
        }
        if (s.length() > 1) {
            int secondSymbol = s.charAt(1);
            if (firstSymbol == 45) {
                if (secondSymbol < 48 || secondSymbol > 57) {
                    return 0;
                }
            }
        }
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            int numValue = symbol;
            System.out.println(numValue);
            if ((numValue >= 48 && numValue <= 57) || numValue == 46 /*|| numValue == 45*/) {
                stb.append(symbol);
            }
        }
        System.out.println(stb.toString());
        String strResult = stb.toString();
        int signIndex = s.indexOf(strResult);
        if (strResult.contains(".")) {
            Double resultDouble = Double.parseDouble(strResult);
            if (signIndex >= 1) {
                char sign = s.charAt(signIndex - 1);
                if (sign == '-') {
                    resultDouble = resultDouble * (-1);
                }
            }
            return resultDouble.intValue();
        } else {
            Long resultLong = Long.parseLong(strResult);
            if (signIndex >= 1) {
                char sign = s.charAt(signIndex - 1);
                if (sign == '-') {
                    resultLong = resultLong * (-1);
                }
            }
            if (resultLong <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (resultLong >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return resultLong.intValue();
        }
    }
}
