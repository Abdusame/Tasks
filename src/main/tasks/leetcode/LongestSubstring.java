package tasks.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        //lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring2("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s.length() == 1) return 1;
        int j = 0;
        while(j < s.length()) {
            String sub = "";
            for (int i = j; i < s.length(); i++) {
                String character = s.substring(i, i+1);
                if (!sub.contains(character)) {
                    sub += character;
                } else {
                    break;
                }
            }
            System.out.println(sub);
            if (sub.length() > max) {
                max = sub.length();
            }
            j = j + 1;
        }
        System.out.println(max);
        return max;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        if (s.length() == 1) return 1;
        int j = 0;
        while(j < s.length()) {
            Set<Character> set = new HashSet<>();
            for (int i = j; i < s.length(); i++) {
                char character = s.charAt(i);
                if (!set.contains(character)) {
                    set.add(character);
                } else {
                    break;
                }
            }
            System.out.println(set.toString());
            if (set.size() > max) {
                max = set.size();
            }
            j++;
        }
        System.out.println(max);
        return max;
    }




   /* Первый вариант быстрее 5 %

        int max = 0;
        if (s.length() == 1) return 1;
        for (int j = 0; j < s.length(); j++) {
        String sub = "";
        for (int i = j; i < s.length(); i++) {
            String character = s.substring(i, i+1);
            if (!sub.contains(character)) {
                sub += character;
            } else {
                break;
            }
        }
        //System.out.println(sub);
        if (sub.length() > max) {
            max = sub.length();
        }
    }
        System.out.println(max);
        return max;*/
}
