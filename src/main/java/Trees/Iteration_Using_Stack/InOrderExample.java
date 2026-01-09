package Trees.Iteration_Using_Stack;

import java.util.*;

 class InOrderExample {

    static class Node {
        int data;
       Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    public static List<Integer> Inorder(Node root){
        List<Integer>list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<Node> st = new Stack<>();
        Node node = root;

        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                list.add(node.data);
                node = node.right;
            }
        }
        return list;
    }


    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> result = Inorder(root);

        System.out.println("Preorder Traversal Output:");
        System.out.println(result);
    }
}
