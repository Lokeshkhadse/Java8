package LinkedList.Cycle_Start_Node;

import java.util.HashMap;
import java.util.Map;



public class Linked_List_Cycle_Start_Node {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Approach 1: HashMap
    public static ListNode detectCycle_HashMap(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;


        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp; // cycle starting node
            }
            map.put(temp, 1);

            temp = temp.next;
        }
        return null;
    }


    // Approach 2: Floyd (Slow + Fast)
    public static ListNode detectCycle_Floyd(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: detect meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // cycle start node
            }
        }

        return null;
    }


    public static void main(String[] args) {

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Creating cycle: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        //  HashMap approach
        ListNode result1 = detectCycle_HashMap(head);
        System.out.println("HashMap Cycle Start: " +
                (result1 != null ? result1.val : "No Cycle"));

        //  Floyd approach
        ListNode result2 = detectCycle_Floyd(head);
        System.out.println("Floyd Cycle Start: " +
                (result2 != null ? result2.val : "No Cycle"));
    }
}
