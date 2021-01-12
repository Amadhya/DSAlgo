public class MaxJMinusI {
    public  static int calMaxJMinusI(int[] arr) {
        int len = arr.length;
        int[] lMin = new int[len];
        int[] rMax = new int[len];

        lMin[0] = arr[0];
        rMax[len - 1] = arr[len - 1];

        for (int i = 1; i < len; i++) {
            lMin[i] = Integer.min(lMin[i - 1], arr[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            rMax[i] = Integer.max(rMax[i + 1], arr[i]);
        }

        int left = 0;
        int right = 0;
        int maxDiff = 0;

        while (left < len && right < len) {
            if (lMin[left] < rMax[right]) {
                maxDiff = Integer.max(maxDiff, right - left);
                right++;
            } else {
                left++;
            }

//            If the dist b/w left pointer and end is less than the maxDiff calculated so far, break the loop
            if (len - 1 - left < maxDiff)   break;
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
        int maxDiff = calMaxJMinusI(arr);
        System.out.println("The max value of j-i is " + maxDiff);
    }
}
