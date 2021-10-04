package leetcode;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome2(String s) {
        String maxLengthSub = "";
        String sub;
        for (int i = 0; i < s.length(); i++) {
            sub = s.substring(i);
            if (isPalindrome(sub) && sub.length() > maxLengthSub.length()) {
                maxLengthSub = sub;
            }
        }
        return maxLengthSub;
    }

    public static String longestPalindrome(String s) {
        String maxLengthSub = "";
        String sub;
        for (int i = 0; i < s.length(); i++) {
            sub = s.substring(i);
            if (isPalindrome(sub) && sub.length() > maxLengthSub.length()) {
                maxLengthSub = sub;
            }
        }
        return maxLengthSub;
    }

    public static boolean isPalindrome(String sub) {
        char[] array = sub.toCharArray();
        boolean isPal = true;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                isPal = false;
                break;
            }
        }
        return isPal;
    }
}
