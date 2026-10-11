class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            max = Math.max(max,nums[i]);
        }
        long count = 0;
        int c = 0;
        int left = 0;
        for(int right = 0; right<n; right++){
            if(nums[right] == max)c++;
            while(c >= k){
                if(nums[left] == max) c--;
                left++;
            }
            count+=left;
        }
        return count;
    }
}