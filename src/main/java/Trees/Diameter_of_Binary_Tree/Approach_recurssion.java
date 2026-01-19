package Trees.Diameter_of_Binary_Tree;

public class Approach_recurssion {
    static int maxi = 0;

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int findDiameter(Node root){
        return findMaxHeight(root);
    }
    public static int findMaxHeight(Node root){
        if(root == null) return 0;

        int lh = findMaxHeight(root.left);
        int rh = findMaxHeight(root.right);

        maxi = Math.max(maxi , lh+rh);  // update diameter

         return Math.max(lh , rh) +1;  // return height
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int diameter = findDiameter(root);
        System.out.println("Diameter of Tree = " + diameter);

    }
}
