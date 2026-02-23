package Trees.Children_Sum_Property;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Childeren_Sum_Property {

    // function to check children sum property
    public static boolean isSumProperty(Node root) {

        // base case
        if (root == null || (root.left == null && root.right == null))
            return true;

        int left = (root.left != null) ? root.left.data : 0;
        int right = (root.right != null) ? root.right.data : 0;

        if (root.data != left + right)
            return false;

        return isSumProperty(root.left) &&
                isSumProperty(root.right);
    }

    public static void main(String[] args) {

        // Tree creation
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);

        boolean result = isSumProperty(root);

        if(result)
            System.out.println("Tree satisfies Children Sum Property");
        else
            System.out.println("Tree does NOT satisfy Children Sum Property");
    }
}