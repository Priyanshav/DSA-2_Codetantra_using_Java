// package q64047;
import java.util.*;

class CTJ64047 {
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

    public static boolean search(Node root, int key){
        if(root == null) return false;

        if(root.data == key) return true;

        if(key < root.data){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
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
        if(search(root, key)){
            System.out.print("Found");
        }
        else{
            System.out.print("Not found");
        }
        sc.close();
    }
}
