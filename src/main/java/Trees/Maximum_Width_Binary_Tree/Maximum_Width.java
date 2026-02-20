package Trees.Maximum_Width_Binary_Tree;

import java.util.*;

public class Maximum_Width {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v){
            val = v;
        }
    }

    static class Pair {
        TreeNode node;
        int num;

        Pair(TreeNode n, int i){
            node = n;
            num = i;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        int ans = 0;

        while(!q.isEmpty()){

            int size = q.size();
            int mmin = q.peek().num;
            int first = 0, last = 0;

            for(int i=0;i<size;i++){

                Pair p = q.poll();

                int curr = p.num - mmin;
                TreeNode node = p.node;

                if(i==0) first = curr;
                if(i==size-1) last = curr;

                if(node.left != null)
                    q.offer(new Pair(node.left, 2*curr+1));

                if(node.right != null)
                    q.offer(new Pair(node.right, 2*curr+2));
            }

            ans = Math.max(ans, last-first+1);
        }

        return ans;
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               3   2
              /     \
             5       9
            /         \
           6           7
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println("Maximum Width = " + widthOfBinaryTree(root));
    }
}