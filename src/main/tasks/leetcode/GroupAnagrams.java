package tasks.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 49. Group Anagrams
 * Medium
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * */
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        //System.out.println(g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        //System.out.println(g.groupAnagrams(new String[]{""}));
        //System.out.println(g.groupAnagrams(new String[]{"a"}));
        //System.out.println(g.groupAnagrams(new String[]{"",""}));
        System.out.println(g.groupAnagrams(new String[]{"ddddddddddg","dgggggggggg"}));
        //System.out.println(isAnagramSort("ddddddddddg","dgggggggggg"));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listOfLists = new ArrayList<>();
        if (strs.length == 1) {
            listOfLists.add(Arrays.asList(strs));
            return listOfLists;
        }
        List<String> originalList = new ArrayList<>(Arrays.asList(strs));
        List<String> innerList;
        String f;
        int i;
        int size = originalList.size();
        while (size > 0) {
            f = originalList.get(0);
            innerList = new ArrayList<>();
            innerList.add(f);
            originalList.remove(0);
            size = originalList.size();
            i = 0;
            while (size > 0 && i < size) {
                if (isAnagramSort(f, originalList.get(i))) {
                    innerList.add(originalList.get(i));
                    originalList.remove(i);
                } else {
                    i++;
                }
                size = originalList.size();
            }
            listOfLists.add(innerList);
        }
        return listOfLists;
    }

    public static boolean areEqual(String s1, String s2) {
        if (s1.length() == s2.length()) {
            String[] s1array = s1.split("");
            for (String s : s1array) {
                if (!s2.contains(s)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    static boolean isAnagramSort(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        char[] a1 = string1.toCharArray();
        char[] a2 = string2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}
