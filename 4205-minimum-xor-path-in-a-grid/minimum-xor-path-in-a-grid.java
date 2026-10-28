class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MAX = 1024;

        boolean[][][] dp = new boolean[m][n][MAX];

        dp[0][0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int val = grid[i][j];

                if (i > 0) {
                    for (int x = 0; x < MAX; x++) {
                        if (dp[i - 1][j][x]) {
                            dp[i][j][x ^ val] = true;
                        }
                    }
                }

                if (j > 0) {
                    for (int x = 0; x < MAX; x++) {
                        if (dp[i][j - 1][x]) {
                            dp[i][j][x ^ val] = true;
                        }
                    }
                }
            }
        }

        for (int x = 0; x < MAX; x++) {
            if (dp[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}


/*
class Solution {
    public int minCost(int[][] grid) {

        return solve(grid, 0, 0, 0);
    }

    public int solve(int[][] grid, int row, int col, int exor) {
        int m = grid.length;
        int n = grid[0].length;

        exor ^= grid[row][col];

        if (row == m - 1 && col == n - 1) {
            return exor;
        }

        int cost1 = Integer.MAX_VALUE;
        int cost2 = Integer.MAX_VALUE;

        if (col + 1 < n) {
            cost1 = solve(grid, row, col + 1, exor);
        }

        if (row + 1 < m) {
            cost2 = solve(grid, row + 1, col, exor);
        }

        return Math.min(cost1, cost2);
    }
}
*/