//Approach_3 Greedy
class Solution {
    public static  boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0; i<n; i++){
            if(max >= n-1) return true;
            if(i > max) {
                return false;
            }else{
                max = Math.max(max,nums[i] + i);
            }
            
        }
        return false;
    }
}

//Approach_2 Memoization
/*
class Solution {
    public static  boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[nums.length+1];
        return canReach(nums,0,n-1,dp);
    }
    public static boolean canReach(int[] nums,int index,int length,boolean[] dp){
        if(index == length){
            return true;
        }
        if(index > length){
            return false;
        }
        if(dp[index] != false) return dp[index];
        for(int step = 1; step<=nums[index]; step++){
        
            if(canReach(nums,index + step,length,dp)){
                return dp[index] = true;
            }
        }
        return false;
    }
}
*/
 //Approach_1 Recursion   
/*
class Solution {
    public static  boolean canJump(int[] nums) {
        int n = nums.length;
        return canReach(nums,0,n-1);
    }
    public static boolean canReach(int[] nums,int index,int length){
        if(index == length){
            return true;
        }
        if(index > length){
            return false;
        }
        for(int step = 1; step<=nums[index]; step++){
        
            if(canReach(nums,index + step,length)){
                return true;
            }
        }
        return false;
    }
}
*/
    