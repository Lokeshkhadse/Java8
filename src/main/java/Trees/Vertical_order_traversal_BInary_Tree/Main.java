package Trees.Vertical_order_traversal_BInary_Tree;

import java.util.*;


public class Main {

    // -------- Tree Node --------
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // -------- Tuple for BFS --------
    static class Tuple {
        TreeNode node;
        int row, col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    // -------- Vertical Traversal Logic --------
    static List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {

            Tuple t = q.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;

            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }

            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }

            map.get(col).get(row).offer(node.val);

            if (node.left != null)
                q.offer(new Tuple(node.left, row + 1, col - 1));

            if (node.right != null)
                q.offer(new Tuple(node.right, row + 1, col + 1));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }

        return result;
    }

    // -------- MAIN METHOD --------
    public static void main(String[] args) {

        /*
              3
             / \
            9  20
               / \
              15  7
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = verticalTraversal(root);

        System.out.println("Vertical Traversal Output:");
        System.out.println(ans);
    }
}
