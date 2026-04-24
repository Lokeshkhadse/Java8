package LinkedList.Convert_Arr_To_LL;

public class Convert_Display_Length_Search {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data= data;
            next = null;
        }
    }

//convert
    public static Node convertArrToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head ;

        for(int i = 1;i< arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    //traversal
    public static void display(Node head) {
      Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
        //    System.out.println(temp.next);  // next node address present in current node (next)
            temp = temp.next;
        }
        System.out.println("null");

    }

    //length
    public static int size(Node head){
        int cnt = 0 ;
        Node temp = head;

        while(temp!= null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }

    //search
    public static boolean search(Node head, int number){
        Node temp = head;

        while(temp != null){
            if(temp.data == number){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        Node head = convertArrToLL(arr);
        System.out.println(head.data);

        display(head);

        int len = size(head);
        System.out.println("length is ->" + len);

        boolean find = search(head,2);
        System.out.println("number found -> "+find);

    }
}
