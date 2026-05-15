package LinkedList.Find_Pairs_With_Given_Sum;

import java.util.ArrayList;

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

public class Find_Pairs_With_Given_Sum {


    // Approach 1 : Iterative
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(
            int target,
            Node head) {

        Node temp1 = head;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (temp1 != null) {

            Node temp2 = temp1.next;

            while (temp2 != null) {

                if (temp1.data + temp2.data == target) {

                    ArrayList<Integer> ll = new ArrayList<>();

                    ll.add(temp1.data);
                    ll.add(temp2.data);

                    ans.add(ll);
                }

                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        return ans;
    }

    // Approach 2 : Recursion
    public static ArrayList<ArrayList<Integer>>
    findPairsWithGivenSumRecursion(int target, Node head) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (head == null || head.next == null) {
            return ans;
        }

        function(head, head.next, target, ans);

        return ans;
    }

    // Recursive Function
    public static void function(Node temp1,
                                Node temp2,
                                int target,
                                ArrayList<ArrayList<Integer>> ans) {

        // Base Condition
        if (temp1 == null || temp1.next == null) {
            return;
        }

        // Move temp1 forward
        if (temp2 == null) {

            function(temp1.next,
                    temp1.next != null ? temp1.next.next : null,
                    target,
                    ans);

            return;
        }

        // Check Sum
        if (temp1.data + temp2.data == target) {

            ArrayList<Integer> pair = new ArrayList<>();

            pair.add(temp1.data);
            pair.add(temp2.data);

            ans.add(pair);
        }

        // Recursive Call
        function(temp1, temp2.next, target, ans);
    }

    // Display DLL
    public static void display(Node head) {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }


    public static void main(String[] args) {

        Node head = new Node(1);

        head.next = new Node(2);
        head.next.prev = head;

        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Doubly Linked List:");
        display(head);

        int target = 5;


        // Iterative Approach
        ArrayList<ArrayList<Integer>> ans1 =
                findPairsWithGivenSum(target, head);

        System.out.println("Iterative Approach:");
        System.out.println(ans1);


        // Recursive Approach
        ArrayList<ArrayList<Integer>> ans2 =
                findPairsWithGivenSumRecursion(target, head);

        System.out.println("Recursion Approach:");
        System.out.println(ans2);
    }
}