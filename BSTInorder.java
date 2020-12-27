import java.util.Stack;

class Node {
    Node left;
    Node right;
    int value;

    Node (int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BSTInorder {
    public static void recursiveInorder(Node root) {
        if(root == null)
            return;
        
        recursiveInorder(root.left);

        System.out.print(root.value + " ");

        recursiveInorder(root.right);
    }

    public static void iterativeInorder(Node root) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        Boolean check = false;

        while(true) {
            while (root.left != null && !check) {
                s.push(root);
                root = root.left;
            }

            System.out.print(root.value + " ");

            if (root.right != null) {
                root = root.right;
                check = false;
            } else {
                if(s.empty())
                    break;

                root = s.peek();
                s.pop();
                check = true;
            }
        }
    }

    public static void main(String args[]) {
        Node root = new Node(4);
        root.left = new Node(2); 
        root.right = new Node(6); 
        root.left.left = new Node(1); 
        root.left.right = new Node(3); 
        root.right.left = new Node(5); 
        root.right.right = new Node(7);
        root.right.right.right = new Node(10); 
        root.right.right.right.left = new Node(9); 
        root.right.right.right.right = new Node(12); 

        /*
                        4
                2               6
            1       3       5       7
                                        10
                                    9       12
        */

        System.out.print("Recursive: ");

        recursiveInorder(root);

        System.out.print("\n Iterative: ");

        iterativeInorder(root);
    }
}
