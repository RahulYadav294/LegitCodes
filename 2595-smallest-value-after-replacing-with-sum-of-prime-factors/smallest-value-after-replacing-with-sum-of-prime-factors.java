class Solution {
    public int smallestValue(int n) {

     while(true){
        int current = n;
        int sum = 0;
        int factor = 2;
        while( factor * factor <= current){
            while(current % factor == 0){
            sum+= factor;
            current/=factor;
        }
        factor++;
        }
        if(current > 1){
            sum+=current;
        }
        if(sum == n) return n;
        n = sum;
     }

    }
}
