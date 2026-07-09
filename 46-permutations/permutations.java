import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> list = new ArrayList<>();
       if(nums.length == 0) return list;
       boolean[] used = new boolean[nums.length];
       List<Integer> current = new ArrayList<>();
       helper(nums,0,list,used,current);
       return list;
    }
    public void helper(int[] nums,int index,List<List<Integer>> list,boolean[] used,List<Integer> current){
        if(current.size() == nums.length){
            list.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(!used[i]){
                used[i] = true;
                current.add(nums[i]);
                helper(nums,index+1,list,used,current);
                current.remove(current.size()-1);
                used[i] = false;
            }
        }
    }
}
