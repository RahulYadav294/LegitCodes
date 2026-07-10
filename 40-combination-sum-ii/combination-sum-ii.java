class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(candidates.length == 0) return list;
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        helper(candidates,target,0,0,list,current);
        return list;
    }
    public void helper(int[] candidates,int target,int index,int sum,List<List<Integer>> list,List<Integer> current){
        if(sum == target){
            list.add(new ArrayList<>(current));
            return;
        }
        if(sum > target) return;
        for(int i = index; i<candidates.length; i++){
            if( i > index && candidates[i] == candidates[i-1])
            continue;
            current.add(candidates[i]);
            helper(candidates,target,i+1,sum+candidates[i],list,current);
            current.remove(current.size()-1);
        }
    }
}