package LinkedList.Find_Length_Loop_LL;

import java.util.Stack;

public class Length_Of_Loop {

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }
    //Approach 1 (Slow and Fast)
    public static int lengthOfLoop(Node head) {

        Node slow = head;
        Node fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return getLength(slow);
            }
        }

        return 0;
    }


    // COUNT LOOP LENGTH
    public static int getLength(Node meet) {

        Node temp = meet;
        int cnt = 1;

        while (temp.next != meet) {
            temp = temp.next;
            cnt++;
        }

        return cnt;
    }


    //Approach 2 (Using stack)
    public static int usingStack(Node head) {
        Node temp = head;
        int cnt = 0;

        Stack<Node> st = new Stack<>();

        while (temp != null) {
            while (st.contains(temp)) {
                st.pop();
                cnt++;
            }
            if (cnt > 0) return cnt;

            st.push(temp);
            temp = temp.next;
        }
        return cnt;
    }



        public static void main(String[] args) {

        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // create loop (5 -> 3)
        fifth.next = third;

        int result = lengthOfLoop(head);
        System.out.println("Loop Length: " + result);

        int result1 = usingStack(head);
        System.out.println("Loop Length: " + result1);
    }
}