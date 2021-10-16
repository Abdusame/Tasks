package leetcode;

/**
 * 88. Merge Sorted Array
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements
 * that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] nums1 = new int[]{2,0};
        int[] nums2 = new int[]{1};
        int m = nums1.length - nums2.length;
        int n = nums2.length;
        mergeSortedArray.merge(nums1, m, nums2, n);
        for (int value : nums1) {
            System.out.print(value + ",");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1position = m - 1;
        int nums2position = n - 1;
        int finished = nums1.length - 1;
        while (nums2position >= 0 && nums1position >= 0) {
            System.out.println("-");
            if (nums1[nums1position] > nums2[nums2position]) {
                nums1[finished--] = nums1[nums1position--];
            } else {
                nums1[finished--] = nums2[nums2position--];
            }
        }
        while (nums2position >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[nums2position--];
        }
    }

    public void merge_old(int[] nums1, int m, int[] nums2, int n) {
        int nums1position = 0;
        int nums2position = 0;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        } else if (nums1.length > 0 && nums2.length > 0 && nums1[m-1] < nums2[0]) {
            //System.out.println("-");
            System.arraycopy(nums2, 0, nums1, m, nums2.length);
        } else {
            //int counter = 0;
            while (nums1position < nums1.length && nums2position < n) {
                //System.out.println("цикл " + counter);
                //System.out.println("nums1position = " + nums1position + "; nums2position = " + nums2position);
                if (nums1[nums1position] > nums2[nums2position]) {
                    // TODO сдвинуть элементы массива nums1 на одну позицию вправо начиная с nums1position
                    for (int i = nums1.length - 1; i > nums1position; i--) {
                        nums1[i] = nums1[i - 1];
                    }
                    /*System.out.println();
                    for (int i = 0; i < nums1.length; i++) {
                        System.out.print(nums1[i] + ",");
                    }
                    System.out.println();*/
                    nums1[nums1position++] = nums2[nums2position++];
                //} else if (nums1position > m) {
                } else if (nums1[nums1position] == 0 && nums1position > m) {
                    nums1[nums1position++] = nums2[nums2position++];
                } else {
                    nums1position++;
                }
                //counter++;
            }
            /*System.arraycopy(nums2, nums2position, nums1, nums2.length - nums2position + m + 1,
             nums2.length - nums2position);*/
        }
    }
}
