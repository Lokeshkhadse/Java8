package Trees.BST.Search;

public class Boolean_Approach {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static boolean search(TreeNode root, int key) {

        // base case
        if (root == null)
            return false;

        if (root.val == key)
            return true;

        if (key < root.val)
            return search(root.left, key);

        return search(root.right, key);
    }


    public static void main(String[] args) {

        // BST
        //       50
        //      /  \
        //    30    70
        //   / \    / \
        // 20 40  60 80

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        int key = 60;

        boolean found = search(root, key);

        System.out.println("Found: " + found);
    }
}
