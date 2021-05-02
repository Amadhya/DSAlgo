class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        int curr = 0;
        int buy = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if (prices[i - 1] > prices[i]) {
                buy = prices[i];
                total += curr;
                curr = 0;
            } else {
                curr = Math.max(curr, prices[i] - buy);
            }
        }

        return total + curr;
    }
}

// APPROACH - 2
class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;

        for(int i = 1; i < prices.length; i++) {
            total += Math.max(prices[i] - prices[i - 1], 0);
        }

        return total;
    }
}
