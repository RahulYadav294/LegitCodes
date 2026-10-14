
import java.util.Arrays;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        int m = rides.length;
        long[] dp = new long[m];
        Arrays.fill(dp, -1);

        return solve(rides, 0, dp);
    }

    public long solve(int[][] rides, int idx, long[] dp) {
        if (idx >= rides.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        // Skip the current ride
        long skip = solve(rides, idx + 1, dp);

        // Take the current ride
        long earning = (long) rides[idx][1] - rides[idx][0]
                     + rides[idx][2];

        int nextIndex = findNextRide(rides, rides[idx][1]);

        long take = earning + solve(rides, nextIndex, dp);

        return dp[idx] = Math.max(skip, take);
    }

    public int findNextRide(int[][] rides, int end) {
        int low = 0;
        int high = rides.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (rides[mid][0] < end) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}






/*
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));
        return solve(rides,0,-1);
    }
    public long solve(int[][] rides, int idx, int prevEnd){
        if(idx >= rides.length){
            return 0;
        }
        long skip = solve(rides,idx+1,prevEnd);
        long take = 0;
        if( prevEnd == -1 || rides[idx][0] >= prevEnd){
            long earning = rides[idx][1] - rides[idx][0] + rides[idx][2]; 
            take = earning + solve(rides,idx+1,rides[idx][1]);
        }
        return  Math.max(skip,take);
    }
}
*/