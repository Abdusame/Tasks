package leetcode;

/**
 * 23. Merge k Sorted Lists
 * Hard
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 * */
public class MergekSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(3, new ListNode(5, new ListNode(6)));
        ListNode l3 = new ListNode(1, new ListNode(7, new ListNode(13)));
        ListNode l4 = new ListNode(10, new ListNode(11, new ListNode(12)));
        ListNode merged = mergeKLists(new ListNode[]{l1, l2, l3, l4});
        while (merged != null) {
            System.out.print(merged.val + ", ");
            merged = merged.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        // объединить все листы в один
        ListNode mergedList = lists[0];
        ListNode pointer;
        int l = 1;
        for (int i = 0; i < lists.length - 1; i++) {
            pointer = lists[i];
            while (pointer.next != null) {
                pointer = pointer.next;
                l++;
            }
            pointer.next = lists[i + 1];
            l++;
            System.out.println("circle " + i + " pointer = " + pointer.val);
        }

        pointer = lists[lists.length - 1];
        while (pointer.next != null) {
            pointer = pointer.next;
            l++;
        }
        System.out.println("l = " + l);
        // TODO отсортировать значения в объединенном листе
        ListNode p = mergedList;
        ListNode a, b, buf;
        ListNode pred = new ListNode(0, mergedList);
        for (int i = l; i >= 0; i--) {
            System.out.println();
            int k = i;
            while (k >= 0 && p != null && p.next != null) {
                System.out.println("k = " + k);
                a = p;
                b = p.next;
                System.out.println("pred = " + pred.val + ", a = " + a.val + ", b = " + b.val);
                if (a.val > b.val) {
                    // поменять местами a и b
                    if (b.next != null) {
                        a.next = b.next.next;
                    } else {
                        a.next = null;
                    }
                    b.next = a;
                    if (pred != null) {
                        pred.next = b;
                    }
                    p = a;
                } else {
                    p = p.next;
                }
                if (pred != null && pred.next != null) {
                    pred = pred.next;
                }
                k--;
            }
        }


        return mergedList;
    }
}
