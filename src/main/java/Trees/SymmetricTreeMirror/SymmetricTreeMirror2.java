package Trees.SymmetricTreeMirror;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SymmetricTreeMirror2 {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
       return (root == null ||  isSymmetricHelp(root.left,root.right));
    }

    public static boolean isSymmetricHelp(TreeNode left , TreeNode right){
        if(left == null  || right == null) return left == right;

        if(left.val != right.val) return false;

        return isSymmetricHelp(left.left , right.right ) && isSymmetricHelp(left.right, right.left);
    }



    public static void main(String[] args) {

        /*
                Example Tree
                     1
                   /   \
                  2     2
                   \     \
                    3     3
           */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        boolean result = isSymmetric(root);
        System.out.println("Is Symmetric: " + result);
    }
}