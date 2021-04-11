class Solution {
    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < len; i++) {
            int curr = 0;
            for (int j = i - 2; j >=0; j--) {
                curr = Math.max(curr, dp[j]);
            }
            dp[i] = curr + nums[i];
        }


        int maxAmount = 0;

        for (int i = 0; i < len; i++) {
            maxAmount = Math.max(maxAmount, dp[i]);
        }

        return maxAmount;
    }
}