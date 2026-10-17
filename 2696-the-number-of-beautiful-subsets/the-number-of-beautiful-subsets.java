class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        return solve(nums,k,list,0) - 1;
    }
    public int solve(int[] nums,int k, List<Integer> list, int idx){
        if(idx == nums.length) return 1;
        int ways = solve(nums,k,list,idx+1);
        int num = nums[idx];
        if(!list.contains(num + k) && !list.contains(num-k)){
            list.add(num);
            ways+=solve(nums,k,list,idx+1);
            list.remove(list.size()-1);
        }
        return ways;
    }
}