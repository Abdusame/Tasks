package leetcode;

/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Definition for singly-linked list.
 *  public class ListNode {
 *       int val;
 *       ListNode next;
 *       ListNode() {}
 *       ListNode(int val) { this.val = val; }
 *       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  }
 * */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5, new ListNode(6)))));
        ListNode reversed = r.reverseList(l1);
        while (reversed != null) {
            System.out.print(reversed.val + ", ");
            reversed = reversed.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pointerEnd = head;
        ListNode pointerStart = head;
        int length = 0;
        while (pointerEnd != null && pointerEnd.next != null) {
            pointerEnd = pointerEnd.next;
            length++;
        }
        ListNode first;
        ListNode end = pointerEnd;
        for (int i = 0; i < length; i++) {
            first = pointerStart;
            pointerStart = pointerStart.next;
            first.next = null;
            if (end.next != null) {
                
            } else {
                end.next = first;
            }
        }
        return pointerEnd;
    }
}
