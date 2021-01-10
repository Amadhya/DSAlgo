import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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

public class BottomViewBST {
    public static void bottomView(Node root) {
        Map<Integer,Integer> m = new TreeMap<>();
        Queue<Node> q = new LinkedList<Node>(); 

        root.hd = 0;
        q.add(root);

        while (!q.isEmpty()) {
            root = q.peek();
            q.remove();

            Integer hd = root.hd;
            Node left = root.left;
            Node right = root.right;

            m.put(hd, root.value);

            if (left != null) {
                left.hd = hd - 1;
                q.add(left);
            }

            if (right != null) {
                right.hd = hd + 1;
                q.add(right);
            }
        }

        for (Map.Entry<Integer, Integer> it: m.entrySet()) {
            System.out.print(it.getValue() + " ");
        }
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

        System.out.println("Bottom view of the given binary tree:"); 

        bottomView(root);

        return;
    }
}
