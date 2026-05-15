package LinkedList.Delete_Duplicates_Sorted_LinkedList;

public class Delete_Duplicates_Sorted_DLL {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    //Approach 1
    public static Node deleteDuplicates(Node head){
        if(head == null || head.next == null) return head;
        Node temp = head.next;
        Node prev = head;

        while(temp != null){
            if(prev.data != temp.data){
                prev.next = temp;
                temp.prev = prev;
                prev = temp;
            }
            temp = temp.next;
        }
        prev.next = null; // important to cut leftover links
        return head;
    }

    // APPROACH 2: Single Pointer (Optimized)
    public static Node deleteDuplicates2(Node head) {

        Node curr = head;

        while (curr != null && curr.next != null) {

            if (curr.data == curr.next.data) {

                // remove duplicate node
                Node dup = curr.next;

                curr.next = dup.next;

                // fix prev pointer (IMPORTANT in DLL)
                if (dup.next != null) {
                    dup.next.prev = curr;
                }

            } else {
                curr = curr.next;
            }
        }


        return head;
    }
    public static void printList(Node head) {

        Node temp = head;

        System.out.print("DLL: ");

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

        // Creating DLL: 1 <-> 1 <-> 2 <-> 3 <-> 3

        Node head = new Node(1);

        head.next = new Node(1);
        head.next.prev = head;

        head.next.next = new Node(2);
        head.next.next.prev = head.next;

        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;

        head.next.next.next.next = new Node(3);
        head.next.next.next.next.prev = head.next.next.next;


         head = deleteDuplicates(head);
        printList(head);
    }


}
