class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> bigList = new ArrayList<>();
        boolean[] sieve = new boolean[n+1];
        Arrays.fill(sieve,true);
        sieve[0] = false;
        sieve[1] = false;
        for(int i = 2; i*i<=n; i++){
            if(sieve[i]){
            for(int j = i * i; j<=n; j+=i){
            sieve[j] = false;
            }
        }}
        for(int i = 2; i<=n/2; i++){
            if(sieve[i] && sieve[n-i]){
                bigList.add(Arrays.asList(i,n-i));
            }
        }
        return bigList;

    }
}
    
/*
class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> bigList = new ArrayList<>();
        for(int i = 2; i<=n/2; i++){
            int j = n-i;
                if(isPrime(i) && isPrime(j)){
                    int sum = i + j;
                    if(sum == n){
                        bigList.add(Arrays.asList(i,j));
                    }
                }
        }
        return bigList;
    }
    public boolean isPrime(int x){
         if (x < 2) return false;
        for(int i = 2; i*i<=x; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}
*/
/*
class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> bigList = new ArrayList<>();
        for(int i = 2; i<=n; i++){
            for(int j = i; j<=n; j++){
                if(isPrime(i) && isPrime(j)){
                    int sum = i + j;
                    if(sum == n){
                        bigList.add(Arrays.asList(i,j));
                    }
                }
            }
        }
        return bigList;
    }
    public boolean isPrime(int x){
        for(int i = 2; i*i<=x; i++){
            if(x % i == 0) return false;
        }
        return true;
    }
}
*/