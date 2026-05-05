package LinkedList.Reverse_DLL;

import java.util.Stack;

public class Reverse_DLL {

    static class Node {
        int data;
        Node next;
        Node back;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    // Insert at end (for testing)
    public static Node insert(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.back = temp;

        return head;
    }

    // Display DLL
    public static void display(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        System.out.print("Forward: ");
        while (temp.next != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println(temp.data + " <-> null");

        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.back;
        }
        System.out.println("null");
    }

    // Reverse values only (stack method)
    public static void ReverseDLLValue(Node head) {

        Node temp = head;
        Stack<Integer> stack = new Stack<>();

        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
    }

    // Reverse DLL structure (best approach)
    public static Node ReverseDLL(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;
        Node next = null;

        while (curr != null) {

            next = curr.next;

            // swap links
            curr.next = prev;
            curr.back = next;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    
    public static void main(String[] args) {

        Node head = null;

        // create DLL
        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);
        head = insert(head, 5);

        System.out.println("Original DLL:");
        display(head);

        // Reverse values only
        ReverseDLLValue(head);
        System.out.println("\nAfter Value Reverse:");
        display(head);

        // Reverse structure
        head = ReverseDLL(head);
        System.out.println("\nAfter Structure Reverse:");
        display(head);
    }
}