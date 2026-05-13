package LinkedList.Find_Middle_Element;


public class Find_Middle_Element_All_Approaches {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // -------------------------------
    // APPROACH 1: COUNT NODES (2 PASS)
    // -------------------------------
    public static ListNode middle_Approach1(ListNode head) {

        if (head == null) return null;

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;

        temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }

        return temp;
    }

    // -----------------------------------
    // APPROACH 2: SLOW & FAST POINTER
    // -----------------------------------
    public static ListNode middle_Approach2(ListNode head) {

        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // -----------------------------------
    // APPROACH 3: USING ARRAY (BRUTE FORCE)
    // -----------------------------------
    public static ListNode middle_Approach3(ListNode head) {

        if (head == null) return null;

        java.util.ArrayList<ListNode> list = new java.util.ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        return list.get(list.size() / 2);
    }

    // DISPLAY
    public static void display(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // -------------------------------
    // MAIN METHOD (PSVM)
    // -------------------------------
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Linked List:");
        display(head);

        // APPROACH 1
        ListNode mid1 = middle_Approach1(head);
        System.out.println("Middle (Count Method): " + mid1.val);

        // APPROACH 2
        ListNode mid2 = middle_Approach2(head);
        System.out.println("Middle (Slow-Fast): " + mid2.val);

        // APPROACH 3
        ListNode mid3 = middle_Approach3(head);
        System.out.println("Middle (ArrayList): " + mid3.val);
    }
}