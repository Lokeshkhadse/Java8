package Trees.View_Of_BinaryTree;

import java.util.*;

public class Left_View {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        int row;
        TreeNode node;

        Pair(int row, TreeNode node) {
            this.row = row;
            this.node = node;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {

            Pair pair = q.poll();
            int currRowNo = pair.row;
            TreeNode temp = pair.node;

            // first node at level (leftmost because we push right first)
            if (!map.containsKey(currRowNo)) {
                map.put(currRowNo, temp.val);
            }
            if (temp.left != null)
                q.add(new Pair(currRowNo + 1, temp.left));

            if (temp.right != null)
                q.add(new Pair(currRowNo + 1, temp.right));


        }

        for (Map.Entry<Integer, Integer> mp : map.entrySet())
            list.add(mp.getValue());

        return list;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        System.out.println(rightSideView(root));
    }
}
