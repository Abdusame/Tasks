package leetcode;

/**
 * Given the head of a linked list,
 * remove the nth node from the end of the list and return its head.
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList r = new RemoveNthNodeFromEndofList();
        ListNode l1 = new ListNode(11, new ListNode(22, new ListNode(33, new ListNode(44))));
        System.out.println(r.getSize(l1));
        ListNode result = r.removeNthFromEnd(l1, 2);

        while (result != null) {
            System.out.print(result.val + ", ");
            result = result.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head;
        int size = getSize(head);
        for (int i = 0; i <= size; i++) {
            if (i == n - 1) {
                // TODO удалить элемент
                l = l.next.next;
            } else {
                if (l != null) {
                    l = l.next;
                }
            }
        }
        return l;
    }

    public int getSize(ListNode l) {
        int counter = 0;
        if (l != null) {
            counter++;
            while (l.next != null) {
                l = l.next;
                counter++;
            }
        }
        return counter;
    }
}
