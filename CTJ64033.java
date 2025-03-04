// package q64033;
import java.util.*;

public class CTJ64033 {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node buildTree(Node root, int value, char dir){
        if(root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            if(dir == 'L' && curr.left == null){
                curr.left = new Node(value);
                return root;
            }
            else if(dir == 'L'){
                queue.add(curr.left);
            }

            if(dir == 'R' && curr.right == null){
                curr.right = new Node(value);
                return root;
            }
            else if(dir == 'R'){
                queue.add(curr.right);
            }
        }
        return root;
    }

    public static int height(Node node){
        if(node == null) return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static boolean isBalanced(Node root){
        if(root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight) <=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        if(N<=0){
            System.out.print("Invalid number of nodes");
            return;
        }

        int rootValue = sc.nextInt();
        Node root = new Node(rootValue);

        for(int i=1;i<N;i++){
            int value = sc.nextInt();
            char dir = sc.next().charAt(0);
            root = buildTree(root, value, dir);
        }

        if(isBalanced(root)){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Not balanced");
        }
        sc.close();
    }
}