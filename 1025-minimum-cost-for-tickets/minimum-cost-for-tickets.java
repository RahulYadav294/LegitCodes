

import java.util.Arrays;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);

        return solve(days, costs, 0, dp);
    }

    public int solve(int[] days, int[] costs, int i, int[] dp) {
        // Base case
        if (i >= days.length) {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Take 1-day pass
        int j = i;
        while (j < days.length && days[j] < days[i] + 1) {
            j++;
        }
        int oneDay = costs[0] + solve(days, costs, j, dp);

        // Take 7-day pass
        j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }
        int sevenDay = costs[1] + solve(days, costs, j, dp);

        // Take 30-day pass
        j = i;
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }
        int thirtyDay = costs[2] + solve(days, costs, j, dp);

        // Store and return the minimum cost
        dp[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));

        return dp[i];
    }
}
