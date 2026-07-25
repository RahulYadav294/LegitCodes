import java.util.ArrayList;
class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        int n = nums.length;
        int lows = 0;

        
        for(int i = 0; i<n-2; i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
           int low = i+1;
            int high = n-1;
            while(low < high){
                int sum = nums[low] + nums[high] + nums[i];
    
                    if(sum == 0){
                        result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    
                    while(low < high && nums[low] == nums[low+1]) low++;
                    while(low < high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                    }
                
                else if(sum > 0){
                    high--;
                }
                else{
                    low++;
                }
            }

            }
            return result;
        }
}