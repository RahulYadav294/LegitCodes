class Solution {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums.length == 0){ return 0;}
        int large = 1;
        for(int i = 0; i<nums.length; i++){
            set.add(nums[i]);
        }
        for(int num : set){
            if(!set.contains(num-1)){
               int current = 1;
               int next = num + 1 ;
               while(set.contains(next)){
                current++;
                next++;
               } 
               large = Math.max(large,current);
            }
    }
    return large;
}
}