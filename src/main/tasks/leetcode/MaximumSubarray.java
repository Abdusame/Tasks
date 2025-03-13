package tasks.leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * */
public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.countSum(nums, 3, 6));
    }

    public int maxSubArray(int[] nums) {
        int ind1 = 0;
        int ind2 = nums.length - 1;
        int max = Integer.MIN_VALUE;
        int sum = max;
        while (ind1 <= ind2) {
            if (nums[ind1] < 0) {
                ind1++;
            }
            if (nums[ind2] < 0) {
                ind2--;
            }
            sum = countSum(nums, ind1, ind2);
            // TODO
        }
        return 0;
    }

    private int countSum(int[] nums, int ind1, int ind2) {
        int sum = 0;
        for (int i = ind1; i <= ind2; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }
}
