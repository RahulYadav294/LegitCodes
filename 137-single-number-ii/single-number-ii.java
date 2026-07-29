class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int bit = 0; bit<32; bit++){
            int count = 0;
            for(int num : nums){
                if((num & (1<<bit)) != 0){
                    count++;
                }
            }
            if(count % 3 != 0){
                    ans|=(1<<bit);
                }
        }
        return ans;
    }
}

/*
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int num : map.keySet()){
            if(map.get(num) == 1) return num;
        }
        return -1;
    }
}
*/