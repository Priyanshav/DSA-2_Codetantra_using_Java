// package q63998;
import java.util.*;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class CTJ63998{
    private static Node root = null;
    private static List<String> outputs = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.nextLine().trim();
            if(input.isEmpty()) continue;

            String[] command = input.split(" ");
            switch(command[0]){
                case "1":
                int value = Integer.parseInt(command[1]);
                root = insert(root, value);
                break;
                case "2":
                List<String> inOrder = new ArrayList<>();
                InorderTraversal(root, inOrder);
                outputs.add(inOrder.isEmpty() ? "-1" : String.join(" ", inOrder) + " ");
                break;
                case "3":
                List<String> preOrder = new ArrayList<>();
                PreorderTraversal(root, preOrder);
                outputs.add(preOrder.isEmpty() ? "-1" : String.join(" ", preOrder) + " ");
                break;
                case "4":
                List<String> postOrder = new ArrayList<>();
                PostorderTraversal(root, postOrder);
                outputs.add(postOrder.isEmpty() ? "-1" : String.join(" ", postOrder) + " ");
                break;
                case "5":
                int searchValue = Integer.parseInt(command[1]);
                outputs.add(searchValue(root, searchValue) ? "found" : "not found");
                break;
                case "6":
                for(String output : outputs){
                    System.out.println(output);
                }
                sc.close();
                return;
                default:
                System.out.println("Invalid command.");
            }
        }
    }

    private static Node insert(Node root, int value){
        if (value == -1) return root;
        if(root == null) {
            return new Node(value);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.left == null){
                node.left = new Node(value);
                break;
            }
            else{
                queue.add(node.left);
            }

            if(node.right == null){
                node.right = new Node(value);
                break;
            }
            else{
                queue.add(node.right);
            }
        }
        return root;
    }

    private static void InorderTraversal(Node root, List<String> result){
        if(root != null){
            InorderTraversal(root.left, result);
            if(root.data != -1){
                result.add(String.valueOf(root.data));
            }
            InorderTraversal(root.right, result);
        }
    }

    private static void PreorderTraversal(Node root, List<String> result){
        if(root != null){
            if(root.data != -1){
                result.add(String.valueOf(root.data));
            }
            PreorderTraversal(root.left, result);
            PreorderTraversal(root.right, result);
        }
    }

    private static void PostorderTraversal(Node root, List<String> result){
        if(root != null){
            PostorderTraversal(root.left, result);
            PostorderTraversal(root.right, result);
            if(root.data != -1){
                result.add(String.valueOf(root.data));
            }
        }
    }

    private static boolean searchValue(Node root, int value){
        if(root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.data == value){
                return true;
            }
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return false;
    }
}