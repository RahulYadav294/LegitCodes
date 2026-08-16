class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<n-3; i++){
            if(i > 0 && nums[i] == nums[i-1])continue;
            int first = nums[i];
            for(int j = i+1; j<n-2; j++){
                if(j > i+1 && nums[j] == nums[j-1])continue;
            int second = nums[j];
            int low = j+1;
            int high = n-1;
            while(low < high){
                long sum = (long)first + second + nums[low] + nums[high];
                if(sum == target){
                    list.add(Arrays.asList(first,second,nums[low],nums[high]));
                    low++;
                    high--;
                    while(low < high && nums[low] == nums[low-1]){low++;}
                     while(low < high && nums[high] == nums[high+1]){high--;}
                }else if(sum > target){high--;}else{low++;}
            }
        }
        }
        return list;
    }
}