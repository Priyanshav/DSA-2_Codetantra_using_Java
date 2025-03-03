// package q64026;
import java.util.*;

class CTJ64026 {
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

    public static int countHeight(Node root){
        if(root == null) return 0;

        int leftHeight = countHeight(root.left);
        int rightHeight = countHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
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

        int Height = countHeight(root);
        System.out.print(Height);
        sc.close();
    }
}
