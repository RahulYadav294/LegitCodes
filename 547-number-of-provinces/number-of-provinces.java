//Disjoint Set
class Solution{
    int[] rank;
    int[] parent;
    int findX(int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = findX(parent[node]);
    }
    void union(int u,int v){
        int pu = findX(u);
        int pv = findX(v);
        if(rank[pv] < rank[pu]){
            parent[pv] = pu;
        }else if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }else{
            parent[pu] = pv;
            rank[pu]++;
        }
    }
    public int findCircleNum(int[][] isConnected){
        int v = isConnected.length;
    rank = new int[v];
    parent = new int[v];
    for(int i = 0; i<v; i++){
        parent[i] = i;
    }
    for(int i = 0; i<v; i++){
        for(int j = i+1; j<v; j++){
            if(isConnected[i][j] == 1){
            union(i,j);
            }
        }
    }
    int pro = 0;
    for(int i = 0; i<v; i++){
        if(findX(i) == i){
            pro++;
        }
        
    }
    return pro;
}
}



//Using bfs
/*
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        boolean[] visited = new boolean[v];
        int countProvinces = 0;
        for(int i = 0; i<v; i++){
            if(!visited[i]){
                bfs(i,isConnected,visited);
                countProvinces++;
            }
        }
        return countProvinces;
    }
    public void bfs(int vertex,int[][] isConnected,boolean[] visited){
        visited[vertex] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        while(!q.isEmpty()){
            int v = q.poll();
            for(int i = 0; i<isConnected.length; i++){
                if(!visited[i] && isConnected[v][i] == 1){
                    visited[i] = true;
                    q.add(i);
                }
            } 
        }
    }
}
*/
//Using dfs
/*
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        boolean[] visited = new boolean[v];
        int countProvinces = 0;
        for(int i = 0; i<v; i++){
            if(!visited[i]){
                dfs(i,isConnected,visited);
                countProvinces++;
            }
        }
        return countProvinces;
    }
    public void dfs(int vertex,int[][] isConnected,boolean[] visited){
        visited[vertex] = true;
        for(int i = 0; i<isConnected.length; i++){
            if(!visited[i] && isConnected[vertex][i] == 1){
                dfs(i,isConnected,visited);
            }
        }
    }
}
*/