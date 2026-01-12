package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pre_In_Post_Using_threeList_oneStack {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class pair {
        Node root;
        int num;

        pair(Node root, int num) {
            this.root = root;
            this.num = num;
        }
    }

    public static void pre_in_post_traversal(Node root) {

        Stack<pair> st = new Stack<>();
        st.push(new pair(root, 1));

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        while (!st.isEmpty()) {

            pair curr = st.pop();

            if (curr.num == 1) {
                pre.add(curr.root.data);
                curr.num++;
                st.push(curr);

                if (curr.root.left != null) {
                    st.push(new pair(curr.root.left, 1));
                }
            }

            else if (curr.num == 2) {
                in.add(curr.root.data);
                curr.num++;
                st.push(curr);

                if (curr.root.right != null) {
                    st.push(new pair(curr.root.right, 1));
                }
            }

            else {   // curr.num == 3
                post.add(curr.root.data);
            }
        }

        
        System.out.println("Preorder  : " + pre);
        System.out.println("Inorder   : " + in);
        System.out.println("Postorder : " + post);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        pre_in_post_traversal(root);
    }
}
