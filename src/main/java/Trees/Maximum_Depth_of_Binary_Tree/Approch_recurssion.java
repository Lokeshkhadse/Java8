package Trees.Maximum_Depth_of_Binary_Tree;

public class Approch_recurssion {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int maximumDepth(Node root) {

        if (root == null) return 0;

        int leftDepth  = 1 + maximumDepth(root.left);
        int rightDepth = 1 + maximumDepth(root.right);

        return Math.max(leftDepth, rightDepth);
    }


    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(6);

        int maximum_depth = maximumDepth(root);

        System.out.println("Maximum Depth = " + maximum_depth);
    }
}
