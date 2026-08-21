class Solution {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int d = k % n;
        int p = n-1;
        int[] res = new int[n];
        for(int i = d-1; i >=0; i--){
            res[i] = nums[p--];
        }
        p = 0;
         for(int i = d; i < n; i++){
            res[i] = nums[p++];
        }
        for(int i = 0; i<n; i++){
            nums[i] = res[i];
        }
    }
}


/*
class Solution {
    public static void rotate(int[] nums, int k) {
       int len = nums.length;
       int d = k % len;
       int pos = len-1;
       int[] arr = new int[d];
       for(int i = 0; i<d; i++){
        arr[i] = nums[len - d + i]; 
       }
       for(int i = len-1; i>=d; i--){
        nums[i] = nums[i - d];
       }
       for(int i = 0; i<d; i++){
        nums[i] = arr[i];
       }
    }
}
*/