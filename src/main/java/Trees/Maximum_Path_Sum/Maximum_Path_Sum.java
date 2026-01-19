package Trees.Maximum_Path_Sum;



public class Maximum_Path_Sum {
    static int maxi = 0;

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static int findMaximumPathSum(Node root){
         find(root);
         return maxi;
    }
    public static int find(Node root) {
        if (root == null) return 0;

        int leftGain = Math.max(0, find(root.left)); //if -ve value the return 0
        int rightGain = Math.max(0, find(root.right)); //if -ve value the return 0

        int currentPathSum = leftGain + rightGain + root.data;

        maxi = Math.max(maxi, currentPathSum);

        return Math.max(leftGain, rightGain) + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int sum = findMaximumPathSum(root);
        System.out.println("Maximum path sum is  = " + sum);

    }
}
