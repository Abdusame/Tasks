package leetcode;

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
