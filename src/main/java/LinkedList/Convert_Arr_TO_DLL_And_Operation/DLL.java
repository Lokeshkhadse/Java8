package LinkedList.Convert_Arr_TO_DLL_And_Operation;


public class DLL {
    static class Node {
        int data;
        Node next;
        Node back;

        Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    public static Node convertArrToDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    // Single function to display both forward and backward
    public static void display(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        System.out.print("Forward: ");
        // Forward traversal
        while (temp.next != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println(temp.data + " <-> null");

        System.out.print("Backward: ");
        // Backward traversal from last node
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.back;
        }
        System.out.println("null");
    }

    //length
    public static int Length(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;

    }

    //delete head
    public static Node DeleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        head = head.next;

        temp.next = null;
        head.back = null;

        return head;
    }

    //delete tail
    public static Node DeleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        Node prev = null;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
        temp.back = null;

        return head;
    }

    //delete Kth position
    public static Node Delete_Kth_Position(Node head, int k) {

        if (head == null) {
            return null;
        }

        int len = Length(head);
        if (k > len || k <= 0) {
            System.out.println("Invalid k");
            return head;
        }

        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt = cnt + 1;
            if (cnt == k) {
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.back;
        Node next = temp.next;

        if (prev == null && next == null) {  // single element
            return null;
        } else if (prev == null) { //head position
            return DeleteHead(head);
        } else if (next == null) {  //tail position
            return DeleteTail(head);
        } else {                    //middle node
            prev.next = next;
            next.back = prev;
        }
        return head;
    }

    //Delete Node
    public static void Delete_Node(Node temp){
        if(temp == null) return;

        Node prev = temp.back;
        Node next = temp.next;

        if(next == null){   //temp is last node
            prev.next = null;
            temp.back = null;
            return;
        }

        prev.next = next;    //middle node
        next.back = prev;

        temp.next = null;
        temp.back = null;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

        Node head = convertArrToDLL(arr);
        System.out.println("converted arr to dll");
        display(head);

// length
        int length = Length(head);
        System.out.println("length is ->" + length);

// delete head
        head = DeleteHead(head);
        System.out.println("delete head");
        display(head);

// delete tail
        head = DeleteTail(head);
        System.out.println("delete tail");
        display(head);

// delete k-th position
        head = Delete_Kth_Position(head, 3);
        System.out.println("Delete_Kth_position ");
        display(head);

// delete Node
        System.out.println("Delete Node ");
        Delete_Node(head.next);   // delete 2nd node
        display(head);
    }
}
