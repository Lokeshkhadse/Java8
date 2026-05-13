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

    // APPROACH 1 : HASHMAP APPROACH  O(N) SC O(N)
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

    // APPROACH 2 : LENGTH DIFFERENCE APPROACH  O(N+M)  SC O(1)
    public static ListNode getIntersectionNode_Another_Approach(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode t1 = headA;
        ListNode t2 = headB;

        int t1length = 0;
        int t2length = 0;

        while (t1 != null) {
            t1length++;
            t1 = t1.next;
        }

        while (t2 != null) {
            t2length++;
            t2 = t2.next;
        }

        if (t1length < t2length) {
            return check(headA, headB, t2length - t1length);
        } else {
            return check(headB, headA, t1length - t2length);
        }
    }

    public static ListNode check(ListNode smallLL, ListNode largeLL, int d) {

        while (d != 0) {
            largeLL = largeLL.next;
            d--;
        }

        while (smallLL != largeLL) {
            smallLL = smallLL.next;
            largeLL = largeLL.next;
        }

        return smallLL;
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

        // APPROACH 1
        ListNode ans1 = getIntersectionNode(headA, headB);

        if (ans1 != null) {
            System.out.println("HashMap Approach Intersection Node Value: " + ans1.val);
        } else {
            System.out.println("No Intersection Node Found");
        }

        // APPROACH 2
        ListNode ans2 = getIntersectionNode_Another_Approach(headA, headB);

        if (ans2 != null) {
            System.out.println("Length Difference Approach Intersection Node Value: " + ans2.val);
        } else {
            System.out.println("No Intersection Node Found");
        }
    }
}