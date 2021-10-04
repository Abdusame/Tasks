package yandex_championship_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Решение полность верное. 2 балла дали.
 * */
public class ZeroOne {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s1 = r.readLine();
        String s2 = r.readLine();
        if (!(s1.contains("one") || s1.contains("zero")) || !(s2.contains("one") || s2.contains("zero"))) {
            System.out.println('=');
            return;
        }
        if (s1.startsWith("zeroone") || s1.startsWith("zerozero") ||
                s2.startsWith("zeroone") || s2.startsWith("zerozero")) {
            System.out.println('=');
            return;
        }
        s1 = s1.replaceAll("one", "1");
        s1 = s1.replaceAll("zero", "0");
        s2 = s2.replaceAll("one", "1");
        s2 = s2.replaceAll("zero", "0");
        Character result = null;
        try {
            /*long n1 = Long.parseLong(s1.trim(), 2);
            long n2 = Long.parseLong(s2.trim(), 2);*/
            BigInteger n1 = new BigInteger(s1.trim(), 2);
            BigInteger n2 = new BigInteger(s2.trim(), 2);
            if (n1.compareTo(n2) == 1) {
                result = '>';
            } else if (n1.compareTo(n2) == -1) {
                result = '<';
            } else {
                result = '=';
            }
        } catch (Exception e) {
            System.out.println('=');
            return;
        }
        System.out.println(result);
    }
}
