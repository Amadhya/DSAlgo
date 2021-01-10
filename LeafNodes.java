import java.util.Arrays;

public class LeafNodes {
    public static int findIndex(int[] arr, int start, int end, int ele) {
        int rootIndex = -1;

        for (int i = start; i <= end; i++) {
            if (arr[i] == ele) {
                rootIndex = i;
                break;
            }
        }

        return rootIndex;
    }

    public static void traverse(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, int size) {
        if (inStart > inEnd || preStart < 0 || preEnd >= size)  return;

        if (inStart == inEnd) {
            System.out.print(inOrder[inStart] + " ");

            return;
        }

        int rootEle = preOrder[preStart];
        int rootIndex = findIndex(inOrder,inStart,inEnd,rootEle);
        int leftEle = rootIndex - inStart;
        int rightEle = inEnd - rootIndex;

        traverse(preOrder,preStart + 1,preStart + leftEle, inOrder, inStart, rootIndex - 1,size);
        traverse(preOrder, preEnd - rightEle, preEnd, inOrder, rootIndex + 1, inEnd,size);
    }

    public static void findLeafNodes(int[] preOrder, int n) {
        int[] inOrder = new int[n];

        for (int i = 0; i < n; i++) {
            inOrder[i] = preOrder[i];
        }

        Arrays.sort(inOrder);

        traverse(preOrder,0,n - 1,inOrder,0,n - 1,n);
    }
    public static void main(String args[]) {
        int preOrder[] = { 890, 325, 290, 530, 965 }; 
        int n = preOrder.length; 
      
        System.out.print("Leaf nodes: ");

        findLeafNodes(preOrder, n); 

        return;
    }
}
