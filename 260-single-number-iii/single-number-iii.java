class Solution {
    public int[] singleNumber(int[] nums) {
        int exor = 0;
        for(int i = 0; i<nums.length; i++){
            exor^=nums[i];
        }
        int mask = exor & (-exor);
        int group1 = 0;
        int group2 = 0;
        for(int num : nums){
            if((num & mask) != 0){
                group1^=num;
            }else{
                group2^=num;
            }
        }
        return new int[]{group1,group2};
    }
}