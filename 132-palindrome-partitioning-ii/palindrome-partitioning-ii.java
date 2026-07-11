class Solution {
    public boolean palindrome(String s){
        int low = 0;
        int high = s.length()-1;
        while(low <= high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }else{
                low++;
                high--;
            }
        }
        return true;
    }
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
         return helper(s,0,dp) - 1;  
    }
    public int helper(String s,int index,int[] dp){
        if(index == s.length()) return 0;
        int ans = Integer.MAX_VALUE;
        if(dp[index] != -1) return dp[index];
        for(int i = index; i<s.length(); i++){
            String s1 = s.substring(index,i+1);
            if(palindrome(s1)){
          ans = Math.min(ans,(helper(s,i+1,dp) + 1));
        }
        }
        return dp[index]  = ans;
    }
}