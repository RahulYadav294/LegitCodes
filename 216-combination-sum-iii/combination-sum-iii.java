class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> bigList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(n == 1 && k > 1) return bigList;
        int mask = 0;
        helper(k,n,mask,bigList,list,1,0);
        return bigList;
    }
    public void helper(int k, int n, int mask, List<List<Integer>> bigList,       List<Integer> list,int index,int sum){
        if(list.size() == k){
            if(sum == n){
                bigList.add(new ArrayList(list));
            }
        }

        for(int i = index; i<=9; i++){
            int newMask = mask;
            if((newMask & (1<<i)) !=0) continue;
            newMask|=(1<<index);
            list.add(i);
            helper(k,n,newMask,bigList,list,i+1,sum+i);
            list.remove(list.size()-1);
        }
    }
}