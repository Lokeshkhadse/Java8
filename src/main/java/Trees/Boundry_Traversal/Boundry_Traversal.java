package Trees.Boundry_Traversal;


import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class Boundry_Traversal {
    public static void main(String[] args) {

        // ===== BUILD TREE =====
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        // ===== BOUNDARY TRAVERSAL =====
        ArrayList<Integer> ans = boundaryTraversal(root);

        System.out.println(ans);   // [1, 2, 4, 8, 9, 6, 7, 3]
    }

    // ================= SOLUTION =================

    static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.data);

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // LEFT BOUNDARY
    static void addLeftBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.data);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    // LEAF NODES
    static void addLeaves(Node root, ArrayList<Integer> res) {
        if (root == null) return;

        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    // RIGHT BOUNDARY (reverse)
    static void addRightBoundary(Node root, ArrayList<Integer> res) {
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }
}
