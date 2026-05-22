package LinkedList.Rotate_LL_by_k;

public class Rotate_LL_by_k {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        int length = size(head);

        k = k % length;

        if (k == 0)
            return head;

        k = length - k;

        ListNode temp = head;
        ListNode prev = null;

        int cnt = 1;

        while (temp != null) {

            if (cnt == k) {
                break;
            }

            prev = temp;
            temp = temp.next;
            cnt++;
        }

        ListNode newHead = temp;

        prev.next = null;

        ListNode tail = newHead;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = head;

        return newHead;
    }

    public static int size(ListNode head) {

        int cnt = 0;

        while (head != null) {
            cnt++;
            head = head.next;
        }

        return cnt;
    }

    public static void display(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        display(head);

        int k = 2;

        head = rotateRight(head, k);

        System.out.println("After Rotation:");
        display(head);
    }
}