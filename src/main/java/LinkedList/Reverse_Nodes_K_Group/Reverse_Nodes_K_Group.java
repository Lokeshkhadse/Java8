package LinkedList.Reverse_Nodes_K_Group;

public class Reverse_Nodes_K_Group {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;

        while (temp != null) {

            ListNode kthNode = findKthNode(temp, k);

            // less than k nodes remaining
            if (kthNode == null) {

                if (prevNode != null) {
                    prevNode.next = temp;
                }

                break;
            }

            // store next group
            nextNode = kthNode.next;

            // break connection
            kthNode.next = null;

            // reverse current group
            ListNode reversedHead = reverseLL(temp);

            // first group
            if (head == temp) {
                head = reversedHead;
            } else {
                prevNode.next = reversedHead;
            }

            // connect reversed group tail to next group
            temp.next = nextNode;

            // move prevNode
            prevNode = temp;

            // move temp to next group
            temp = nextNode;
        }

        return head;
    }

    // Find kth node
    public static ListNode findKthNode(ListNode temp, int k) {

        while (temp != null && k > 1) {
            temp = temp.next;
            k--;
        }

        return temp;
    }

    // Reverse Linked List
    public static ListNode reverseLL(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Display Linked List
    public static void display(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Main Method
    public static void main(String[] args) {

        // Creating Linked List
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println("Original Linked List:");
        display(head);

        int k = 3;

        head = reverseKGroup(head, k);

        System.out.println("\nAfter Reversing in K Group:");
        display(head);
    }
}
