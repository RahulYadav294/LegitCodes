class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long low = 1;
        long high = (long) n * Math.min(a, b);
        long ans = 0;
        long count = 0;
        while(low <= high){
            long mid = low+(high-low)/2;
        long lcm = (long) a * b / getGcd(a, b);
            count = mid/a + mid/b - mid/lcm;
            if(count < n){
                low = mid+1;
            }else{
                ans = mid;
                high = mid-1;
            }
        }
        return  (int)(ans % 1000000007);
        
    }
    public int getGcd(int a,int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}