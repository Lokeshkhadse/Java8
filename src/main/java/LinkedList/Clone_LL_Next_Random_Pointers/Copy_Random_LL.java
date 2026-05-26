package LinkedList.Clone_LL_Next_Random_Pointers;

import java.util.HashMap;
import java.util.Map;

class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Copy_Random_LL {

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        Node temp = head;

        Map<Node, Node> mp = new HashMap<>();

        // STEP 1: create copy nodes
        while (temp != null) {

            Node node = new Node(temp.val);

            mp.put(temp, node);

            temp = temp.next;
        }

        // STEP 2: connect next and random
        temp = head;

        while (temp != null) {

            Node copyNode = mp.get(temp);

            copyNode.next = mp.get(temp.next);

            copyNode.random = mp.get(temp.random);

            temp = temp.next;
        }

        return mp.get(head);
    }

    // PRINT METHOD
    public static void print(Node head) {

        Node temp = head;

        while (temp != null) {

            int randomValue =
                    (temp.random != null)
                            ? temp.random.val
                            : -1;

            System.out.println(
                    "Node: " + temp.val +
                            " Random: " + randomValue
            );

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        /*
            1 -> 2 -> 3

            Random Connections:
            1.random -> 3
            2.random -> 1
            3.random -> 2
        */

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // random pointers
        head.random = head.next.next;

        head.next.random = head;

        head.next.next.random = head.next;

        Copy_Random_LL obj = new Copy_Random_LL();

        Node copiedHead = obj.copyRandomList(head);

        System.out.println("Copied Linked List:");

        print(copiedHead);
    }
}