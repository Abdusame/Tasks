package tasks.leetcode;

/**
 * 10. Regular Expression Matching
 *
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        RegularExpressionMatching r = new RegularExpressionMatching();
        System.out.println(r.isMatch("add", "ad*"));
    }

    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }
}
