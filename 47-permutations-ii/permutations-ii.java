class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> bigList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums,bigList,list,visited,0);
        return bigList;
    }
    public void helper(int[] nums,  List<List<Integer>> bigList, List<Integer> list,  boolean[] visited,int index){
        if(list.size() == nums.length){
            if(!bigList.contains(list)){
            bigList.add(new ArrayList<>(list));
            return;
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(nums,bigList,list,visited,index+1);
            list.remove(list.size()-1); 
             visited[i] = false; 
        }
    }
}