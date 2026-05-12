package LinkedList.Add_One_Number_LL;

import LinkedList.Reverse_LL.Reverse_LL;

import java.util.*;

public class Add_One_Number_LL {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static Node addOne(Node head) {   //O(N^2)

        if (head == null)
            return null;

        Node temp = head;
        List<Integer> ls = new ArrayList<>();

        String s = "";

        while (temp != null) {
            s = s + String.valueOf(temp.data);
            temp = temp.next;
        }

        int total = Integer.parseInt(s) + 1;

        while (total != 0) {
            int no = total % 10;
            ls.add(no);
            total = total / 10;
        }

        Collections.reverse(ls);

        head = null;

        for (int i = 0; i < ls.size(); i++) {

            Node newnode = new Node(ls.get(i));

            if (head == null) {
                head = newnode;
                continue;
            }

            temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newnode;
        }

        return head;
    }


      // APPROACH O(3N)
    public static Node addOne_Another_Approach(Node head) {

        if (head == null) return null;
         head = reverseLL(head);
         Node temp = head;
         int carry = 1;

         while(temp!=null){
             temp.data= temp.data + carry;
             if(temp.data < 10){
                 carry = 0;
                 break;
             }else {
                 temp.data = 0 ;
                 carry = 0;
             }
             temp = temp .next;
         }

         if(carry == 1){
             Node newnode = new Node(carry);
             head = reverseLL(head);
             newnode.next = head;
             head = newnode;
         }

         head = reverseLL(head);
         return  head;



    }
    public static Node reverseLL(Node head){
        if(head == null ){
            return null;
        }
        if(head.next == null){
            return head;
        }
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;

            //update Node
            prev = curr;
            curr = next;
        }

        return prev;
    }


    // RECURSION + HELPER FUNCTION APPROACH  O(N)
    public static Node addOne_Recursion(Node head){
        int carry = helper(head);
        if(carry == 1){
            Node newnode = new Node(1);
            newnode.next = head;
            head= newnode;
        }
        return  head;
    }

    public static int helper(Node temp){
        if(temp == null){
            return 1;
        }
         int carry = helper(temp.next);

        temp.data = temp.data + carry;

        if(temp.data < 10){
            return 0;
        }

        temp.data = 0;
        return 1;
    }
    public static void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(9);

        System.out.println("Original Linked List:");
        display(head);

        head = addOne(head);

        System.out.println("\nAfter Adding One:");
        display(head);


        System.out.println();
        System.out.println("Best Approach result:");
        head = addOne_Another_Approach(head);
        display(head);



        System.out.println();
        System.out.println("Recursion Approach Result:");
        head = addOne_Recursion(head);
        display(head);
    }
}