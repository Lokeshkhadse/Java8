package LinkedList.Reverse_LL;

import java.util.*;
import java.util.Collections;

public class Reverse_LL {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    //reverse o(1) approch
    public static ListNode reverseLL(ListNode head){
        if(head == null ){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;

            //update Node
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Reverse using List (your approach) o(n)
    public static ListNode reverseList(ListNode head) {

        ListNode temp = head;
        List<ListNode> list = new ArrayList<>();

        // store nodes
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        // reverse list
        Collections.reverse(list);

        if (list.size() == 0) return null;

        // new head
        ListNode newHead = list.get(0);
        temp = newHead;

        int i = 1;

        // reconnect nodes
        while (i < list.size()) {
            temp.next = list.get(i);
            temp = temp.next;
            i++;
        }

        temp.next = null;

        return newHead;
    }

    // Insert (helper)
    public static ListNode insert(ListNode head, int val) {
        ListNode node = new ListNode(val);

        if (head == null) return node;

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        return head;
    }

    // Display
    public static void display(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // PSVM
    public static void main(String[] args) {

        ListNode head = null;

        // build list
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);

        System.out.print("Original: ");
        display(head);

        // reverse
        head = reverseList(head);

        System.out.print("Reversed: ");
        display(head);


        //reverseLL
        ListNode head2 = null;
        head2 = insert(head2, 1);
        head2 = insert(head2, 2);
        head2 = insert(head2, 3);
        head2 = insert(head2, 4);

        head2 = reverseLL(head2);
        System.out.print("o(1) approach :");
        display(head2);
    }
}