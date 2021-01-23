class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList {
    public void mergeCopyAndMainList(Node head) {
        while (head != null) {
            Node copyNode = new Node(head.val);
            Node nextNode = head.next;
            head.next = copyNode;
            copyNode.next = nextNode;
            head = nextNode;
        }
    }

    public void copyRandomPointer(Node head) {
        while (head != null) {
            Node copyNode = head.next;
            copyNode.random = head.random !=null ? head.random.next : null;
            head = copyNode.head;
        }
    }

    public Node getCopyListFromMainList(Node head) {
        Node copyListHead = null;
        Node copyListTail = null;

        while (head != null) {
            Node copyNode = head.next;

            head.next = copyNode.next;

            if (copyListHead == null) {
                copyListHead = copyNode;
                copyListTail = copyNode;
            } else {
                copyListTail.next = copyNode;
                copyListTail = copyListTail.next;
            }

            head = head.next;
        }

        return copyListHead;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        mergeCopyAndMainList(head);

        copyRandomPointer(head);

        return getCopyListFromMainList(head);
    }
}
