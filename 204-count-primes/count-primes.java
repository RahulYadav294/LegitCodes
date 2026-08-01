class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int count = 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime,true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i*i<n; i++){
            if(prime[i]){
                for(int j = i*i; j<n; j+=i){
                    prime[j] = false;
                }
            }
        }
        for(int i = 2; i<n; i++){
            if(prime[i]){
                count++;
            }
        }
        return count;
    }
}



/*
class Solution {
    public int countPrimes(int n) {
        int count = 0 ;
        for(int i = 2; i<n; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }
    public boolean isPrime(int p){
        for(int i = 2; i<=Math.sqrt(p); i++){
            if(p % i == 0) return false;
        }
        return true;
    }
}
*/