package LinkedList.Find_Common_Node_Of_Two_LL;

import java.util.*;

public class Find_Common_Node_Of_Two_LL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        Map<ListNode, Integer> map = new HashMap<>();

        while (temp1 != null) {
            map.put(temp1, 1);
            temp1 = temp1.next;
        }

        while (temp2 != null) {

            if (map.containsKey(temp2)) {
                return temp2;
            }

            temp2 = temp2.next;
        }

        return null;
    }

    public static void display(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Common Part
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // First Linked List
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // Second Linked List
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        System.out.println("First Linked List:");
        display(headA);

        System.out.println("Second Linked List:");
        display(headB);

        ListNode ans = getIntersectionNode(headA, headB);

        if (ans != null) {
            System.out.println("Intersection Node Value: " + ans.val);
        } else {
            System.out.println("No Intersection Node Found");
        }
    }
}