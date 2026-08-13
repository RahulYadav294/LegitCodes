class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countWays(nums,target,0,0);
    }
    public int countWays(int[] nums, int target, int index,int sum){
        if(index == nums.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
            int  take = countWays(nums,target,index+1,sum+nums[index]);
            int take2 = countWays(nums,target,index+1,sum-nums[index]);
        return take + take2;

    }
}