package leetcode;

import java.util.*;

/**
 * 1995. Count Special Quadruplets
 *
 * Given a 0-indexed integer array nums, return the number of distinct quadruplets (a, b, c, d) such that:
 *
 * nums[a] + nums[b] + nums[c] == nums[d], and
 * a < b < c < d
 * */
public class CountSpecialQuadruplets {
    public static void main(String[] args) {
        CountSpecialQuadruplets c = new CountSpecialQuadruplets();
        System.out.println(c.countQuadruplets(new int[]{1,1,1,3,5}));
    }

    public int countQuadruplets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = nums.length - 1; i > 2; i--) {
            int target = nums[i];
            System.out.println("target = " + target);
            arrays.addAll(threeSumEqualsTarget(nums, i, target));
        }
        //System.out.println(arrays);
        return arrays.size();
    }

    public List<List<Integer>> threeSumEqualsTarget(int[] nums, int n, int target) {
        System.out.println("n = " + n);
        if (n < 3) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    list.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        //System.out.println(list);
        return list;
    }
}
