package tasks.leetcode;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Numbe
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber l = new LetterCombinationsOfAPhoneNumber();
        String digits = "234";
        List<String> list = l.letterCombinations(digits);
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        if (digits.length() == 1) {
            list.addAll(map.get(digits.charAt(0)));
            return list;
        }

        if (digits.length() == 2) {
            List<String> fl1 = map.get(digits.charAt(0));
            List<String> fl2 = map.get(digits.charAt(1));
            for (int i = 0; i < fl1.size(); i++) {
                String l1 = fl1.get(i);
                for (int j = 0; j < fl2.size(); j++) {
                    String l2 = fl2.get(j);
                    list.add(l1 + l2);
                }
            }
        }

        if (digits.length() == 3) {
            List<String> fl1 = map.get(digits.charAt(0));
            List<String> fl2 = map.get(digits.charAt(1));
            List<String> fl3 = map.get(digits.charAt(2));
            for (int i = 0; i < fl1.size(); i++) {
                String l1 = fl1.get(i);
                for (int j = 0; j < fl2.size(); j++) {
                    String l2 = fl2.get(j);
                    for (int k = 0; k < fl3.size(); k++) {
                        String l3 = fl3.get(k);
                        list.add(l1 + l2 + l3);
                    }
                }
            }
        }
        return list;
    }
}
