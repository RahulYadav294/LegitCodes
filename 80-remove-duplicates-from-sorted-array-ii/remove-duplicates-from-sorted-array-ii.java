class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int p = 0;
        int count = 1;
        int prev = nums[0];
        for(int i = 1; i<n; i++){
            if(nums[i] != prev){
                p++;
                nums[p] = nums[i];
                prev = nums[i];
                count  = 1;
            }else{
                if(count < 2){
                p++;
                nums[p] = nums[i];
                count++;
                }
            }
        }
    return p+1 ;
    }
}




/*
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        int q = 0;
        int prev = nums[0];
        int count = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] != prev){
                prev = nums[i];
                count = 0;
            }
            if(count < 2){
                p[q++] = nums[i];
                count++;
            }
        }
        return q;
    }
}
*/