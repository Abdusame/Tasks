package tasks.leetcode;

/**
 * 153. Find Minimum in Rotated Sorted Array
 *
 * Suppose an array of length n sorted in ascending order is
 * rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
 * results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 * */
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int []{4,5,6,7,0,1,2}));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] > nums[i+1]) {
                // нашли
                return nums[i+1];
            }
            i++;
        }
        return nums[0];
    }
}
