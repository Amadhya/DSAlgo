class Node {
    Node left;
    Node right;
    int value;
    int hd;

    public Node (int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.hd = Integer.MAX_VALUE;
    }
}

public class IsBST {
    public static Boolean traverse (Node root, Integer min, Integer max) {
        if (root == null)   return true;

        if (root.value < min || root.value > max) {
            return false;
        }

        return traverse(root.left,min,root.value) && traverse(root.right,root.value,max);
    }

    public static Boolean checkBST (Node root) {
        if (root == null)   return true;

        return traverse(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void main(String args[]) {
        Node root = new Node(20); 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14); 

        System.out.print("Case 1: ");

        if (checkBST(root)) {
            System.out.println("Tree is BST"); 
        } else {
            System.out.println("Tree is not a BST"); 
        }

        Node root1 = new Node(4); 
        root1.left = new Node(2); 
        root1.right = new Node(5); 
        root1.left.left = new Node(1); 
        root1.left.right = new Node(3); 

        System.out.print("Case 2: ");

        if (checkBST(root1)) {
            System.out.println("Tree is BST"); 
        } else {
            System.out.println("Tree is not a BST"); 
        }

        return;
    }
}
