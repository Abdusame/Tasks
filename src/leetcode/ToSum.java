package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ToSum {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(result[0] + ", " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int f = target - nums[i];
            if (map.containsKey(f) && map.get(f) != i) {
                return new int[]{i, map.get(f)};
            }
        }
        throw new IllegalArgumentException("asdf");
    }
}
