import java.util.Arrays;

public class KStrongest {
  public int[] getStrongest(int[] arr, int k) {
    Arrays.sort(arr);

    int len = arr.length;
    int median = arr[(len - 1) / 2];
    int[] res = new int[k];
    int i = 0;
    int j = len - 1;

    while (k > 0) {
      if (median - arr[i] > arr[j] - median) {
        res[k - 1] = arr[i];
        i++;
      } else {
        res[k - 1] = arr[j];
        j--;
      }
      k--;
    }

    return res;
  }
}
