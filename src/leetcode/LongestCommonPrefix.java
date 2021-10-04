package leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] str = new String[]{"ab","a"};
        System.out.println("longest common prefix is - " + l.longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        String commonPrefix = "";
        for (int i = 1; i <= strs[0].length(); i++) {
            String sub = strs[0].substring(0, i);
            System.out.println("checking - " + sub);
            if (check(strs, sub, i)) {
                commonPrefix = sub;
            } else {
                break;
            }
        }
        return commonPrefix;
    }

    private boolean check(String[] strs, String sub, int l) {
        for (int j = 1; j < strs.length; j++) {
            if (strs[j].length() >= l) {
                if (!strs[j].substring(0, l).equals(sub)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
