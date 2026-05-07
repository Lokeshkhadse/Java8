package LinkedList.Odd_Even_LL;

public class Odd_Even_LL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }


    // APPROACH 1: Optimal

    public static ListNode oddEvenOptimal(ListNode head) {

        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }


    // APPROACH 2: New List (Your idea)
    public static ListNode oddEvenNewList(ListNode head) {

        if (head == null) return null;

        ListNode oddtemp = head;
        ListNode eventemp = head.next;

        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;

        // odd nodes
        while (oddtemp != null) {

            newHead.next = new ListNode(oddtemp.val);
            newHead = newHead.next;

            if (oddtemp.next != null)
                oddtemp = oddtemp.next.next;
            else
                break;
        }

        // even nodes
        while (eventemp != null) {

            newHead.next = new ListNode(eventemp.val);
            newHead = newHead.next;

            if (eventemp.next != null)
                eventemp = eventemp.next.next;
            else
                break;
        }

        return dummy.next;
    }


    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // create: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        print(head);

        // -------- Optimal Approach --------
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println("\nOptimal Approach:");
        print(oddEvenOptimal(head1));

        // -------- New List Approach --------
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        System.out.println("\nNew List Approach:");
        print(oddEvenNewList(head2));
    }
}