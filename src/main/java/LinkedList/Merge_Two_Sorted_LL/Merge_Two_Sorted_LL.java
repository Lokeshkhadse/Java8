package LinkedList.Merge_Two_Sorted_LL;


public class Merge_Two_Sorted_LL {

    // ListNode class
    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode dummy = new ListNode(-1);
        ListNode p3 = dummy;

        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {

                p3.next = p1;
                p1 = p1.next;

            } else {

                p3.next = p2;
                p2 = p2.next;
            }

            p3 = p3.next;
        }

        // Attach remaining list directly  (LINKING HERE USING)
        if (p1 != null) {
            p3.next = p1;
        }

        if (p2 != null) {
            p3.next = p2;
        }

        //INSTEAD OF IF

//        while (p1 != null) {
//            p3.next = p1;
//            p1=p1.next;
//            p3 = p3.next;
//        }
//
//        while (p2 != null) {
//            p3.next = p2;
//            p2 = p2.next;
//            p3 = p3.next;
//
//        }


        return dummy.next;
    }

    // Print Linked List
    public static void printList(ListNode head) {

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

    // Main method
    public static void main(String[] args) {

        // First Linked List
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(8);
        list1.next.next.next = new ListNode(10);

        // Second Linked List
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(3);
        list2.next.next.next = new ListNode(6);
        list2.next.next.next.next = new ListNode(11);
        list2.next.next.next.next.next = new ListNode(14);

        System.out.println("List 1:");
        printList(list1);

        System.out.println("List 2:");
        printList(list2);

        // Merge lists
        ListNode result = mergeTwoLists(list1, list2);

        System.out.println("Merged Linked List:");
        printList(result);
    }
}
