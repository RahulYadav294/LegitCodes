class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] num = new int[n+2];
        num[0] = 1;
        num[n+1] = 1;
        for(int i = 1; i<=n; i++){
            num[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(num,1,n,dp);
    }
    public int helper(int[] num,int left,int high,int[][] dp){
        if(left > high) return 0;
        if(dp[left][high] != -1) return dp[left][high];
        int maxCoin = 0;
        for(int i = left; i<= high; i++){
            int lefts = helper(num,left,i-1,dp);
            int highs = helper(num,i+1,high,dp);
            int curr = num[left-1] * num[i] * num[high+1];
            maxCoin = Math.max(maxCoin,lefts+highs+curr);
        }
        return dp[left][high] = maxCoin;
    }
}