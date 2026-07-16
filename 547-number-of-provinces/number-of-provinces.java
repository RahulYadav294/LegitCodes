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