package Trees.Iteration_Using_Stack;

import java.util.*;

public class PreOrderExample {

    // ================= NODE CLASS =================
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // ================= BUILD TREE (1 to N) =================
    public static Node buildTree(int n) {

        if (n == 0) return null;

        Node root = new Node(1);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int value = 2;

        while (value <= n) {

            Node curr = q.poll();

            // left child
            curr.left = new Node(value++);
            q.add(curr.left);

            // right child
            if (value <= n) {
                curr.right = new Node(value++);
                q.add(curr.right);
            }
        }
        return root;
    }

    // ================= PREORDER USING STACK =================
    public static List<Integer> preorder(Node node) {

        List<Integer> list = new ArrayList<>();
        if (node == null) return list;

        Stack<Node> st = new Stack<>();
        st.push(node);

        while (!st.isEmpty()) {

            Node curr = st.pop();
            list.add(curr.data);   // Root

            // push right first
            if (curr.right != null) {
                st.push(curr.right);
            }

            // push left after
            if (curr.left != null) {
                st.push(curr.left);
            }
        }
        return list;
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Node root = buildTree(100);     // auto create 1–100 nodes
        List<Integer> result = preorder(root);

        System.out.println("Preorder Traversal Output:");
        System.out.println(result);
    }
}
