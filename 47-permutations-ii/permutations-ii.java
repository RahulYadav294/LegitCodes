class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> bigList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums,bigList,list,visited);
        return bigList;
    }
    public void helper(int[] nums,  List<List<Integer>> bigList, List<Integer> list,  boolean[] visited){
            if(list.size() == nums.length){
            bigList.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            if(visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(nums,bigList,list,visited);
            list.remove(list.size()-1); 
             visited[i] = false; 
        }
    }
}