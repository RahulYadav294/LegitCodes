class Solution {
    int Alice = 0;
    int Bob = 1;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int left = 0;
        int right = n-1;
        int[][][] dp = new int[n+1][n+1][2];
        for (int[][] matrix : dp) {
    for (int[] row : matrix) {
        Arrays.fill(row, -1);
    }
}
        int total = 0;
        for(int i = 0; i<n; i++){
            total+=piles[i];
        }
        
        int AliceScore = helper(piles,left,right,Alice,dp);
        return AliceScore >= total-AliceScore;
        
    }
    public int helper(int[] piles,int left,int right,int turn,int[][][] dp){
        if(left > right){
            return 0;
        }
        if(dp[left][right][turn] != -1){
            return dp[left][right][turn];
        }
        if(turn == Alice){
            int lefts = piles[left] + helper(piles,left+1,right,Bob,dp);
            int rights = piles[right] + helper(piles,left,right-1,Bob,dp);
            return dp[left][right][turn] = Math.max(lefts,rights);
        }else{
            int lefts = helper(piles,left+1,right,Alice,dp);
            int rights = helper(piles,left,right-1,Alice,dp);
            return dp[left][right][turn] =  Math.min(lefts,rights);
        }
    }
}