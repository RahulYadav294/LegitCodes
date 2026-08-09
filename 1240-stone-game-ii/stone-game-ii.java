class Solution {

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(piles, dp, 0, 1);
    }

    public int helper(int[] piles, int[][] dp, int index, int M) {

        if (index >= piles.length) {
            return 0;
        }

        if (dp[index][M] != -1) {
            return dp[index][M];
        }

        int best = 0;
        int taken = 0;

        for (int x = 1; x <= Math.min(2 * M, piles.length - index); x++) {

            taken += piles[index + x - 1];

            int opponent = helper(
                piles,
                dp,
                index + x,
                Math.max(M, x)
            );

            int totalRemaining =
                0;

            for (int j = index + x; j < piles.length; j++) {
                totalRemaining += piles[j];
            }

            int current = taken + totalRemaining - opponent;

            best = Math.max(best, current);
        }

        return dp[index][M] = best;
    }
}