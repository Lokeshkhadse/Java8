package LinkedList.Detect_Cycle;

import java.util.HashMap;
import java.util.Map;

public class Detect_Cycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

     //slow ,fast Approach
    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    //HashMap Apporach
    public static boolean hasCycle_Map(ListNode head) {

        if (head == null)
            return false;

        ListNode temp = head;
        Map<ListNode, Integer> map = new HashMap<>();

        while (temp != null) {

            if (map.containsKey(temp)) {
                return true;
            }

            map.put(temp, 1);
            temp = temp.next;
        }

        return false;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;


        fifth.next = third;  // cycle here (5 → 3)

        boolean result = hasCycle(head);
        if (result) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Found");
        }

        //Approach 2 hashMap
        boolean hashres = hasCycle_Map(head);
        if (hashres) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Found");
        }
    }
}