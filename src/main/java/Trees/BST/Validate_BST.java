package Trees.BST;

//L < N < R
//LEFT SUBTREE < ROOT.VAL < RIGHT SUBTREE


public class Validate_BST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        // Constructing tree:
        //       5
        //      / \
        //     4   6
        //        / \
        //       3   7

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        boolean result = isValidBST(root);

        System.out.println("Is Valid BST: " + result);
    }

    public static boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean check(TreeNode node, long min, long max) {
        if (node == null)
            return true;

        if (node.val <= min || node.val >= max)
            return false;

        return check(node.left, min, node.val)
                && check(node.right, node.val, max);
    }

//    public boolean ischeck(TreeNode root){
//        if(root == null) return  true;
//
//        if(root.left != null && root.left.val >= root.val) return false;
//        if(root.right != null && root.right.val <= root.val)return false;
//
//        return ischeck(root.left) && ischeck(root.right);
//
//    }
}


