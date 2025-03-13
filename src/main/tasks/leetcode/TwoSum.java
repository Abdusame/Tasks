package tasks.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 * */

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        int[] result = twoSum.twoSum(new int[]{3,2,4}, 6);
//        System.out.println(result[0] + ", " + result[1]);

        int[] result = twoSum.twoSumVersion1(new int[]{3,3}, 6);
        System.out.println(result[0] + ", " + result[1]);
    }

    // version 2
    public int[] twoSum(int[] nums, int target) {
       return new int[]{};
    }

    public int[] twoSumVersion1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        map.forEach((k, v) -> System.out.println(k + ": " + v));

        for (int i = 0; i < nums.length; i++) {
            int f = target - nums[i];
            if (map.containsKey(f) && map.get(f) != i) {
                return new int[]{i, map.get(f)};
            }
        }
        throw new IllegalArgumentException("asdf");
    }
}
