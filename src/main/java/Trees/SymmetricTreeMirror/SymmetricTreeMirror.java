package Trees.SymmetricTreeMirror;

import java.util.*;

public class SymmetricTreeMirror {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        preorder(root.left, pre);
        postorder(root.right, post);

        Collections.reverse(post);

        return pre.equals(post);
    }

    static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    static void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }

        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    public static void main(String[] args) {

        /*
                Example Tree
                     1
                   /   \
                  2     2
                   \     \
                    3     3
           */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        boolean result = isSymmetric(root);
        System.out.println("Is Symmetric: " + result);
    }
}