package Trees.top_view_of_binary_tree;

import java.util.*;

public class top_view {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;

        }

    }
    public static List<Integer> topview(Node root){
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;

        downtoleft(root, ls);
        topdownright(root.right,ls);

        return ls;

    }
    public static void downtoleft(Node root, List<Integer>list){
        Stack<Node> st = new Stack<>();

        while(root != null){
            st.push(root);
            root = root.left;
        }

        while(!st.isEmpty()){
            list.add(st.pop().data);
        }

    }

    public static void topdownright(Node root, List<Integer>list){
        while(root != null){
            list.add(root.data);
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);


        List<Integer> list = topview(root);
        System.out.println(list);
    }
}
