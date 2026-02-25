package Trees.Find_Node_And_FromThat_K_Distance_Node;

import java.util.ArrayList;
import java.util.List;

public class K_Distance_Node {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }


    private static Node findNode(Node root, int targetValue) {
        if(root == null) return null;

        if(root.data == targetValue){
            return root;
        }
        Node left = findNode(root.left, targetValue);
        if (left != null) return left;

        return findNode(root.right, targetValue);
    }

    private static void printKDistance(Node root, int k) {
        if(root == null) return ;

        if(k == 0){
            System.out.println(root.data);
            return;
        }

        printKDistance(root.left,k-1);
        printKDistance(root.right,k-1);
    }



    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        int k = 2;
        int targetValue = 2;

        Node targetNode = findNode(root, targetValue);

        if (targetNode == null)
            System.out.println("Node not found");
        else {
            System.out.print("Nodes at distance " + k + " : ");
            printKDistance(targetNode, k);
        }



    }




}
