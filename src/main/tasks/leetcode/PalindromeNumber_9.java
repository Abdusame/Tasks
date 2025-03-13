package tasks.leetcode;

public class PalindromeNumber_9 {

    public static void main(String[] args) {
        PalindromeNumber_9 p = new PalindromeNumber_9();
        //System.out.println(p.isPalindrome(4294));
        System.out.println(p.isPalindromeString(-101));
    }

    public boolean isPalindromeString(int x) {
        String xstr = String.valueOf(x);
        char[] array = xstr.toCharArray();
        boolean isPal = true;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                isPal = false;
                break;
            }
        }
        return isPal;
    }

    public boolean isPalindrome2(int x) {
        if (x >= 0 && x < 10) {
            return true;
        } else if (x < 0) {
            return false;
        }
        System.out.println("x = " + x);

        int li = ((Double) Math.log10(x)).intValue();
        int length = li + 1;
        int firstDigit = ((Double) Math.pow(10, li)).intValue();
        int r1 = x / firstDigit;
        int r2 = x % 10;
        if (r1 == r2) {
            System.out.println("первый и последний знаки совпадают");
            x = (x - ((r1 * firstDigit) + r2)) / 10;
            System.out.println("длина числа должна быть = " + (length - 2));
            System.out.println("реальная длина числа " + (((Double) Math.log10(x)).intValue() + 1));
            if (x > 0 && (((Double) Math.log10(x)).intValue() + 1) < length - 2) {
                return false;
            } else {
                return isPalindrome2(x);
            }
        } else {
            System.out.println("первый и последний знаки НЕ совпадают");
            return false;
        }
    }

    public boolean isPalindrome(int x) {
        if (x <= 10) {
            return false;
        }
        return firstAndLastEquals(x);
    }

    private boolean firstAndLastEquals(int y) {
        System.out.println("y = " + y);
        if (y == 0) {
            return true;
        }
        int li = ((Double) Math.log10(y)).intValue();
        int length = li + 1;
        int firstDigit = ((Double) Math.pow(10, li)).intValue();
        int r1 = y / firstDigit;
        int r2 = y % 10;
        if (r1 == r2) {
            System.out.println("первый и последний знаки совпадают");
            y = (y - ((r1 * firstDigit) + r2)) / 10;
            if (length > 1) {
                boolean result = firstAndLastEquals(y);
                if (!result) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            System.out.println("первый и последний знаки НЕ совпадают");
            return false;
        }
    }
}
