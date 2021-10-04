package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 *
 * */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI"));
    }

    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] letters = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        //System.out.println("длина числа " + s + " равна " + s.length());
        return romanToIntPart(s, map, letters);

    }

    private static int romanToIntPart(String s, Map<Character, Integer> map, char[] letters) {
        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }

        // определить позицию самого большого разряда числа
        int indexOfMax = 0;

        for (int i = 0; i < letters.length; i++) {
            if ((indexOfMax = s.indexOf(letters[i])) != -1) {
                break;
            }
        }

        //System.out.println(s.charAt(indexOfMax));

        int result = map.get(s.charAt(indexOfMax));

        // разделить правую и левую часть числа
        String leftPart = s.substring(0, indexOfMax);
        //System.out.println("левая часть числа = " + leftPart);
        if (leftPart.length() > 0) {
            result = result - map.get(leftPart.charAt(0));
        }

        String rightPart = s.substring(indexOfMax + 1);
        //System.out.println("правая часть числа = " + rightPart);
        if (rightPart.length() > 0) {
            if (rightPart.length() == 1) {
                result = result + map.get(rightPart.charAt(0));
            } else {
                result = result + romanToIntPart(rightPart, map, letters);
            }
        }
        return result;
    }
}
