package tasks.luhn;

import java.util.ArrayList;
import java.util.List;

public class LuhnChecker {
    public static void main(String[] args) {
        Integer num1 = 0;
        Integer num2 = 9999999;
        System.out.println(countLuhnValidNumbersInRange(num1, num2));
        //System.out.println(isValidLuhn("9999997"));
    }

    private static int countLuhnValidNumbersInRange(Integer num1, Integer num2) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = num1; i <= num2; i++) {
            if (isValidLuhn(String.valueOf(i))) {
                System.out.println(i);
                resultList.add(i);
            }
        }
        return resultList.size();
    }

    private static boolean isValidLuhn(String value) {
        int sum = Character.getNumericValue(value.charAt(value.length() - 1));
        int parity = value.length() % 2;
        for (int i = value.length() - 2; i >= 0; i--) {
            int summand = Character.getNumericValue(value.charAt(i));
            if (i % 2 == parity) {
                int product = summand * 2;
                summand = (product > 9) ? (product - 9) : product;
            }
            sum += summand;
        }
        return (sum % 10) == 0;
    }
}
