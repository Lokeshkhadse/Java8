package LinkedList.Delete_Node_In_Linkedlist_237;

public class Delete_Node_In_Linkedlist_237 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void print(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.print("Before: ");
        print(head);

        // node to delete = 1
        ListNode nodeToDelete = head.next.next;

        deleteNode(nodeToDelete);

        System.out.print("After: ");
        print(head);
    }
}