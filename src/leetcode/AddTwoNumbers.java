package leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4, l13);
        ListNode l1 = new ListNode(2, l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6, l23);
        ListNode l2 = new ListNode(5, l22);

        ListNode list = addTwoNumbers(l1, l2);

        System.out.println(list.val + "" + list.next.val + "" + list.next.next.val);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        if  (l1 != null || l2 != null) {
            l1 = (l1 == null) ? new ListNode(0) : l1;
            l2 = (l2 == null) ? new ListNode(0) : l2;
            int sum = l1.val + l2.val;
            int vume = sum > 9 ? sum / 10 : 0;

            ListNode nextElement = null;

            if (l1.next != null || l2.next != null) {
                if (l2.next == null && l1.next != null) {
                    l1.next.val = l1.next.val + vume;
                    nextElement = addTwoNumbers(l1.next, l2.next);
                } else if (l1.next == null && l2.next != null) {
                    l2.next.val = l2.next.val + vume;
                    nextElement = addTwoNumbers(l1.next, l2.next);
                } else {
                    l1.next.val = l1.next.val + vume;
                    nextElement = addTwoNumbers(l1.next, l2.next);
                }
            } else {
                if (vume > 0) {
                    nextElement = new ListNode(vume);
                }
            }

            result = new ListNode(sum % 10, nextElement);
        }
        return result;
    }
}
