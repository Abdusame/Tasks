package tasks.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 4. Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Медиана массива - это такое значение, которое после сортировки массива A[1...n]  будет равно:
 * элементу A[n / 2 + 1], при нечетном n и (A[n / 2] + A[n / 2 + 1]) / 2.0, при четном n
 * */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        int[] num1 = new int[]{1,2,3,6,9};
        int[] num2 = new int[]{4,7};
        System.out.println(m.findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1length = nums1.length;
        int nums2length = nums2.length;
        int[] merged = new int[nums1length + nums2length];

        int nums1Position, nums2Position, mergedPosition;
        nums1Position = nums2Position = mergedPosition = 0;

        while(nums1Position < nums1length && nums2Position < nums2length && mergedPosition <= merged.length/2) {
            if (nums1[nums1Position] < nums2[nums2Position]) {
                merged[mergedPosition++] = nums1[nums1Position++];
            } else {
                merged[mergedPosition++] = nums2[nums2Position++];
            }
        }

        while (nums1Position < nums1length && mergedPosition <= merged.length/2) {
            merged[mergedPosition++] = nums1[nums1Position++];
        }

        while (nums2Position < nums2length && mergedPosition <= merged.length/2) {
            merged[mergedPosition++] = nums2[nums2Position++];
        }
        double median;
        int m = merged.length;
        if (m % 2 == 0) { // четный размер массива
            median = (merged[m / 2 - 1] + merged[m / 2 - 1 + 1]) / 2.0;
        } else { // нечетный
            median = merged[(m / 2 - 1) + 1];
        }
        return median;
    }

    public double findMedianSortedArrays_slow(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        double median;
        for (int value : nums1) {
            list.add(value);
        }
        for (int value : nums2) {
            list.add(value);
        }
        Collections.sort(list);
        int m = list.size();
        if (m % 2 == 0) { // четный размер массива
            median = (list.get(m / 2 - 1) + list.get(m / 2 - 1 + 1)) / 2.0;
        } else { // нечетный
            median = list.get((m / 2 - 1) + 1);
        }
        return median;
    }
}
