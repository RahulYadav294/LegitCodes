class Solution {
    public int minCost(int n, int[] cuts) {
        int p = 0;
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length-1] = n;
        int k = arr.length;
        int[][] dp = new int[k][k];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int j = arr.length-1;
        for(int i = 0; i<arr.length-2; i++){
            arr[i+1] = cuts[i];

        }
        Arrays.sort(arr);
        return helper(arr,p,j,dp);
    }
    public int helper(int[] arr, int i, int j,int[][] dp){
        if(j-i == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i+1; k<j; k++){
            int cut = helper(arr,i,k,dp) + helper(arr,k,j,dp) + arr[j] - arr[i];
            ans = Math.min(ans,cut);
        }
        return dp[i][j] = ans;
    }
}