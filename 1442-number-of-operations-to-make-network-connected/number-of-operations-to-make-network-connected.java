class Solution {
    int[] parent;
    int[] rank;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        parent = new int[n];
        rank   = new int[n];
        int extra = 0;
        int component = n;
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            if(findP(u) == findP(v)){
                extra++;
            }else{
                union(u,v);
                component--;
            }
        }
        if(extra >= component-1) return component-1;
    return -1;

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