package yandex_championship_2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Решение частично верное. 2 балла из 3 дали.
 * После окончания соревнование нашел ошибку и исправил.
 * */
public class Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String str = r.readLine();

        String[] strs = str.split("[ ]+");
        int n  = Integer.parseInt(strs[0].trim());
        int m  = Integer.parseInt(strs[1].trim());

        long[][] matrix = new long[n][m];

        long k = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = k++;
            }
        }

        System.out.println(n);
        System.out.println(m);

        System.out.println(Arrays.deepToString(matrix));

        // складываем матрицу пополам

        int matrixSize = n*m;

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                set.add(matrix[i][j]);
            }
        }

        while (matrixSize > 1) {
            if (n < m) {
                // складываем по стороне m, т. е. по вертикали
                long[][] buffer = new long[n][m / 2];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m / 2; j++) {
                        buffer[i][j] = matrix[i][j] + matrix[i][m - 1 - j];
                        set.add(buffer[i][j]);
                    }
                }
                System.out.println(Arrays.deepToString(buffer));
                m = m / 2;
                matrixSize = n * m;
                System.out.println("matrixSize = " + matrixSize);
                matrix = buffer;

            } else {
                // складываем по стороне n, т. е. по горизонтали
                long[][] buffer = new long[n / 2][m];
                for (int i = 0; i < n / 2; i++) {
                    for (int j = 0; j < m; j++) {
                        buffer[i][j] = matrix[i][j] + matrix[n - 1 - i][j];
                        set.add(buffer[i][j]);
                    }
                }
                System.out.println(Arrays.deepToString(buffer));
                n = n / 2;
                matrixSize = n * m;
                System.out.println("matrixSize = " + matrixSize);
                matrix = buffer;
            }
        }
        System.out.println(set);
        System.out.println(set.size());
    }
}
