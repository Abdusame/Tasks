package leetcode;

/**
 * 33. Search in Rotated Sorted Array
 * Medium
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown
 * pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 * */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[]{1}, 0));
    }

    public static int search(int[] nums, int target) {
        if (nums[0] == target) {
            return 0;
        }
        if (nums[0] < target) {
            // поиск начинаем с начала массива
            int index = 0;
            while(index < nums.length && nums[index] <= target) {
                if (nums[index] == target) {
                    return index;
                }
                index++;
            }
        }
        //if nums[0] > target
        // поиск начинаем с конца массива
        int in = nums.length - 1;
        while(in >= 0 && nums[in] >= target) {
            if (nums[in] == target) {
                return in;
            }
            in--;
        }
        return -1;
    }
}
