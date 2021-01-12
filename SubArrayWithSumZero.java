import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumZero {
    public static Boolean findSubArray (int[] arr) {
        int len = arr.length;
        Map<Integer, Boolean> m = new HashMap<>();
        int currSum = 0;

        for (int i = 0; i < len; i++) {
            currSum += arr[i];

            if (currSum == 0 || m.containsKey(currSum)) {
                return true;
            }

            m.put(currSum,true);
        }

        return false;
    }

    public static void main (String[] args) {
        int arr[] = {-3, 2, 3, 1, 6};

        System.out.print("Case 1: ");

        if (findSubArray(arr))
            System.out.println("Subarray with 0 sum exist");
        else
            System.out.println("Subarray with 0 sum does not exist");

        int arr1[] = {-3, 6, 2, -2, 6};

        System.out.print("Case 2: ");

        if (findSubArray(arr1))
            System.out.println("Subarray with 0 sum exist");
        else
            System.out.println("Subarray with 0 sum does not exist");
    }
}
//-3 3 5 3 9