package leetcode;

/**
 * Binary Search
 * Easy
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 * */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(search(new int[]{2}, 1));
        System.out.println(search(new int[]{0,2}, 2));
        System.out.println(search(new int[]{2,5}, 5));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index;
        int delta;
        if (nums.length == 1) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        while (true) {
            if (nums[start] == target) {
                index = start;
                break;
            }
            if (nums[end] == target) {
                index = end;
                break;
            }
            delta = end - start;
            index = delta / 2 + start;
            if (delta == 1 && nums[index] != target) {
                return -1;
            } else if (nums[index] == target) {
                break;
            } else if (nums[index] > target) {
                // берем левую часть массива
                end = index;
            } else if (nums[index] < target) {
                // берем правую часть массива
                start = index;
            }
        }
        return index;
    }
}
