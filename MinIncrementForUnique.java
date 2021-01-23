import java.util.Arrays;

public class MinIncrementForUnique {
    public static void minIncrementForUnique(int[] arr) {
        Arrays.sort(arr);
        int minIncrements = 0;

        for(int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i-1]) {
                int newVal = arr[i - 1] + 1;

                minIncrements += newVal - arr[i];
                arr[i] = newVal;
            }
        }

        System.out.println("Minimun Increments required are " + minIncrements);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,2};
        int[] arr2 = {3,2,1,2,1,7};

        System.out.println("Case 1 -----------------------");

        minIncrementForUnique(arr1);

        System.out.println("\nCase 2 -----------------------");

        minIncrementForUnique(arr2);
    }
}
