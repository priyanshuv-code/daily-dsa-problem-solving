class Solution {

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        // Base case: last row
        for (int j1 = 0; j1 < m; j1++) {

            for (int j2 = 0; j2 < m; j2++) {

                if (j1 == j2) {

                    dp[n - 1][j1][j2] =
                        grid[n - 1][j1];

                } else {

                    dp[n - 1][j1][j2] =
                        grid[n - 1][j1] +
                        grid[n - 1][j2];
                }
            }
        }

        // Bottom -> Top
        for (int i = n - 2; i >= 0; i--) {

            for (int j1 = 0; j1 < m; j1++) {

                for (int j2 = 0; j2 < m; j2++) {

                    int current;

                    if (j1 == j2) {
                        current = grid[i][j1];
                    } else {
                        current =
                            grid[i][j1] +
                            grid[i][j2];
                    }

                    int max = -100000000;

                    // 9 combinations
                    for (int dj1 = -1; dj1 <= 1; dj1++) {

                        for (int dj2 = -1; dj2 <= 1; dj2++) {

                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;

                            if (nj1 >= 0 && nj1 < m &&
                                nj2 >= 0 && nj2 < m) {

                                max = Math.max(
                                    max,
                                    dp[i + 1][nj1][nj2]
                                );
                            }
                        }
                    }

                    dp[i][j1][j2] =
                        current + max;
                }
            }
        }

        // Starting positions are fixed:
        // Person 1 -> (0,0)
        // Person 2 -> (0,m-1)

        return dp[0][0][m - 1];
    }
}