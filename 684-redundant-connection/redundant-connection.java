class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(find(u) == find(v)){
                return new int[]{u,v};
            }
            union(u,v);
        }

        return new int[]{0};
    }
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b){
        int pA = find(a);
        int pB = find(b);
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