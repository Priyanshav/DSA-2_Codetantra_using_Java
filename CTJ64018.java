// package q64018;
import java.util.*;

public class CTJ64018 {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }


    static Scanner sc = new Scanner(System.in);
    private static Node buildTree(){
        int data = sc.nextInt();
        if(data == -1) return null;

        Node node = new Node(data);
        node.left = buildTree();
        node.right = buildTree();
        return node;
    }

    private static int countNodes(Node root){
        if(root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args){
        Node root = buildTree();
        int totalNodes = countNodes(root);
        System.out.print(totalNodes);
        sc.close();
    }
}
