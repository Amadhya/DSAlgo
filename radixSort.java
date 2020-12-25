import java.util.ArrayList;

public class radixSort {
    public static int[] buildRadixArray(int arr[], int digitsPlace) {
        ArrayList<ArrayList<Integer>> digits = new ArrayList<ArrayList<Integer>>();
        int size = arr.length;

        for (int i = 0; i < 10; i++) {
            digits.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < size; i++) {
            int digit = (arr[i] / (int) Math.pow(10, digitsPlace)) % 10;

            digits.get(digit).add(arr[i]);
        }

        int k = 0;

        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < digits.get(i).size(); j++) {
                arr[k] = digits.get(i).get(j);
                k++;
            }
        }

        return arr;
    }

    public static void sortArray(int arr[]) {
        int maxNum = 0;
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            maxNum = Math.max(maxNum,arr[i]);
        }

        int maxDigitPlace = 0;

        while(maxNum > 0) {
            maxNum /= 10;
            maxDigitPlace++;
        }

        int i = 0;

        while (i < maxDigitPlace) {
            buildRadixArray(arr,i);
            i++;
        }

        return;
    }

    public static void main(String args[]) {
        int[] arr = {10,21,17,34,44};

        sortArray(arr);

        System.out.print("CASE1 RESULT: ");

        for (int ele : arr) {
            System.out.print(ele+" ");
        }

        int[] arr2 = {40, 30, 30, 20, 10, 10, 8, 6, 4, 2, 2, 2, 0};

        sortArray(arr2);

        System.out.print("\n" + "CASE2 RESULT: ");

        for (int ele : arr2) {
            System.out.print(ele+" ");
        }

        return;
    }
}
