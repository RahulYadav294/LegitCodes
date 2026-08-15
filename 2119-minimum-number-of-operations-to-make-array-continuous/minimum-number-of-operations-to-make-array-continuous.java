class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int maxWindow = 0;
        int left = 0;
        Arrays.sort(nums);
        int j = 0;
        for(int i = 1; i<n; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        int unique = j+1;
        for(int right = 0; right<unique; right++){
            if(nums[right] - nums[left] <=n-1){
                maxWindow = Math.max(maxWindow,right-left+1);
            }else{
                left++;
            }
        }
        return n-maxWindow;
    }
}