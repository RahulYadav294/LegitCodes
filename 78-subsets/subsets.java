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