package LinkedList.Sort_zero_one_two_LL;

import java.util.ArrayList;
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
    }
}
