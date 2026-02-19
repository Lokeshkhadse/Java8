package Trees.Lowest_Commom_Ancestor;

public class Another_Approach {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     if(root == null || root == p || root == q){
         return root;
     }
     TreeNode left = lowestCommonAncestor(root.left,p,q);
     TreeNode right = lowestCommonAncestor(root.right,p,q);

     if(left == null){
         return right;
     } else if (right == null) {
         return left;
     }else{      //both left right and left are not null, we found
         return root;
     }

    }
    public static void main(String[] args) {

        /*
                3
               / \
              5   1
             / \ / \
            6  2 0  8
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

        TreeNode p = root.left;                  // 5
        TreeNode q = root.left.right.right;      // 4

        TreeNode ans = lowestCommonAncestor(root, p, q);

        System.out.println("LCA = " + ans.val);
    }
}
