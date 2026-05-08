package LinkedList.Palindrome_LL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Palindrome_LinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // Approach 1 : Using ArrayList
    public static boolean palindromeList(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> ls1 = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            ls1.add(temp.val);
            temp = temp.next;
        }

        List<Integer> ls2 = new ArrayList<>(ls1);
        Collections.reverse(ls2); //IT RETURN VOID
        return ls1.equals(ls2);
    }

    //Using Stack
    public static boolean UsingStack(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode temp = head;
        Stack<Integer> st = new Stack<>();

        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
           if(temp.val != st.peek()) return false;
            st.pop();
            temp = temp.next;
        }
        return true;
    }

    //Approach3 O(n) reverse it mid half , compare and again reverse to make it original position
    public static boolean Approach3(ListNode head){
        if(head == null || head.next == null) return true;

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);
        ListNode secondHalfRestoreCopy = secondHalf;

        ListNode firsthalf = head;

        while(secondHalf != null){
            if(firsthalf.val != secondHalf.val){
                // restore original list
                slow.next = reverse(secondHalfRestoreCopy);
                return false;
            }

            firsthalf = firsthalf.next;
            secondHalf = secondHalf.next;
        }

        // restore original list
        slow.next = reverse(secondHalfRestoreCopy);

        return true;
    }

    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode front = curr.next;

            curr.next = prev;

            prev = curr;

            curr = front;
        }

        return prev;
    }
    public static void print(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }


    public static void main(String[] args) {
        // 1 -> 2 -> 2 -> 1

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Linked List:");
        print(head);

        // Approach 1
        boolean result1 = palindromeList(head);
        System.out.println("\nPalindrome Using List Approach: " + result1);


         boolean result2 = UsingStack(head);
        System.out.println("\nPalindrome Using Stack Approach: " + result2);

         boolean result3 = Approach3(head);
        System.out.println("\nPalindrome Using ReverseLink(best Approach) Approach: " + result3);

        // boolean result4 = recursionApproach(head);

    }
}