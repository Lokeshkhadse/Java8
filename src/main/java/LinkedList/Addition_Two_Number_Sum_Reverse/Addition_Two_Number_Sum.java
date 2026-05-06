package LinkedList.Addition_Two_Number_Sum_Reverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Addition_Two_Number_Sum {
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    //Simple and best Approach
    public static ListNode addTwoNumbersBestAppraoch(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int carry = 0;

        while (temp1 != null || temp2 != null) {

            int sum = carry;

            if (temp1 != null) sum += temp1.val;
            if (temp2 != null) sum += temp2.val;

            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }

        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }

    // Your function
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Step 1: Traverse and store
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }

        // Step 2: Reverse lists
        Collections.reverse(list1);
        Collections.reverse(list2);

        // Step 3: Add numbers
        int i = list1.size() - 1;
        int j = list2.size() - 1;
        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) sum += list1.get(i--);
            if (j >= 0) sum += list2.get(j--);

            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }

    // Helper: Create Linked List from array
    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummy.next;
    }

    // Helper: Print Linked List
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // PSVM (Main Method)
    public static void main(String[] args) {

        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};

        ListNode l1 = createList(arr1);
        ListNode l2 = createList(arr2);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        printList(result);

        ListNode result1 = addTwoNumbersBestAppraoch(l1,l2);
        System.out.print("Result1: ");
        printList(result1);
    }
}