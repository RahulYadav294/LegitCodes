class Solution {
    public int minOperations(int[] nums) {
        int minOperation = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int n : map.values()){
            if(n == 1) return -1;
           if(n % 3 == 0){
            minOperation+= n/3;
           }else{
             minOperation+= n/3 + 1;
           }
           
        }
        return minOperation;
    }
}