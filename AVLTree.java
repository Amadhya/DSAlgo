class Node {
    int value;
    Node left;
    Node right;
    int height;

    public Node (int value, int height) {
        this.value = value;
        this.height = height;
        this.left = null;
        this.right = null;
    }
};

/*

     y                               x
    / \     Right Rotation          /  \
   x   T3   - - - - - - - >        T1   y
  / \       < - - - - - - -            / \
 T1  T2     Left Rotation            T2  T3

    10
      \
      20 -2
        \
        30 -1
          \
          40 0

*/

public class AVLTree {
    public static int getHeight(Node node) {
        if (node == null)   return 0;

        return node.height;
    }

    public static Node leftRotate(Node root) {
        if (root == null)   return null;

        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        newRoot.height = Integer.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        root.height = Integer.max(getHeight(root.left), getHeight(root.right)) + 1;

        return newRoot;
    }

    public static Node rightRotate(Node root) {
        if (root == null)   return null;

        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        newRoot.height = Integer.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        root.height = Integer.max(getHeight(root.left), getHeight(root.right)) + 1;

        return newRoot;
    }

    public static Node insert (Node root, int value) {
        if (root == null) {
            return new Node(value,1);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int heightDiff = leftHeight - rightHeight;

        root.height = Integer.max(leftHeight, rightHeight) + 1;

//        RIGHT LEFT
        if (heightDiff < -1 && root.right.value > value) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

//        RIGHT RIGHT
        if (heightDiff < -1 && root.right.value < value) {
            return leftRotate(root);
        }

//        LEFT RIGHT
        if (heightDiff > 1 && root.left.value < value) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

//        LEFT LEFT
        if (heightDiff > 1 && root.left.value > value) {
            return rightRotate(root);
        }

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null)   return;

        System.out.println("{ value: " + root.value + ", height: " + root.height + " }");

        preOrder(root.left);
        preOrder(root.right);
    }

    public static void print(Node root) {
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");

        preOrder(root);
    }

    public static void main (String[] args) {
        Node root = new Node(10, 0);

        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        print(root);
//      30 20 10 25 40 50
    }
}
