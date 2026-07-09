class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    if(candidates.length == 0) return list;
    List<Integer> current = new ArrayList<>();
    helper(candidates,target,0,list,current,0);
    return list;
    }
    public static void helper(int[] candidates,int target,int index,List<List<Integer>> list,List<Integer> current,int sum){
        if(sum == target){
            list.add(new ArrayList<>(current));
            return;
        }
       if(sum > target) return;
        for(int i = index; i< candidates.length; i++){
                current.add(candidates[i]);
                helper(candidates,target,i,list,current,sum+candidates[i]);
                current.remove(current.size()-1);
            }
        } 
    }
