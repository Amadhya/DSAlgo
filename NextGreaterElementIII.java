import java.util.Arrays;

public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] numberStr = (n + "").toCharArray();

        int pivot = -1;
        int len = numberStr.length;

        for(int i = len - 2; i >=0; i-- ) {
            if (numberStr[i] < numberStr[i+1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1)    return -1;

        int swapIdx = pivot + 1;

        for (int i = pivot + 1; i < len; i++) {
            if (numberStr[pivot] < numberStr[i] && numberStr[i] <= numberStr[swapIdx] ) {
                swapIdx = i;
            }
        }

        char temp = numberStr[pivot];
        numberStr[pivot] = numberStr[swapIdx];
        numberStr[swapIdx] = temp;

        Arrays.sort(numberStr, pivot + 1, len);
        long number = Long.parseLong(new String(numberStr));

        return number <= Integer.MAX_VALUE ? (int) number : -1;
    }
}
