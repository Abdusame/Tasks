public class exam {
    public static void main(String[] args) {
        System.out.println(zadacha9());
    }

    // Задача №9. Ответ: 30
    public static int zadacha9() {
        int[][] mas = new int[][]{
                {14, 12, 7, 8, 13},
                {17, 18, 6, 8, 10},
                {4, 16, 1, 16, 15},
                {20, 15, 19, 10, 0},
                {5, 1, 13, 17, 14}
        };
        int min, s;
        s = 0;
        min = mas[0][0];
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (mas[i][j] < min) {
                    min = mas[i][j];
                    s = s + min;
                }
            }
        }
        return s;
    }


    // Задача №8. Ответ: 12
    public static int zadacha8() {
        int x = 19364;
        int a = 0;
        int b = 1;
        int y;
        while(x > 0) {
            y = Math.floorMod(x, 10);
            if (y > 5) {
                a = a + y;
            } else {
                b = b * y;
            }
            //x = Math.floorDiv(x, 10);
            x = x / 10;
        }
        return b;
    }

    // Задача №7. Ответ: -24
    public static int zadacha7() {
        int[] b = {4, 7, 7, 8, 7, 2, -4, -2, -4, -4};
        int c = 0;
        int L;
        for (int i = 1; i <= 9; i++) {
            if (b[i - 1] < b[i]) {
                c = c - b[i-1]*2;
                L = b[i-1];
                b[i-1] = b[i];
                b[i] = L;
            }
        }
        return c;
    }

    // Задача №6. Ответ: 5
    public static double zadacha6() {
        int n = 5;
        double b = -4;
        double a;
        for (int k = 0; k <= n; k++) {
            a = b + Math.pow(k, 2);
            if (a > 0) {
                if (b < 0) {
                    b = a;
                }
            }
        }
        return b;
    }




    static int[][] massiv() {
        int[][] mas = new int[2][2];
        mas[0][0] = 1;
        mas[0][1] = 2;
        mas[1][0] = 3;
        mas[1][1] = 4;
        return mas;
    }

    static void printMassiv(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
