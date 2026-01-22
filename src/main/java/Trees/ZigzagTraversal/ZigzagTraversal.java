package Trees.ZigzagTraversal;

import java.util.*;

public class ZigzagTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> row = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                row.add(curr.val);   // always add normally

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            // reverse if needed
            if (!leftToRight) {
                Collections.reverse(row);
            }

            result.add(row);
            leftToRight = !leftToRight;
        }

        return result;
    }

    // PSVM
    public static void main(String[] args) {

        /*
                 3
               /   \
              9     20
                   /  \
                  15   7
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));
    }
}
