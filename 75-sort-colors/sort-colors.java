class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0;
        int mid = 0;
        int high = n-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(i,mid,nums);
                i++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(high,mid,nums);
                high--;
            }
        }
    }
    public void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a]  = nums[b];
        nums[b]  = temp;
    }
}