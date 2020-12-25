public class quickSort {
    public static int partition(int arr[],int start, int end){
        int pivotEle = arr[start];
        int j = start + 1;

        for (int i = start+1; i <= end; i++) {
            if(arr[i] < pivotEle) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }

        int temp = arr[start];
        arr[start] = arr[j - 1];
        arr[j - 1] = temp;

        return j - 1;
    }

    public static void sortArray(int arr[], int start, int end) {
        if (start >= end)
            return;

        int pivotIndex = partition(arr, start, end);
        sortArray(arr, start, pivotIndex - 1);
        sortArray(arr, pivotIndex + 1, end);
    }

    public static void main(String args[]) {
        int[] arr = {40, 20, 50, 10};

        sortArray(arr,0,arr.length - 1);

        System.out.print("CASE1 RESULT: ");

        for (int ele : arr) {
            System.out.print(ele+" ");
        }

        int[] arr2 = {40, 30, 30, 20, 10, 10, 8, 6, 4, 2, 2, 2, 0};

        sortArray(arr2, 0 , arr2.length - 1);

        System.out.print("\n" + "CASE2 RESULT: ");

        for (int ele : arr2) {
            System.out.print(ele+" ");
        }

        return;
    }
}
