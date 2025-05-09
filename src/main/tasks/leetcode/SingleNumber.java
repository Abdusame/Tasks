package tasks.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 136. Single Number
 * Easy
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber s = new SingleNumber();
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(s.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.toArray(new Integer[0])[0];
    }
}
