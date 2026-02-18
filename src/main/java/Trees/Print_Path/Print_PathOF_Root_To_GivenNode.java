package Trees.Print_Path;


import java.util.ArrayList;
import java.util.List;

public class Print_PathOF_Root_To_GivenNode {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    public static List<Integer> solveFunction(Node root, int findNode) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        getpath(root,findNode,res);
        return res;
    }

    public  static boolean getpath(Node root, int findNode, List<Integer> res) {
        if(root == null){
            return false;
        }
        res.add(root.data);  //add data in res

        if(root.data == findNode) {  // mila to return true karo
            return true;
        }

        if(getpath(root.left,findNode,res) || getpath(root.right,findNode,res)){  //ek bhi true huaaa toh return true
            return true;
        }

        res.remove(res.size()-1); // agar uus path mai nhi hai to remove karo usko list se
        return false;   // mila hee nhi pura ghumke toh return false
    }


    public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);

            int findNode = 4;

            List<Integer> ans = solveFunction(root, findNode);
            System.out.println(" path is -> " + ans);

        }


}
