// package q64048;
import java.util.*;

class CTJ64048 {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node buildTree(Node root, int data){
        if(root == null){
            return new Node(data);
        }

        if(data < root.data){
            root.left = buildTree(root.left, data);
        }
        else if(data > root.data){
            root.right = buildTree(root.right, data);
        }
        return root;
    }

    public static void InorderTraversal(Node root){
        if(root == null) return;

        InorderTraversal(root.left);
        System.out.print(root.data + " ");
        InorderTraversal(root.right);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N<=0){
            System.out.print("Invalid no of nodes");
            sc.close();
            return;
        }

        Node root = null;
        for(int i=0;i<N;i++){
            int value = sc.nextInt();
            root = buildTree(root, value);
        }
        InorderTraversal(root);
        sc.close();
    }
}