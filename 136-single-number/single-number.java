class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int exor = 0;
        for(int i = 0; i<n; i++){
            exor^=nums[i];
        }
        return exor;
    }
}