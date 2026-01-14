package Trees.Balanced_Binary_Tree;



public class Balanced_Binary_Tree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    public static boolean isBinaryTree(Node root){
        return CheckHeight(root) != -1;
    }
    public static int CheckHeight(Node root){
        if(root == null) return 0;

        int lh = CheckHeight(root.left);
        if(lh == -1)return -1;

        int rh = CheckHeight(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh,rh)+1;
    }


    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        boolean result = isBinaryTree(root);
        System.out.println(result);
    }
}
