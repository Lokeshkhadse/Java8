package LinkedList.Deletion_Insertion_LL;

public class Insertion_Operation {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    //insert
    public  Node insert(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return head;
        }
        Node temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    //Insert Node At Head
    public Node insertAtHead(int data){
        Node insertAtHead = new Node(data);

        Node temp = head;
        head = insertAtHead;
        head.next = temp;

        return head;

    }

    //Insert Node At Last
    public static Node insertAtLast(Node head ,int data){
        if(head == null) return new Node(data);

        Node insertAtLastNode = new Node(data);
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = insertAtLastNode;
        return head;
    }


    //Insert Node At Kth Position
    public static  Node Insert_At_Kth_position(Node head, int data, int k) {
        Node insertAtKPosition = new Node(data);
        Node temp = head;

        if(k == 1){
            head = insertAtKPosition;
            head.next = temp;
            return head;
        }
        int cnt = 0 ;
        Node prev = null;

        while(temp != null){
            cnt++;
            if(cnt == k){
                prev.next = insertAtKPosition;
                insertAtKPosition.next = temp;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }

        // Insert at end
        if(cnt + 1 == k){
            prev.next = insertAtKPosition;
        }

        return head;

    }

    //Insert Node Before x(Node) value
    public static Node Insert_Node_Before_x_Node_value(Node head, int newvalue, int x) {
        // head is null
        if(head == null) return new Node(newvalue);

        //if x value is head value so add before head
        if(head.data == x){
            Node newNode = new Node(newvalue);
            newNode.next = head;
            return newNode;
        }

        Node temp = head;
        Node prev= null;

        // find x value till traverse
        while(temp != null && temp.data != x){
            prev = temp;
            temp = temp.next;
        }

        // if x found
        if(temp != null && temp.data == x){
            Node node = new Node(newvalue);
            prev.next = node;
            node.next = temp;
        }

       return head;
    }

    // Display
    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        //insert
        Insertion_Operation obj = new Insertion_Operation();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);

        display(obj.head);

        //insert At Head
        Node head = obj.insertAtHead(5);
        display(head);

        //insert At Last
        Node Head_Of_Insert_Node_At_Last  = Insertion_Operation.insertAtLast(head,6);
        display(Head_Of_Insert_Node_At_Last);

        //insert At K-th Position
        int k = 5;
        Node Insert_At_Kth_position = Insertion_Operation.Insert_At_Kth_position(head,10,5);
        display(Insert_At_Kth_position);

        //insert At K-th Position (tail)
        Node Insert_At_Kth_position8 = Insertion_Operation.Insert_At_Kth_position(head,100,8);
        display(Insert_At_Kth_position8);


        //insert Node Before x(Node) value
        int x = 3;
        int newvalue = 15;
        Node Insert_Node_Before_x_Node_value = Insertion_Operation.Insert_Node_Before_x_Node_value(head,newvalue,x);
        display(Insert_Node_Before_x_Node_value);

        //insert node before v(node ) value so my x value is currently head value
        Node Insert_Node_Before_x_Node_value1 = Insertion_Operation.Insert_Node_Before_x_Node_value(head,20,5);
        display(Insert_Node_Before_x_Node_value1);



    }




}
