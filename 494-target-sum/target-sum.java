class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int total = 0;
        for (int x : nums) {
            total += x;
        }

        if (Math.abs(target) > total) {
            return 0;
        }

        Integer[][] dp = new Integer[n][2 * total + 1];

        return countWays(nums, target, 0, 0, total, dp);
    }

    public int countWays(int[] nums, int target,
                         int index, int sum,
                         int offset, Integer[][] dp) {

        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        if (dp[index][sum + offset] != null) {
            return dp[index][sum + offset];
        }

        int plus = countWays(
            nums, target,
            index + 1,
            sum + nums[index],
            offset,
            dp
        );

        int minus = countWays(
            nums, target,
            index + 1,
            sum - nums[index],
            offset,
            dp
        );

        return dp[index][sum + offset] = plus + minus;
    }
}


/*
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return countWays(nums,target,0,0,dp);
    }
    public int countWays(int[] nums, int target, int index,int sum, int[] dp){
        if(index == nums.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[index] != -1) return dp[index];
            int  take = countWays(nums,target,index+1,sum+nums[index],dp);
            int take2 = countWays(nums,target,index+1,sum-nums[index],dp);
        return dp[index] = take + take2;

    }
}
*/