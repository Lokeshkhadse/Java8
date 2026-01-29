package Trees.top_view_of_binary_tree;


import java.util.*;

public class TopViewBinaryTree_another_approach {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int col;   // column (horizontal distance)

        Pair(Node node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public static List<Integer> topView(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // column -> first node data
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0)); // root at column 0

        while (!q.isEmpty()) {
            Pair p = q.poll();

            // store only first node of each column
            if (!map.containsKey(p.col)) {
                map.put(p.col, p.node.data);
            }

            if (p.node.left != null) {
                q.offer(new Pair(p.node.left, p.col - 1));
            }

            if (p.node.right != null) {
                q.offer(new Pair(p.node.right, p.col + 1));
            }
        }

        // collect answer from leftmost column to rightmost
        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \     \
            4   5     6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        List<Integer> ans = topView(root);
        System.out.println(ans); // [4, 2, 1, 3, 6]
    }
}
