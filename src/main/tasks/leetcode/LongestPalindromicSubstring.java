package tasks.leetcode;

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
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("abb"));
    }

    /**
     * correct solution
     * */
    public String longestPalindrome(String s) {
        String lps = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String odd = expandPalindrome(s, i, i);
            String even = expandPalindrome(s, i, i + 1);
            if (lps.length() < odd.length()) {
                lps = odd;
            }
            if (lps.length() < even.length()) {
                lps = even;
            }
        }
        return lps;
    }

    private String expandPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    /**
     * Для длинных строк слишком медленно выполняется.
     * */
    public String longestPalindromeSlowSolution(String s) {
        String maxLengthSub = "";
        String sub;
        String sub1;
        String sub2;
        if (s.length() == 1) {
            return s;
        } else if (s.length() > 1 && isPalindrome(s)) {
            return s;
        }
        for (int i = 0; i < s.length()/2; i++) {
            sub = s.substring(i, s.length() - i);
            //System.out.println("sub = " + sub);
            if (isPalindrome(sub) && sub.length() > maxLengthSub.length()) {
                maxLengthSub = sub;
            }
            for (int j = 0; j < sub.length(); j++) {
                sub1 = sub.substring(j);
                //System.out.println("sub1 = " + sub1);
                if (isPalindrome(sub1) && sub1.length() > maxLengthSub.length()) {
                    maxLengthSub = sub1;
                }
                sub2 = sub.substring(0, sub.length() - 1 - j);
                //System.out.println("sub2 = " + sub2);
                if (isPalindrome(sub2) && sub2.length() > maxLengthSub.length()) {
                    maxLengthSub = sub2;
                }
            }
        }
        return maxLengthSub;
    }

    public boolean isPalindrome(String sub) {
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
