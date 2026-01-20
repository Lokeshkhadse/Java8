package Trees.Both_Trees_Are_Same_Or_Not;

public class SameTreeCheck {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }


    }

    // Function to check if two trees are same
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {

        // Tree 1
        TreeNode firstTree = new TreeNode(1);
        firstTree.left = new TreeNode(2);
        firstTree.right = new TreeNode(3);
        firstTree.left.left = new TreeNode(4);

        // Tree 2
        TreeNode secondTree = new TreeNode(1);
        secondTree.left = new TreeNode(2);
        secondTree.right = new TreeNode(3);
        secondTree.left.left = new TreeNode(4);



        boolean result = isSameTree(firstTree, secondTree);
        System.out.println("Are both trees same? " + result);
    }
}



// another approach
// Preorder traversal: Root -> Left -> Right

//public static void preorder(TreeNode root, List<Integer> list) {
//    if (root == null) {
//        list.add(null);   // very important to track structure
//        return;
//    }
//
//    list.add(root.val);
//    preorder(root.left, list);
//    preorder(root.right, list);
//}
//
//public static boolean isSameTreeUsingList(TreeNode p, TreeNode q) {
//
//    List<Integer> list1 = new ArrayList<>();
//    List<Integer> list2 = new ArrayList<>();
//
//    preorder(p, list1);
//    preorder(q, list2);
//
//    return list1.equals(list2); // checks both value and sequence
//}
//
//public static void main(String[] args) {
//
//    // Tree 1
//    TreeNode firstTree = new TreeNode(1);
//    firstTree.left = new TreeNode(2);
//    firstTree.right = new TreeNode(3);
//    firstTree.left.left = new TreeNode(4);
//
//    // Tree 2
//    TreeNode secondTree = new TreeNode(1);
//    secondTree.left = new TreeNode(2);
//    secondTree.right = new TreeNode(3);
//    secondTree.left.left = new TreeNode(4);
//
//    boolean result = isSameTreeUsingList(firstTree, secondTree);
//    System.out.println("Are both trees same? " + result);
//}

