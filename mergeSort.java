/*
public class mergeSort {
    public static int[] merge(int[] arr1, int[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        
        if(size1 == 0)
            return arr2;
        if(size2 == 0)
            return arr1;
        
        int i = 0;
        int j = 0;
        int k = 0;
        int[] arr = new int[size1 + size2];

        while (i < size1 && j < size2) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            } else {
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < size1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < size2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }

        return arr;
    }

    public static int[] sortArray(int[] arr) {
        int size = arr.length;

        if (size <= 1)
            return arr;

        Integer size1 = size / 2;
        Integer size2 = size - size1;
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];

        for (int i = 0; i < size1; i++) {
            arr1[i] = arr[i];
        }

        for (int i = size1; i < size; i++) {
            arr2[i - size1] = arr[i];
        }

        return merge(sortArray(arr1), sortArray(arr2));
    }

    public static void main(String args[]) {
        int[] arr = {40, 20, 50, 10};

        int[] res = sortArray(arr);

        System.out.print("CASE1 RESULT: ");

        for (int ele : res) {
            System.out.print(ele+" ");
        }

        int[] arr2 = {40, 30, 30, 20, 10, 10, 8, 6, 4, 2, 2, 2, 0};

        int[] res2 = sortArray(arr2);

        System.out.print("\n" + "CASE2 RESULT: ");

        for (int ele : res2) {
            System.out.print(ele+" ");
        }

        return;
    }
}
*/

public class mergeSort {
    public static void merge(int[] arr1, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int size = end - start + 1;
        int[] arr = new int[size];

        while (i <= mid && j <= end) {
            if (arr1[i] < arr1[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            } else {
                arr[k] = arr1[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j <= end) {
            arr[k] = arr1[j];
            j++;
            k++;
        }

        for (int idx = start; idx <= end; idx++) {
            arr1[idx] = arr[idx - start];
        }

        return;
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
