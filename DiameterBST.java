public class DiameterBST {
    public static int height(Node root) {
        if (root == null)   return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Integer.max(left, right) + 1;
    }

    public static int calDiameter(Node root) {
        if (root == null)   return 0;

        int left = calDiameter(root.left);
        int right = calDiameter(root.right);
        int diameter = height(root.left) + height(root.right);

        return Integer.max(diameter + 1,Integer.max(left, right));
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(
            "The diameter of given binary tree is : "
            + calDiameter(root));
    }
}
