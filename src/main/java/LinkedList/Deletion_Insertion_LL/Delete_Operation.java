package LinkedList.Deletion_Insertion_LL;

public class Delete_Operation {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    // Insert
    public void insert(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Remove Head
    public static Node removeHead(Node head) {
        if (head == null) return null;
        head =  head.next;
        return head;
    }

    // Remove Tail
    public static Node removeTail(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    //remove kth postion
    public static Node remove_KTH_Postion(Node head, int k){
        if(head == null) return null;

        if(k == 1){  //if k and head position same
            head = head.next;
            return head;
        }

        //if k position in the middle or tail
        int cnt = 0 ;
        Node temp = head;
        Node prev = null;

        while(temp != null){

            cnt ++;
            if(cnt == k){
                // SAFE deletion
                if(prev != null && prev.next != null){
                    prev.next = prev.next.next;
                }
              //  prev.next = prev.next.next;     or direct instead of if
                return head;

            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    //remove_Node_Base_On_Value
    public static Node remove_Node_Base_On_Value(Node head,int val){
        if(head == null) return head;
        if(head.data == val){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;

        while(temp != null){
            if(temp.data == val){
                // SAFE deletion
                if(prev != null && prev.next != null){
                    prev.next = prev.next.next;
                }
                //  prev.next = prev.next.next;     or direct instead of if
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        // value not found → no change
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

        // 🔥 CASE 1: Remove Head
        Delete_Operation obj1 = new Delete_Operation();
        obj1.insert(1);
        obj1.insert(2);
        obj1.insert(3);

        Node head1 = removeHead(obj1.head);

        System.out.print("After removeHead: ");
        display(head1);   // ✅ 2 -> 3 -> null


        // 🔥 CASE 2: Remove Tail
        Delete_Operation obj2 = new Delete_Operation();
        obj2.insert(1);
        obj2.insert(2);
        obj2.insert(3);

        Node head2 = removeTail(obj2.head);

        System.out.print("After removeTail: ");
        display(head2);   // ✅ 1 -> 2 -> null


        // 🔥 CASE 3: Remove kth position
        Delete_Operation obj3 = new Delete_Operation();
        obj3.insert(1);
        obj3.insert(2);
        obj3.insert(3);

        int k = 2;

        Node head3 = remove_KTH_Postion(obj3.head, k);

        System.out.print("After remove-Kth-Position: ");
        display(head3);

        // 🔥 CASE 4: Remove Node based on value
        Delete_Operation obj4 = new Delete_Operation();
        obj4.insert(1);
        obj4.insert(2);
        obj4.insert(3);
        obj4.insert(4);

        int val = 3;

        Node head4 = remove_Node_Base_On_Value(obj4.head,val);

        System.out.print("After remove-by-value: ");
        display(head4);
    }
}