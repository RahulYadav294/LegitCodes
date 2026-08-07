class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length;i++){
                max = Math.max(nums[i],max);
                min = Math.min(nums[i],min);
        }
        while(min!=0){
            int rem = max % min;
            max = min;
            min = rem;
        }
        return max;
    }
}