package Trees.BST.Search;

public class Search_BST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        // Creating BST
        //       4
        //      / \
        //     2   7
        //    / \
        //   1   3

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int searchValue = 2;

        TreeNode result = searchBST(root, searchValue);

        if (result != null)
            System.out.println("Found subtree root = " + result.val);
        else
            System.out.println("Value not found");
    }

    public static TreeNode searchBST(TreeNode root, int val) {

        if (root == null || root.val == val)
            return root;

        if (val < root.val)
            return searchBST(root.left, val);

        return searchBST(root.right, val);
    }
}