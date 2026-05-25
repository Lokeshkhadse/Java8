package LinkedList.Merge_K_Sorted_LL;


class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Merge_K_Sorted_LL {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        ListNode head = lists[0];

        for (int i = 1; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        if (list1 != null)
            temp.next = list1;

        if (list2 != null)
            temp.next = list2;

        return dummy.next;
    }

    public static void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {

        /*
            List 1: 1 -> 4 -> 5
            List 2: 1 -> 3 -> 4
            List 3: 2 -> 6
        */

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        Merge_K_Sorted_LL obj = new Merge_K_Sorted_LL();

        ListNode result = obj.mergeKLists(lists);

        System.out.println("Merged K Sorted Linked List:");

        print(result);
    }
}