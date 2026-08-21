
/*
class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            int prod = 1;
            for(int j = 0; j<nums.length; j++){
                if(i == j) continue;
                prod*=nums[j];
            }
            res[i] = prod;
        }
        return res;
    }
}
*/



class Solution {
    public static int[] productExceptSelf(int[] nums) {
      int[] prefix = new int[nums.length];
      prefix[0] = nums[0];
      for(int i = 1; i<nums.length; i++){
        prefix[i] = prefix[i-1] * nums[i];
      }
    int suffix = 1;
    for(int i = nums.length -1; i>=0; i--){
        if(i == 0){
            prefix[i] = suffix;
        }
        else{
        prefix[i] = prefix[i-1] * suffix;
        }
        suffix = suffix * nums[i];
    }
    return prefix;
    }
}
