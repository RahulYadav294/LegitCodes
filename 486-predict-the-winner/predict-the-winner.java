class Solution {

    static final int ARIA = 0;
    static final int BEN = 1;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int x : nums)
            total += x;

        int[][][] dp = new int[n+1][n+1][2];
       for (int[][] matrix : dp) {
    for (int[] row : matrix) {
        Arrays.fill(row, -1);
    }
}
        int ariaScore = helper(nums, 0, nums.length - 1, ARIA,dp);

        return ariaScore >= total - ariaScore;
    }

    public int helper(int[] nums, int left, int right, int turn,int[][][] dp) {

        if (left > right)
            return 0;
            if(dp[left][right][turn] != -1) return dp[left][right][turn];
        if (turn == ARIA) {

            int takeLeft = nums[left] + helper(nums, left + 1, right, BEN,dp);

            int takeRight = nums[right] + helper(nums, left, right - 1, BEN,dp);

            return dp[left][right][turn] = Math.max(takeLeft, takeRight);

        } else {

            int takeLeft = helper(nums, left + 1, right, ARIA,dp);

            int takeRight = helper(nums, left, right - 1, ARIA,dp);

            return dp[left][right][turn] =  Math.min(takeLeft, takeRight);

        }
    }
}