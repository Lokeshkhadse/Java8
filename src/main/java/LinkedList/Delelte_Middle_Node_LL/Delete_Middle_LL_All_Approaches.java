package LinkedList.Delelte_Middle_Node_LL;

import java.util.*;

public class Delete_Middle_LL_All_Approaches {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // APPROACH 1: COUNT NODES (2 PASS)
    public static ListNode deleteMiddle_Count(ListNode head) {

        if (head == null || head.next == null)
            return null;

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;

        temp = head;
        ListNode prev = null;

        for (int i = 0; i < mid; i++) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;

        return head;
    }

    // APPROACH 2: SLOW & FAST POINTER (BEST)
    public static ListNode deleteMiddle_SlowFast(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;

            prev = slow;
            slow = slow.next;
        }

        prev.next = slow.next;

        return head;
    }


    // APPROACH 3: ARRAYLIST METHOD
    public static ListNode deleteMiddle_Array(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ArrayList<ListNode> list = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int mid = list.size() / 2;

        if (mid == 0) return head.next;

        ListNode prev = list.get(mid - 1);
        prev.next = list.get(mid).next;

        return head;
    }

    // DISPLAY FUNCTION
    public static void display(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        display(head);

        // APPROACH 1
        ListNode a1 = deleteMiddle_Count(clone(head));
        System.out.print("Count Method: ");
        display(a1);

        // APPROACH 2
        ListNode a2 = deleteMiddle_SlowFast(clone(head));
        System.out.print("Slow-Fast Method: ");
        display(a2);

        // APPROACH 3
        ListNode a3 = deleteMiddle_Array(clone(head));
        System.out.print("ArrayList Method: ");
        display(a3);
    }

    // Helper to clone list for fair testing
    public static ListNode clone(ListNode head) {

        if (head == null) return null;

        ListNode newHead = new ListNode(head.val);
        ListNode t1 = head.next;
        ListNode t2 = newHead;

        while (t1 != null) {
            t2.next = new ListNode(t1.val);
            t1 = t1.next;
            t2 = t2.next;
        }

        return newHead;
    }
}