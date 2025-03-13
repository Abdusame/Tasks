package tasks.algorithms;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        // % - 0.234 s
        // & - 0.202 s
        try(Scanner in = new Scanner(System.in)) {
            long x1 = in.nextLong();
            long x2 = in.nextLong();
            long x3 = in.nextLong();
            long c = in.nextLong();
            long start = System.currentTimeMillis();
            System.out.println(doIt(x1, x2, x3, c));
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }

    private static long doIt(long x1, long x2, long x3, long c) {
        if (c == 0) {
            return -1;
        }
        long chislo = 0;
        long n = 0;
        boolean x1Chet = (x1 & 1) == 0;
        boolean x2Chet = (x2 & 1) == 0;
        boolean x3Chet = (x3 & 1) == 0;
        if (!x1Chet && !x2Chet && !x3Chet) { // 0 0 0
            do {
                chislo = chislo + 1;
            /*if (chislo > 1.0E18) {
                return -1;
            }*/
                if (delimost1(x1, x2, x3, chislo)) {
                    n++;
                }
            } while (n < c);
        } else if (x1Chet && !x2Chet && !x3Chet) { // 1 0 0
            do {
                chislo = chislo + 1;
                if (delimost2(x1, x2, x3, chislo)) {
                    n++;
                }
            } while (n < c);
        } else if (x1Chet && x2Chet && !x3Chet) { // 1 1 0
            do {
                chislo = chislo + 1;
                if (delimost3(x1, x2, x3, chislo)) {
                    n++;
                }
            } while (n < c);
        } else if (x1Chet && !x2Chet && x3Chet) { // 1 0 1
            do {
                chislo = chislo + 1;
                if (delimost4(x1, x2, x3, chislo)) {
                    n++;
                }
            } while (n < c);
        } else if (!x1Chet && x2Chet && !x3Chet) {  // 0 1 0
            do {
                chislo = chislo + 1;
                if (delimost5(x1, x2, x3, chislo)) {
                    n++;
                }
            } while (n < c);
        } else if (!x1Chet && !x2Chet && x3Chet) {  // 0 0 1
            do {
                chislo = chislo + 1;
                if (delimost6(x1, x2, x3, chislo)) {
                    n++;
                }
            } while (n < c);
        } else if (!x1Chet && x2Chet && x3Chet) {  // 0 1 1
            do {
                chislo = chislo + 1;
                if (delimost7(x1, x2, x3, chislo)) {
                    n++;
                }
            } while (n < c);
        } else { // все четные 1 1 1
            do {
                chislo = chislo + 1;
                if (delimost8(x1, x2, x3, chislo)) {
                    n++;
                }
            } while (n < c);
        }
        if (chislo == c) {
            return -1;
        } else {
            return chislo;
        }
    }

    static boolean delimost1(long x1, long x2, long x3, long b) {
        int sum = 0;
        if (delitsya(b, x1)) {
            sum++;
        }
        if (delitsya(b, x2)) {
            sum++;
        }
        if (sum == 0) {
            return false;
        }
        if (delitsya(b, x3)) {
            sum++;
        }
        return sum == 2;
    }

    static boolean delimost2(long x1, long x2, long x3, long b) {
        int sum = 0;
        boolean bChet = (b & 1) == 0;
        if (bChet) {
            if (delitsya(b, x1)) {
                sum++;
            }
        }
        if (delitsya(b, x2)) {
            sum++;
        }
        if (sum == 0) {
            return false;
        }
        if (delitsya(b, x3)) {
            sum++;
        }
        return sum == 2;
    }

    static boolean delimost3(long x1, long x2, long x3, long b) {
        int sum = 0;
        boolean bChet = (b & 1) == 0;
        if (bChet) {
            if (delitsya(b, x1)) {
                sum++;
            }
            if (delitsya(b, x2)) {
                sum++;
            }
        }
        if (sum == 0) {
            return false;
        }
        if (delitsya(b, x3)) {
            sum++;
        }
        return sum == 2;
    }

    static boolean delimost4(long x1, long x2, long x3, long b) {
        int sum = 0;
        boolean bChet = (b & 1) == 0;
        if (bChet) {
            if (delitsya(b, x1)) {
                sum++;
            }
        }
        if (delitsya(b, x2)) {
            sum++;
        }
        if (sum == 0) {
            return false;
        }
        if (bChet) {
            if (delitsya(b, x3)) {
                sum++;
            }
        }
        return sum == 2;
    }

    static boolean delimost5(long x1, long x2, long x3, long b) {
        int sum = 0;
        if (delitsya(b, x1)) {
            sum++;
        }
        boolean bChet = (b & 1) == 0;
        if (bChet) {
            if (delitsya(b, x2)) {
                sum++;
            }
        }
        if (sum == 0) {
            return false;
        }
        if (delitsya(b, x3)) {
            sum++;
        }
        return sum == 2;
    }

    static boolean delimost6(long x1, long x2, long x3, long b) {
        int sum = 0;
        if (delitsya(b, x1)) {
            sum++;
        }
        if (delitsya(b, x2)) {
           sum++;
        }
        if (sum == 0) {
            return false;
        }
        boolean bChet = (b & 1) == 0;
        if (bChet) {
            if (delitsya(b, x3)) {
                sum++;
            }
        }
        return sum == 2;
    }

    static boolean delimost7(long x1, long x2, long x3, long b) {
        int sum = 0;
        if (delitsya(b, x1)) {
            sum++;
        }
        boolean bChet = (b & 1) == 0;
        if (bChet) {
            if (delitsya(b, x2)) {
                sum++;
            }
        }
        if (sum == 0) {
            return false;
        }
        if (bChet) {
            if (delitsya(b, x3)) {
                sum++;
            }
        }
        return sum == 2;
    }

    static boolean delimost8(long x1, long x2, long x3, long b) {
        int sum = 0;
        boolean bChet = (b & 1) == 0;
        if (bChet) {
            if (delitsya(b, x1)) {
                sum++;
            }
            if (delitsya(b, x2)) {
                sum++;
            }
            if (sum == 0) {
                return false;
            }
            if (delitsya(b, x3)) {
                sum++;
            }
        }
        return sum == 2;
    }

    static boolean delitsya(long b, long x) {
        /*if (x == 2) {
            return (b & 1) == 0;
        }*/
        return (b % x) == 0;
    }
}
