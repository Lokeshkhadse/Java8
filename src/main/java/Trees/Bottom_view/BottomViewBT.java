package Trees.Bottom_view;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class BottomViewBT {

    static class Pair {
        Node node;
        int hd; // horizontal distance

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    public static void bottomView(Node root) {

        if (root == null) return;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            // overwrite value at same horizontal distance
            map.put(hd, curr.data);

            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));

            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        for (int val : map.values())
            System.out.print(val + " ");
    }

    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        bottomView(root);
    }
}
