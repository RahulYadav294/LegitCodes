class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
         dfs(graph,visited,source,destination);
         return visited[destination];
    }
    public void dfs  (List<List<Integer>> graph,boolean[] visited ,int source,int destination){
            visited[source] = true;
            for(int g : graph.get(source)){
                if(!visited[g]){
                    dfs(graph,visited,g,destination);
                }
            }
        }
}