package leetcode;

/**
 * Given the head of a linked list,
 * remove the nth node from the end of the list and return its head.
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("size = " + r.getSize(list));
        System.out.println("before delete:");
        r.printList(list);

        ListNode result = r.removeNthFromEnd(list, 2);
        System.out.println("after delete:");
        r.printList(result);
    }

    private void printList(ListNode head) {
        ListNode n = head;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        int nodeFromBeginning = size - n;
        ListNode prev = null;
        ListNode l = head;
        for (int i = 0; i <= nodeFromBeginning; i++) {
            prev = l;
            l = l.next;
        }
        if (prev == null) {
            head = head.next;
            return head;
        } else {
            prev.next = prev.next.next;
            return head;
        }
    }

    public int getSize(ListNode head) {
        ListNode temp = head;
        int counter = 0;
        while (temp.next != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }
}
