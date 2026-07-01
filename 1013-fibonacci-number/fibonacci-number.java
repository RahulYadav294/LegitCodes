class Solution {
    public static int fib(int n) {
        if(n<=0){
            return 0;
        }
        if(n<=1){
            return n;
        }
        int[] dp = new int[n+1];
        if(dp[n] == n){return dp[n];}
        int first = fib(n-1);
        int last = fib(n-2);
        return dp[n] = first + last;
    }
    public static void main(String[] args){
        int n = 2;
        int fibSum = fib(n);
        System.out.println(fibSum); 
    }
}