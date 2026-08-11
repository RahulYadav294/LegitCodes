class Solution {
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        parent = new int[26];
        rank   = new int[26];
        for(int i = 0; i<26; i++){
            parent[i] = i;
        }

        for(int i = 0; i<n; i++){
            String s = equations[i];
            if(s.charAt(1) == '='){
            int u = s.charAt(0)-'a';
            int v = s.charAt(3)-'a';
            union(u,v);
            }

        }
        for(int i = 0; i<n; i++){
            String s = equations[i];
            if(s.charAt(1) == '!'){
            int u = s.charAt(0)-'a';
            int v = s.charAt(3)-'a';
            if(findP(u) == findP(v)){
            return false;
            }
            }
        }
        return true;
    }
    public int findP(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = findP(parent[x]);
    }
    public void union(int a, int b){
        int pA = findP(a);
        int pB = findP(b);
        if(rank[pA] < rank[pB]){
            parent[pA] = pB;
        }else if(rank[pB] < rank[pA]){
            parent[pB] = pA;
        }else{
            parent[pA] = pB;
            rank[pB]++;
        }
    }
}