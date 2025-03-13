package tasks.leetcode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        /*ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));*/
        ListNode head = new ListNode(1, new ListNode(2));
        for (int i = 1; i < 9; i++) {
            System.out.print("\t" + i + "\t" + "|");
        }
        System.out.println();

        ListNode head2 = swapPairs(head);

        while (head2 != null) {
            System.out.print("\t" + head2.val + "\t" + "|");
            head2 = head2.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode first = head;
        if (head != null) {
            ListNode second = head.next;
            if (second != null) {
                ListNode newHead = second;
                ListNode dop = null;
                while (true) {
                    first.next = second.next;
                    second.next = first;
                    if (dop != null) {
                        dop.next = second;
                    }
                    dop = first;
                    if (first.next != null && first.next.next != null) {
                        second = first.next.next;
                        first = first.next;
                    } else {
                        break;
                    }
                }
                return newHead;
            } else {
                return head;
            }
        } else {
            return head;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
