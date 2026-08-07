class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
    
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(deck[i], map.getOrDefault(deck[i],0)+1);
        }
        int gcd = 0;
        for(int num : map.values()){
            gcd = getGcd(gcd,num);
        }
        if(gcd > 1) return true;
        return false;
        
    }
    public int getGcd(int a, int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}