package tasks.leetcode;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * []{}()
 * [{()}]
 * ({})([])
 * */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        //System.out.println(v.isValid("[{}()]"));
        String s = "[{}()";
        System.out.println(v.isValidTheMostEffectiveSolution(s));
    }

    public boolean isValidTheMostEffectiveSolution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.push(symbol);
            } else if (symbol == ')') {
                if (stack.size() == 0) {
                    return false;
                } else if (stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (symbol == '}') {
                if (stack.size() == 0) {
                    return false;
                } else if (stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (symbol == ']') {
                if (stack.size() == 0) {
                    return false;
                } else if (stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }

    public boolean isValid(String s) {
        int length = s.length();
        for (int i = 1; i <= length/2; i++) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.equals("");
    }

    public boolean isValidRegex(String s) {
        int length = s.length();
        for (int i = 1; i <= length/2; i++) {
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\{\\}", "");
            s = s.replaceAll("\\[\\]", "");
        }
        return s.equals("");
    }

    public boolean isValidVsComments(String s) {
        System.out.println("length = " + s.length());
        System.out.println("length/2 = " + s.length()/2);
        int length = s.length();
        for (int i = 1; i <= length/2; i++) {
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\{\\}", "");
            s = s.replaceAll("\\[\\]", "");
            System.out.println("итерация № " + i);
            System.out.println(s);
        }
        return s.equals("");
    }
}
