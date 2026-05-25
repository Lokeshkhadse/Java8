package LinkedList.Flattening_LL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Rec_Flattenign_LL {
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int x) {
            data = x;
            next = null;
            bottom = null;
        }
    }


    // Recursive
    public Node flatten(Node head) {

        if (head == null || head.next == null)
            return head;

        Node mergeHead = flatten(head.next);

        return merge(head,mergeHead);

    }

    public Node merge(Node head1, Node head2) {

        Node dummy = new Node(-1);
        Node temp = dummy;

        while (head1 != null && head2 != null) {

            if (head1.data < head2.data) {
                temp.bottom = head1;
                head1 = head1.bottom;
            } else {
                temp.bottom = head2;
                head2 = head2.bottom;
            }

            temp = temp.bottom;
        }

        if (head1 != null)
            temp.bottom = head1;

        if (head2 != null)
            temp.bottom = head2;

        return dummy.bottom;
    }



    public static void print(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
    }

    public static void main(String[] args) {

        /*
                5 -> 10 -> 19 -> 28
                |     |      |      |
                7     20     22     35
                |            |      |
                8            50     40
                |
                30
        */

        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);

        Node result = new Rec_Flattenign_LL().flatten(head);

        System.out.println("Flattened Linked List using Recursion:");

        print(result);
    }
}
