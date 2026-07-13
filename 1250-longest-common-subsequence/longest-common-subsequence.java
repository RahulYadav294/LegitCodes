//Approach_4 Space optimizarion
class Solution{
    public static int longestCommonSubsequence(String text1,String text2){
        int m = text1.length();
        int n = text2.length();
        int[] prev = new int[n+1];
        for(int i = 1; i<=m; i++){
            int[] curr = new int[n+1];
            for(int j = 1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                int left =  curr[j-1];
                int up =  prev[j];
                curr[j] = Math.max(left,up);
                }
            }
            prev = curr;
        }
        return prev[n] ;
    }
}

// Approach_3 Tabulation
/*
class Solution{
    public static int longestCommonSubsequence(String text1,String text2){
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                int left =  dp[i][j-1];
                int up =  dp[i-1][j];
                dp[i][j] = Math.max(left,up);
                }
            }
        }
        return dp[m][n];
    }
}
*/

//Approach_2 Memoization
/*
class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int[] row : dp) {
             Arrays.fill(row, -1);
            }
        return helper(text1,text2,0,0,dp,m,n);
    }
    public static int helper(String text1,String text2,int i, int j,int[][] dp,int m,int n){
        if((i == text1.length()) || (j == text2.length())){
            return 0;
        }
        if(i > m || j>n ) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + helper(text1,text2,i+1,j+1,dp,m,n);
        }
        return dp[i][j] = Math.max(helper(text1,text2,i,j+1,dp,m,n),helper(text1,text2,i+1,j,dp,m,n));
    }
}
*/


// Approach_1 Recursive
/*
class Solution {
    public static int longestCommonSubsequence(String text1, String text2) {
        return helper(text1,text2,0,0);
    }
    public static int helper(String text1,String text2,int i, int j){
        if((i == text1.length()) || (j == text2.length())){
            return 0;
        }
        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + helper(text1,text2,i+1,j+1);
        }
        return Math.max(helper(text1,text2,i,j+1),helper(text1,text2,i+1,j));
    }
}
*/