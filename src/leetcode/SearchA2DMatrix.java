package leetcode;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        //int[][] matrix = new int[][]{{1},{3}};
        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // сравнивать с первыми элементами каждой строки
        // найти интервал (строку) в котором находится target, если такого интервала нет, то вернуть false
        // найти внутри интервала число target.
        if (matrix[0][0] > target) {
            return false;
        }
        Integer line = null;
        // поиск интервала (строки)
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target || matrix[i][matrix[i].length - 1] == target) {
                return true;
            }
            if (matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                line = i;
                break;
            }
        }
        if (line != null) {
            // поиск внутри интервала (в строке)
            for (int j = 0; j < matrix[line].length; j++) {
                if (matrix[line][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
