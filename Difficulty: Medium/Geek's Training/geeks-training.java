class Solution {

    public int maximumPoints(int mat[][]) {

        int n = mat.length;

        int[][] dp = new int[n][4];

        // -1 means not calculated yet
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(n - 1, 3, mat, dp);
    }

    public int solve(int day, int last, int mat[][], int[][] dp) {

        // Base case
        if (day == 0) {

            int max = 0;

            for (int task = 0; task < 3; task++) {

                if (task != last) {
                    max = Math.max(max, mat[0][task]);
                }
            }

            return dp[0][last] = max;
        }

        // Already calculated
        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        int max = 0;

        for (int task = 0; task < 3; task++) {

            if (task != last) {

                int points = mat[day][task]
                           + solve(day - 1, task, mat, dp);

                max = Math.max(max, points);
            }
        }

        return dp[day][last] = max;
    }
}