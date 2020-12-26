public class inplaceMergeSort {
    public static void merge(int[] arr, int start, int mid, int end) {        
        int start1 = start;
        int start2 = mid + 1;

        if (arr[mid] <= arr[start2])
            return;

        while (start1 <= mid && start2 <=end) {
            if (arr[start1] <= arr[start2]) {
                start1++;
            } else {
                int value = arr[start2];
                int i = start2;

                while(i != start1) {
                    arr[i] = arr[i-1];
                    i--;
                }

                arr[start1] = value;

                start1++;
                start2++;
                mid++;
            }
        }
    }

    public static void sortArray(int[] arr, int start, int end) {
        if (start >= end)
            return;

        int mid = start + (end - start) / 2;

        sortArray(arr,start,mid);
        sortArray(arr,mid + 1,end);

        merge(arr,start,mid,end);

        return;
    }

    public static void main(String args[]) {
        int[] arr = {40, 20, 50, 10};
        int size = arr.length;

        sortArray(arr,0,size-1);

        System.out.print("CASE1 RESULT: ");

        for (int ele : arr) {
            System.out.print(ele+" ");
        }

        int[] arr2 = {40, 30, 30, 20, 10, 10, 8, 6, 4, 2, 2, 2, 0};
        int size2 = arr2.length;

        sortArray(arr2,0,size2-1);

        System.out.print("\n" + "CASE2 RESULT: ");

        for (int ele : arr2) {
            System.out.print(ele+" ");
        }

        return;
    }
}
