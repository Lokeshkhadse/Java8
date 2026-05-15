package LinkedList.Delete_Duplicates_Sorted_LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Delete_Duplicates_Sorted_LinkedList {


    // APPROACH 1: Two Pointer (Your logic)
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode temp = head.next;

        while (temp != null) {

            if (prev.val != temp.val) {
                prev.next = temp;
                prev = temp;
            }

            temp = temp.next;
        }

        // important to cut leftover links
        prev.next = null;

        return head;
    }


    // APPROACH 2: Single Pointer (Optimized)
    public static ListNode deleteDuplicates2(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;  // here common element we are removing
            } else {
                curr = curr.next;
            }
        }

        return head;
    }


    public static void display(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {


        // 1 -> 1 -> 2 -> 3 -> 3

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        display(head);

        // APPROACH 1
        ListNode result1 = deleteDuplicates(head);
        System.out.println("After Approach 1:");
        display(result1);

        // Rebuild list for second test
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);

        // APPROACH 2
        ListNode result2 = deleteDuplicates2(head2);
        System.out.println("After Approach 2:");
        display(result2);
    }
}