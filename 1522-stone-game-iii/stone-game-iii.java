class Solution {
    int Alice = 0;
    int Bob = 1;
    public String stoneGameIII(int[] piles) {
        int n = piles.length;
        Integer[][] dp = new Integer[n + 1][2];
    
        int total = 0;
        for(int i = 0; i<n; i++){
            total+=piles[i];
        }
        
        int AliceScore = helper(piles,0,Alice,dp);
        int BobScore = total-AliceScore;
        int diff = AliceScore - BobScore;
        if(diff == 0 ){
            return "Tie";
        }else if(diff > 0){
            return "Alice";
        }else{
            return "Bob";
        }
        
    }
    public int helper(int[] piles,int index,int turn,Integer[][]dp){
        if(index >= piles.length){
            return 0;
        }
        if(dp[index][turn] != null){
            return dp[index][turn];
        }
        if(turn == Alice){
            int first = piles[index] + helper(piles,index+1,Bob,dp);
            int second = Integer.MIN_VALUE;
            if(index + 1 < piles.length){
             second = piles[index] + piles[index + 1] + helper(piles,index+2,Bob,dp);
            }
            int third = Integer.MIN_VALUE;
            if(index + 2 < piles.length){
             third  = piles[index] + piles[index +1 ] + piles[index + 2] +helper(piles,index+3,Bob,dp);
            }
            return dp[index][turn] = Math.max(first,Math.max(second,third));
        }
        else {

    int first = helper(piles, index + 1, Alice, dp);

    int second = Integer.MAX_VALUE;
    if (index + 1 < piles.length) {
        second = helper(piles, index + 2, Alice, dp);
    }

    int third = Integer.MAX_VALUE;
    if (index + 2 < piles.length) {
        third = helper(piles, index + 3, Alice, dp);
    }

    return dp[index][turn] = Math.min(first, Math.min(second, third));
}
    }
}