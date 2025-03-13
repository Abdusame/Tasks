package tasks.leetcode;

import java.util.*;

/**
 * FourSum
 *
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * */
public class FourSum {
    public static void main(String[] args) {
        FourSum f = new FourSum();
        System.out.println(f.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    System.out.println(sum + " = " + nums[i] + " + " + nums[j] + " + " + nums[k] + " + " + nums[l]);
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[l--]));
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
