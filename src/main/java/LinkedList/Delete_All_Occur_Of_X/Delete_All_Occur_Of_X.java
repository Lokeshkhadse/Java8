package LinkedList.Delete_All_Occur_Of_X;

import java.util.ArrayList;
import java.util.List;

class Node {

    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Delete_All_Occur_Of_X {


    // Approach 1
    // Store in ArrayList and Rebuild DLL
    public static Node deleteAllOccurOfX(Node head, int x) {

        if (head == null) return null;

        Node temp = head;

        List<Integer> list = new ArrayList<>();


        while (temp != null) {

            if (temp.data != x) {
                list.add(temp.data);
            }

            temp = temp.next;
        }

        // Rebuild DLL
        head = null;

        for (int i = 0; i < list.size(); i++) {

            Node newNode = new Node(list.get(i));

            // First Node
            if (head == null) {
                head = newNode;
            }

            // Remaining Nodes
            else {

                temp = head;

                while (temp.next != null) {
                    temp = temp.next;
                }

                temp.next = newNode;
                newNode.prev = temp;
            }
        }

        return head;
    }

    //Approach2
    //prev curr next
    public static Node Approach2(Node head, int x){
        Node temp = head;
        while(temp != null){
            if(temp.data == x){
                if(temp == head){
                    head = head.next;
                }
                Node nextnode = temp.next;
                Node prevnode = temp.prev;

                if(nextnode != null) nextnode.prev = prevnode;
                if(prevnode != null) prevnode.next = nextnode;

                temp = nextnode;
            }else{
                temp = temp.next;
            }

        }
        return head;

    }

    public static void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }
    }


    public static void main(String[] args) {

        Node head = new Node(2);

        head.next = new Node(2);
        head.next.prev = head;

        head.next.next = new Node(10);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(8);
        head.next.next.next.prev = head.next.next;

        head.next.next.next.next = new Node(4);
        head.next.next.next.next.prev = head.next.next.next;

        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.prev =
                head.next.next.next.next.next;

        head.next.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next.prev =
                head.next.next.next.next.next.next;

        int x = 2;

        System.out.println("Original DLL:");
        display(head);

       // head = deleteAllOccurOfX(head, x);
        head = Approach2(head, x);

        System.out.println("\n\nAfter Deleting " + x + ":");
        display(head);
    }
}