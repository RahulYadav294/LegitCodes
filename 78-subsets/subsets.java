class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> bigList = new ArrayList<>();
        if(nums.length == 0) return bigList;
        for(int mask = 0; mask < (1 << nums.length); mask++){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<nums.length; i++){
                if((mask & (1 << i)) !=0){
                    list.add(nums[i]);
                }
            }
            bigList.add(list);
        }
        return bigList;
    }
} 

/*
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length == 0){
            return list;
        }
        List<Integer> current = new ArrayList<>();
        helper(nums,list,0,current);
        return list;
    }
    public void helper(int[] nums,List<List<Integer>> list,int index,List<Integer> current){
        if(index == nums.length){
            list.add(new ArrayList<>(current));
            return;
        }
       helper(nums,list,index+1,current);
       current.add(nums[index]);
       helper(nums,list,index+1,current);
       current.remove(current.size()-1);
    }
}
*/