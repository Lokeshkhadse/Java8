package Trees.Minimum_Path_Sum;

public class Minimum_Path_Sum {
    static int mini = Integer.MAX_VALUE;

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }

    public static int findMinimumPathSum(Node root) {
        find(root);
        return mini;
    }

    public static int find(Node root) {
        if (root == null) return 0;

        int leftGain = find(root.left);
        int rightGain = find(root.right);

        int currentPathSum = leftGain + rightGain + root.data;

        mini = Math.min(mini, currentPathSum);

        // Return minimum path sum for parent consideration
        return Math.min(leftGain, rightGain) + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);


        int sum = findMinimumPathSum(root);
        System.out.println("Minimum path sum is = " + sum);
    }
}
