class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int num : map.keySet()){
            int comp = map.get(num);
            if( comp > n/2) return num;
        }
        return 0;
    }
}


/*
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = nums[0];
        int count = 1;
        int element = nums[0];
        for(int i = 1; i<n; i++){
            if(count == 0){
                candidate = nums[i];
            }
           if(candidate == nums[i]){
            count++;
           }else{
            count--;
           } }
           return candidate;
    }
}
*/