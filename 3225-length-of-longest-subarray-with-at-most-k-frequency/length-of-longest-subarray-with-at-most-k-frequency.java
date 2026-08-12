class Solution {
    public static int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int right = 0; right<n; right++){
            int num = nums[right];
            map.put(num, map.getOrDefault(num,0)+1);
            while(map.get(num) > k){
                map.put(nums[left], map.getOrDefault(nums[left], 0)-1);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 1, 2, 1, 1, 1};
        int k = 2;
        maxSubarrayLength(nums,k);
    }
}