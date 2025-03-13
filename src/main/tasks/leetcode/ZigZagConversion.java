package tasks.leetcode;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    /**
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * */
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            select(stb, s, numRows, i);
        }
        String result = stb.toString();
        System.out.println(result);
        return result;
    }

    /**
     * s - исходная строка
     * numRows - количество строк в результирующем зиг-заге
     * d - индекс символа с которого нужно начать итерацию
     * */
    public static void select(StringBuilder stb, String s, int numRows, int d) {
        int n = 2 * numRows - 2;
        int i = 0;
        while(i * n + d < s.length()) {
            stb.append(s.charAt(i * n + d));
            if (d != 0 && d < numRows - 1 && (i * n + n - d) < s.length()) {
                stb.append(s.charAt(i * n + n - d));
            }
            i++;
        }
    }
}
