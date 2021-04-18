public class RodCutting {
  public static int helper(int n, int[] price, int index, int[][] dp) {
    if (n == 0) {
      return 0;
    }

    if (index >= price.length || n < 0) {
      return Integer.MIN_VALUE;
    }

    if (dp[n][index] != Integer.MAX_VALUE) {
      return dp[n][index];
    }

    return dp[n][index] =
        Math.max(
            helper(n - index - 1, price, index, dp) + price[index],
            helper(n, price, index + 1, dp));
  }

  public static int findMaxCost(int n, int[] price) {
    int[][] dp = new int[n + 1][price.length];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j < price.length; j++) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }

    return helper(n, price, 0, dp);
  }

  public static void main(String[] args) {
    int[] price1 = {3, 5, 8, 9, 10, 17, 17, 20};
    int n1 = 8;

    System.out.println("Maximum cost Case 1 is: " + findMaxCost(n1, price1));

    int[] price2 = {1, 5, 8, 9, 10, 17, 17, 20};
    int n2 = 8;

    System.out.println("Maximum cost Case 2 is: " + findMaxCost(n2, price2));
  }
}
