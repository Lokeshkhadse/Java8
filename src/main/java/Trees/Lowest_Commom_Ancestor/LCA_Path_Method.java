package Trees.Lowest_Commom_Ancestor;

import java.util.*;

public class LCA_Path_Method {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();

        getPath(root, p, list1);
        getPath(root, q, list2);

        TreeNode lca = null;

        int i = 0;
        while (i < list1.size() && i < list2.size()) {
            if (list1.get(i) == list2.get(i)) {
                lca = list1.get(i);
            } else {
                break;
            }
            i++;
        }
        return lca;
    }

    public static boolean getPath(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null) return false;

        list.add(root);

        if (root == target) return true;

        if (getPath(root.left, target, list) ||         // only one true we want here
                getPath(root.right, target, list))
            return true;

        list.remove(list.size() - 1); // backtrack
        return false;
    }

    public static void main(String[] args) {

        /*
                3
               / \
              5   1
             / \ / \
            6  2 0  8
              / \
             7   4
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;                  // 5
        TreeNode q = root.left.right.right;      // 4

        TreeNode ans = lowestCommonAncestor(root, p, q);

        System.out.println("LCA = " + ans.val);
    }
}