package LinkedList.Sort_zero_one_two_LL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Segregate_0_1_2 {


    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


    public static Node segregate(Node head) {

        List<Integer> ls = new ArrayList<>();

        Node zero = head;
        Node one = head;
        Node two = head;


        while (zero != null) {

            if (zero.data == 0) {
                ls.add(zero.data);
            }

            zero = zero.next;
        }


        while (one != null) {

            if (one.data == 1) {
                ls.add(one.data);
            }

            one = one.next;
        }


        while (two != null) {

            if (two.data == 2) {
                ls.add(two.data);
            }

            two = two.next;
        }


        Node dummy = new Node(-1);
        Node temp = dummy;

        for (int i = 0; i < ls.size(); i++) {

            temp.next = new Node(ls.get(i));
            temp = temp.next;
        }

        return dummy.next;
    }

    //take a list and sort and convert into ll
    public static Node LLSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        List<Integer>ls = new ArrayList<>();
        Node temp = head;

        while(temp != null){
            ls.add(temp.data);
            temp = temp.next;
        }
        Collections.sort(ls);

        Node dummy = new Node(-1);
        Node start = dummy;

        for (int i = 0; i < ls.size(); i++) {

            dummy.next = new Node(ls.get(i));
            dummy = dummy.next;
        }
        return start.next;

    }

    //o(n) Approach
    public static Node BestApproach(Node head){
        if(head == null || head.next == null) return  head;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        zero.next = (oneHead.next != null)?oneHead.next : twoHead.next;
        one.next = (twoHead.next != null)?twoHead.next:null;
        two.next = null;

        return zeroHead.next;
    }

    // Print Linked List
    public static void print(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }


    public static void main(String[] args) {


        // 1 -> 2 -> 0 -> 1 -> 2 -> 0

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(0);

        System.out.println("Original List:");
        print(head);

        Node result = segregate(head);

        System.out.println("After Segregation:");
        print(result);

        //approach 2 using list and sort and convert to ll
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(0);
        head1.next.next.next = new Node(1);
        head1.next.next.next.next = new Node(2);
        head1.next.next.next.next.next = new Node(0);


        Node result1 = LLSort(head1);

        System.out.println("Second Approach:");
        print(result1);

        //approach 3 best Approach o(n) linking update
        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(0);
        head3.next.next.next = new Node(1);
        head3.next.next.next.next = new Node(2);
        head3.next.next.next.next.next = new Node(0);


        Node result3 = BestApproach(head3);

        System.out.println("Best Approach:");
        print(result1);
    }
}
