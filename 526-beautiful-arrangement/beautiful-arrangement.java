class Solution {
    int count = 0;
    public int countArrangement(int n) {
        int mask = 0;
         helper(n,0,1);
         return count;
    }
    public void helper(int n, int mask, int position){
        if(position > n){
            count++;
            return;
        }


        for(int num = 1; num<=n; num++){
          if((mask & (1 << (num - 1))) != 0)
                    continue;
            if(num % position == 0 || position % num == 0){
                 mask|=(1<<(num-1));
                 helper(n, mask, position+1);
                 mask^=(1<<(num-1));
            }
            
        }
    }

}