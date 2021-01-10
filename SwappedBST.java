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

public class SwappedBST {
    static Node first;
    static Node second;
    static Node parent;

    public static void swapNodes(Node node1, Node node2) {
        if (node1 == null || node2 == null)
            return;

        Integer temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;

        return;
    }

    public static void traverse(Node root, Node prev) {
        if (root == null)
            return;

        traverse(root.left, prev);

        if (prev != null && root.value < prev.value) {
            if (first == null) {
                first = prev;
                parent = root;
            } else {
                second = root;
            }
        }

        prev = root;

        traverse(root.right,prev);
    }

    public static void correctBST (Node root) {
        if (root == null)   return;

        first = parent = second = null;

        traverse(root,null);

        if (second == null) {
            swapNodes(first,parent);
        } else {
            swapNodes(first,second);
        }
    }

    public static void printBST(Node root) {
        if (root == null)   return;

        printBST(root.left);

        System.out.print(root.value + " ");

        printBST(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node(6); 
        root.left = new Node(10); 
        root.right = new Node(2); 
        root.left.left = new Node(1); 
        root.left.right = new Node(3); 
        root.right.right = new Node(12); 
        root.right.left = new Node(7); 

        System.out.print("Original Tree: ");
        
        printBST(root);

        correctBST(root);

        System.out.print("\n");

        System.out.print("Modified Tree: ");
        
        printBST(root);
    }
}
