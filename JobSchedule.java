class Solution {
    public int findMinDifficulty(int[] jobDifficulty, int d, int breakIndex, int[][] dp) {
        if (d == 0 && breakIndex == jobDifficulty.length) {
            return 0;
        }

        if (d == 0 || breakIndex == jobDifficulty.length) {
            return Integer.MAX_VALUE;
        }

        if (dp[breakIndex][d] != -1) {
            return dp[breakIndex][d];
        }

        int currMax = Integer.MIN_VALUE;
        int minDifficulty = Integer.MAX_VALUE;

        for (int i = breakIndex; i < jobDifficulty.length; i++) {
            currMax = Math.max(currMax, jobDifficulty[i]);
            int res = findMinDifficulty(jobDifficulty, d - 1, i + 1, dp);
            if (res != Integer.MAX_VALUE) {
                minDifficulty = Math.min(minDifficulty, currMax + res);
            }
        }

        return dp[breakIndex][d] = minDifficulty;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;

        int[][] dp = new int[jobDifficulty.length][d + 1];

        for(int i = 0; i < jobDifficulty.length; i++) {
            for(int j = 0; j <= d; j++) {
                dp[i][j] = -1;
            }
        }

        return findMinDifficulty(jobDifficulty, d, 0, dp);
    }
}