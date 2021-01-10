import java.util.HashMap;
import java.util.Map;

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

public class PairSumBST {
    public static Boolean traverse(Node root, int sum, Map<Integer,Boolean> m) {
        if (root == null)   return false;

        Boolean left = traverse(root.left, sum, m);

        if (left)   return true;

        int ele = sum - root.value;

        if (m.containsKey(ele)) {
            return true;
        }

        m.put(root.value, true);

        return traverse(root.right, sum, m);
    }

    public static Boolean findPairSum(Node root, int sum) {
        if (root == null)   return false;

        Map<Integer,Boolean> m = new HashMap<Integer,Boolean>();
        
        return traverse(root,sum,m);
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

        if (findPairSum(root, 19)) {
            System.out.println("Pair Sum found"); 
        } else {
            System.out.println("Pair Sum not found"); 
        }

        System.out.print("Case 2: ");

        if (findPairSum(root, 100)) {
            System.out.println("Pair Sum foundT"); 
        } else {
            System.out.println("Pair Sum not found"); 
        }
    }
}
