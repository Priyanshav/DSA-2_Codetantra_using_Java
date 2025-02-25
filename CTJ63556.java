// package q63556;

import java.util.*;

class CTJ63556{
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
        if(data == -1) return null;

        Node node = new Node(data);
        node.left = buildTree();
        node.right = buildTree();
        return node;
    }

    public static void PostorderTraversal(Node root){
        if(root == null) return;

        PostorderTraversal(root.left);
        PostorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args){
        Node root = buildTree();
        PostorderTraversal(root);
    }
}