class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 1;
        long high = (long) n * Math.min(a,Math.min(b,c));
        long count = 0;
        long ans = 0;
        while(low < high){
            long mid = low+(high-low)/2;
            long lcmAB = (long)a * b / getGcd(a, b);
            long lcmAC = (long)a * c / getGcd(a, c);
            long lcmBC = (long)b * c / getGcd(b, c);
            long lcmABC = lcmAB * c / getGcd((int)lcmAB, c);
            count = mid/a + mid/b + mid/c - mid/lcmAB - mid/lcmAC  - mid/lcmBC + mid/lcmABC;
      
            if(count < n){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return (int)low;
    }
    public long getGcd(int a, int b){
        while(b !=0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return  a;
    }
}