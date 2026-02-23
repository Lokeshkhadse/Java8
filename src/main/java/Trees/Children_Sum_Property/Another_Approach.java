package Trees.Children_Sum_Property;

public class Another_Approach {

    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);

        convert(root);

        System.out.println("After Conversion (Inorder):");
        print(root);
    }

    public static void convert(Node root){

        if(root == null) return;

        int child = 0;    //up to down approach

        if(root.left != null)
            child += root.left.data;

        if(root.right != null)
            child += root.right.data;

        if(child < root.data){
            if(root.left != null)
                root.left.data = root.data;
            if(root.right != null)
                root.right.data = root.data;
        }

        convert(root.left);
        convert(root.right);

        int tot = 0;         ///  down to  up approach start from here

        if(root.left != null)
            tot += root.left.data;

        if(root.right != null)
            tot += root.right.data;

        if(root.left != null || root.right != null)
            root.data = tot;
    }

    public static void print(Node root){
        if(root == null) return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }
}