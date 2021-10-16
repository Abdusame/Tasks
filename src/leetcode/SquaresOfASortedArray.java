package leetcode;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 *
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 * */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        SquaresOfASortedArray s = new SquaresOfASortedArray();
        int[] nums = new int[]{-10000,-9999,-7,-5,0,0,10000};
        int[] result = s.sortedSquares(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }

    // my solution
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = (int) Math.pow(nums[i], 2);
            }
            return result;
        } else if (nums[nums.length-1] < 0) {
            for (int i = 0; i < nums.length; i++) {
                result[result.length - 1 - i] = (int) Math.pow(nums[i], 2);
            }
            return result;
        } else {
            int fp = 0;
            int sp;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < 0 && nums[i + 1] >= 0) {
                    fp = i;
                }
                nums[i] = (int) Math.pow(nums[i], 2);
            }
            nums[nums.length - 1] = (int) Math.pow(nums[nums.length - 1], 2);

            sp = fp + 1;

            int resIndex = 0;
            while (fp >= 0 && sp < nums.length) {
                if (nums[fp] < nums[sp]) {
                    result[resIndex++] = nums[fp--];
                } else {
                    result[resIndex++] = nums[sp++];
                }
            }
            while (fp >= 0) {
                result[resIndex++] = nums[fp--];
            }
            while (sp < nums.length) {
                result[resIndex++] = nums[sp++];
            }
            return result;
        }
    }

    // the most simple solution from litecode user
    public int[] sortedSquares_simple(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

    public int[] sortedSquares_slow(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
    }
}
