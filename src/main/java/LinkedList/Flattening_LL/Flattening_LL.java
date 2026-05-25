package LinkedList.Flattening_LL;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Flattening_LL {

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

    public Node flatten(Node root) {

        if (root == null)
            return null;

        List<Integer> ll = new ArrayList<>();

        Node temp = root;

        while (temp != null) {

            Node t2 = temp;

            while (t2 != null) {

                ll.add(t2.data);

                t2 = t2.bottom;
            }

            temp = temp.next;
        }

        Collections.sort(ll);

        Node head = convertIntoFlateeningLL(ll);

        return head;
    }

    public Node convertIntoFlateeningLL(List<Integer> ll) {

        if (ll.size() == 0)
            return null;

        Node head = new Node(ll.get(0));

        Node temp = head;

        for (int i = 1; i < ll.size(); i++) {

            Node newnode = new Node(ll.get(i));

            temp.bottom = newnode;

            temp = temp.bottom;
        }

        return head;
    }

    public static void printBottomList(Node head) {

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
                |                   |
                30                  45
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
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        Node result = new Flattening_LL().flatten(head);;

        System.out.println("Flatten Linked List:");

        printBottomList(result);
    }
}