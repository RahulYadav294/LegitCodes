class Solution {
    public static int fib(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n);
        
    }
    public static int helper(int[] dp,int n){
        if(n == 0 || n == 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int first = helper(dp,n-1);
        int second = helper(dp,n-2);
        dp[n] = first + second;
        return dp[n];
    }
}