package leetcode;

/**
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 *
 * Definition for singly-linked list.
 *  public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode() {}
 *      ListNode(int val) { this.val = val; }
 *      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  }
 * */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(3, new ListNode(5, new ListNode(6)));
        ListNode merged = m.mergeTwoLists(l1, l2);
        while (merged != null) {
            System.out.print(merged.val + ", ");
            merged = merged.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode merged = new ListNode();
        ListNode pos = merged;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pos.val = l1.val;
                pos.next = new ListNode();
                l1 = l1.next;
            } else {
                pos.val = l2.val;
                pos.next = new ListNode();
                l2 = l2.next;
            }
            pos = pos.next;
        }

        while (l1 != null) {
            pos.val = l1.val;
            if (l1.next != null) {
                pos.next = new ListNode();
            }
            l1 = l1.next;
            pos = pos.next;
        }

        while (l2 != null) {
            pos.val = l2.val;
            if (l2.next != null) {
                pos.next = new ListNode();
            }
            l2 = l2.next;
            pos = pos.next;
        }
        pos = null;
        return merged;
    }
}
