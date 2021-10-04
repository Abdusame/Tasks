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
        System.out.println(longestPalindrome2("fwebabewdf"));
        //System.out.println(isPalindrome("asbvbsa"));
    }

    public static String longestPalindrome2(String s) {
        String maxLengthSub = "";
        String sub1;
        String sub2;
        String sub3;
        for (int i = 0; i < s.length(); i++) {
            sub1 = s.substring(i);
            if (isPalindrome2(sub1)) {
                maxLengthSub = sub1;
                break;
            }
            sub2 = s.substring(0, s.length() - 1 - i);
            if (isPalindrome2(sub2)) {
                maxLengthSub = sub2;
                break;
            }
            sub3 = s.substring(i, s.length() - 1 - i);
            if (isPalindrome2(sub3)) {
                maxLengthSub = sub3;
                break;
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

    public static boolean isPalindrome2(String sub) {
        boolean isPal = true;
        for (int i = 0; i < sub.length() / 2; i++) {
            if (sub.charAt(i) != sub.charAt(sub.length() - 1 - i)) {
                isPal = false;
                break;
            }
        }
        return isPal;
    }
}
