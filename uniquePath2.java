class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // If start or end is blocked, return 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1; // Start point

        // Fill DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0; // No path through obstacles
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j]; // From top
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1]; // From left
                    }
                }
            }
        }

        return dp[m - 1][n - 1]; // Paths to bottom-right corner
    }
}
