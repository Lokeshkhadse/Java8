package LinkedList.Convert_Arr_TO_DLL_And_Operation;

public class DLL_Insertion {

    static class Node {
        int data;
        Node next;
        Node back;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }

        Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }
    }

    // Insert at END
    public static Node insert(Node head, int data) {
        Node newNode = new Node(data);

        // if list empty
        if (head == null) {
            return newNode;
        }

        Node temp = head;

        // go to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.back = temp;

        return head;
    }

    //insert before head
    public static Node insertBeforeHead(Node head,int data){
        Node newNode = new Node(data);

        Node temp = head;

        newNode.back = null;
        newNode.next = temp;
        temp.back = newNode;


        return newNode;
    }

    //insert before Tail
    public static Node insertBeforeTail(Node head , int data){
        Node newnode = new Node(data);
        int len = Length(head);
        if(len == 1){
            Node temp = head;
            newnode.next = temp;
            temp.back = newnode;
            return newnode;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        Node prev = temp.back;
        newnode.back = prev;
        newnode.next = temp;
        prev.next = newnode;
        temp.back = newnode;

        return head;
    }

    // insert before Kth position
    public static Node insertBeforeKth(Node head, int k, int data){

        if(k <= 0){
            System.out.println("Invalid k");
            return head;
        }

        Node newNode = new Node(data);

        // insert before head (k = 1)
        if(k == 1){
            if(head != null){
                newNode.next = head;
                head.back = newNode;
            }
            return newNode;
        }

        Node temp = head;
        int cnt = 1;

        // move to kth node
        while(temp != null && cnt < k){
            temp = temp.next;
            cnt++;
        }

        // if k exceeds length
        if(temp == null){
            System.out.println("k exceeds length");
            return head;
        }

        Node prev = temp.back;

        // link new node
        newNode.next = temp;
        newNode.back = prev;

        prev.next = newNode;
        temp.back = newNode;

        return head;
    }


    // insert before given node
    public static Node insertBeforeNode(Node head, Node temp, int data){

        if(temp == null){
            System.out.println("Given node is null");
            return head;
        }

        Node newNode = new Node(data);

        // if inserting before head
        if(temp.back == null){
            newNode.next = temp;
            temp.back = newNode;
            return newNode;   // new head
        }

        Node prev = temp.back;

        // link new node
        newNode.next = temp;
        newNode.back = prev;

        prev.next = newNode;
        temp.back = newNode;

        return head;
    }

    // Display (forward + backward)
    public static void display(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        System.out.print("Forward: ");
        while (temp.next != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println(temp.data + " <-> null");

        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.back;
        }
        System.out.println("null");
    }

    //Length
    public static int Length(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        return cnt;

    }

    public static void main(String[] args) {

        Node head = null;

        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 3);
        head = insert(head, 4);

        display(head);

        //insert Before Head
        head = insertBeforeHead(head, 10);
        display(head);

        //insert before Tail
        head = insertBeforeTail(head,20);
        display(head);

        // insert before Kth node
        head = insertBeforeKth(head, 3, 99);
        display(head);

       // insert before given node (example: before 3rd node)
        head = insertBeforeNode(head, head.next.next, 77);
        display(head);

    }
}