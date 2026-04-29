package LinkedList.Convert_Arr_TO_DLL_And_Operation;

import LinkedList.Convert_Arr_To_LL.Convert_Display_Length_Search;

public class DLL {
    static  class Node{
        int data;
        Node next;
        Node back;

        Node(int data,Node next,Node back){
            this.data = data;
            this.next = next;
            this.back = back;
        }
        Node(int data){
            this.data = data;
            this.next = null;
            this.back=null;
        }
    }
    public static Node convertArrToDLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;

        for(int i = 1;i<arr.length;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    // Display Forward
    public static void displayForward(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display Backward (using last node)
    public static void displayBackward(Node head){
        if(head == null) return;

        Node temp = head;

        // go to last node
        while(temp.next != null){
            temp = temp.next;
        }

        // traverse backward
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.back;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};

        Node head = convertArrToDLL(arr);

        System.out.print("Forward: ");
        displayForward(head);

        System.out.print("Backward: ");
        displayBackward(head);
    }
}
