package leetcode;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse2(1996));
    }

    // отрабатывает за 9 мс
    public static int reverse(int x) {
        boolean negative = false;
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }
        long xlong = x;
        if (xlong < 0) {
            negative = true;
            xlong = xlong * (-1);
        }
        String strNumber = String.valueOf(xlong);
        System.out.println(strNumber);
        System.out.println(strNumber.length());
        System.out.println(negative);
        StringBuilder stb = new StringBuilder();
        for(int i = strNumber.length() - 1; i >=0; i--) {
            stb.append(strNumber.charAt(i));
        }

        Long result = Long.parseLong(stb.toString());
        if (negative) result = result * (-1);

        if (result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE) {
            return result.intValue();
        } else {
            return 0;
        }
    }

    // отрабатывает за 1 мс
    public static int reverse2(int x) {
        if (x == 0) return 0;
        long xlong = x;
        if (xlong < 0) {
            xlong = xlong * (-1);
        }
        long y = 0;
        int p = ((int)Math.log10(xlong));
        while (p >= 0) {
            y = 10 * y + (xlong % 10);
            xlong = xlong / 10;
            p--;
        }
        if (x < 0) y = y * (-1);
        if (y <= Integer.MAX_VALUE && y >= Integer.MIN_VALUE) {
            return (int) y;
        } else {
            return 0;
        }
    }
}
