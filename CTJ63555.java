// package q63555;
import java.util.*;

class CTJ63555{
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static Node buildTree(){
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        Node node = new Node(data);
        node.left = buildTree();
        node.right = buildTree();
        return node;
    }

    public static void InorderTraversal(Node root){
        if(root == null){
            return;
        }
        InorderTraversal(root.left);
        System.out.print(root.data + " ");
        InorderTraversal(root.right);
    }

    public static void main(String[] args){
        Node root = buildTree();
        InorderTraversal(root);
    }
}