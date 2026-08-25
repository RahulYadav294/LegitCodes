class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            set.add(nums[i]);
        }
        int p = k;
        while(set.contains(p)){
            p+=k;
        }
        return p;
    }
}