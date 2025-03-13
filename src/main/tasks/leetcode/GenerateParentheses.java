package tasks.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 22. Generate Parentheses
 Medium
 Topics
 Companies
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 Example 1:

 Input: n = 4; s = 14 = 2^4 - 2
 Output: ["(((())))","()((()))","((()))()","((()()))","()(()())","(()())()", "((())())", "()(())()", "(())()()",
        "(()(()))","()()(())","()(())()", "(()()())","()()()()"]
 Example 2:

 Input: n = 3; s = 5 = 2^3 - 3
 Output: ["((()))","(()())","(())()","()(())","()()()"]
 Example 2:

 Input: n = 2; s = 2 = 2^2 - 2
 Output: ["(())","()()"]

 Input: n = 1; s = 1 = 2^1 - 1
 Output: ["()"]

 Constraints:
 1 <= n <= 8
 * */
public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(frame(""));
        }
        return list;
    }

    private String frame(String s) {
        return "(" + s + ")";
    }

    private String start(String s) {
        return "()" + s;
    }

    private String end(String s) {
        return s + "()";
    }
}
