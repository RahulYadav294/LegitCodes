// Approach_2 Memoization
class Solution {
    public static int jump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
       return helper(nums,0,dp);
    }
    public static int helper(int[] nums,int curr,int[] dp){
        if(curr == nums.length-1) return 0;
        if(curr > nums.length-1) return Integer.MAX_VALUE;
        if(dp[curr] != -1) return dp[curr];
        int step = Integer.MAX_VALUE;
        for(int i = 1; i<=nums[curr]; i++){
            step =  Math.min(step,helper(nums,curr+i,dp));
        }
        if (step == Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
       return dp[curr] = 1 + step;
    }
}
  

// Approach_1 Recursion
/*
class Solution {
    public static int jump(int[] nums) {
       return helper(nums,0);
    }
    public static int helper(int[] nums,int curr){
        if(curr == nums.length-1) return 0;
        if(curr > nums.length-1) return Integer.MAX_VALUE; ;
        int step = Integer.MAX_VALUE;
        for(int i = 1; i<=nums[curr]; i++){
            step =  Math.min(step,helper(nums,curr+i));
        }
        if (step == Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
       return 1 + step;
    }
}
*/
