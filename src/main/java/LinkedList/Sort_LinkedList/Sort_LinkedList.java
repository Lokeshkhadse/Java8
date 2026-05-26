package LinkedList.Sort_LinkedList;


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Sort_LinkedList {

    // MAIN SORT FUNCTION
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        // STEP 1: find middle
        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        // STEP 2: sort left and right
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // STEP 3: merge
        return merge(left, right);
    }

    // FIND MIDDLE (slow-fast)
    private ListNode getMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // MERGE TWO SORTED LISTS
    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (l1 != null)
            temp.next = l1;

        if (l2 != null)
            temp.next = l2;

        return dummy.next;
    }

    public static void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        /*
            Input: 4 -> 2 -> 1 -> 3
        */

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        Sort_LinkedList obj = new Sort_LinkedList();

        ListNode sorted = obj.sortList(head);

        System.out.println("Sorted Linked List:");

        print(sorted);
    }
}