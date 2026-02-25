package Trees.Find_Node_And_FromThat_K_Distance_Node;

import java.util.*;

public class PrintAll_Nodes_At_K_dISTANCE {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Step 1: Store parent of each node
    public static void makeParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }
    }

    // Step 2: Find nodes at distance K
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        makeParent(root, parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (level == k)
                break;

            level++;

            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    q.offer(current.left);
                    visited.add(current.left);
                }

                if (current.right != null && !visited.contains(current.right)) {
                    q.offer(current.right);
                    visited.add(current.right);
                }

                TreeNode parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    q.offer(parent);
                    visited.add(parent);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        /*
                Tree Structure
                       3
                     /   \
                    5     1
                   / \   / \
                  6   2 0   8
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

        TreeNode target = root.left; // node 5
        int k = 2;

        List<Integer> result = distanceK(root, target, k);

        System.out.println("Nodes at distance " + k + " from target:");
        for (int val : result)
            System.out.print(val + " ");
    }
}