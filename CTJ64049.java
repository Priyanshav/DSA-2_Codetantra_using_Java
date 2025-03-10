// package q64049;
import java.util.*;

class CTJ64049 {
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

    public static Node findMin(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int key){
        if(root == null) return null;

        if(key < root.data){
            root.left = delete(root.left, key);
        }
        else if(key > root.data){
            root.right = delete(root.right, key);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            Node temp = findMin(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
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
        int key = sc.nextInt();
        delete(root, key);
        InorderTraversal(root);
        sc.close();
    }
}