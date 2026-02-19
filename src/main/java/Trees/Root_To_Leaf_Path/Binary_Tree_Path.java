package Trees.Root_To_Leaf_Path;

import java.util.*;

public class Binary_Tree_Path {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    static void dfs(TreeNode node, String path, List<String> result){
        if(node == null) return;

        path += node.val;

        if(node.left == null && node.right == null){
            result.add(path);
            return;
        }

        path += "->";

        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }

    public static void main(String[] args) {



        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<String> paths = binaryTreePaths(root);

        System.out.println(paths);
    }
}
