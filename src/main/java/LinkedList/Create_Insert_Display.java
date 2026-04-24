package LinkedList;

public class Create_Insert_Display {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

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

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            System.out.println(temp.next);  // next node address present in current node (next)
            temp = temp.next;
        }

    }

    public int size() {
         int cnt = 0;
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            cnt++;
            System.out.println(temp.next);  // next node address present in current node (next)
            temp = temp.next;
        }
        return cnt;

    }
    public static void main(String[] args) {

         Create_Insert_Display obj = new Create_Insert_Display();

         obj.insert(1);
         obj.insert(2);
         obj.insert(3);

         obj.display();
        System.out.println(obj.size());
    }
}
