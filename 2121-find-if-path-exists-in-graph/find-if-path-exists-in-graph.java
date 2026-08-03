
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
         return bfs(graph,visited,source,destination);
        
    }
    public boolean bfs(List<List<Integer>> graph,boolean[] visited,int src,int dst){
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == dst) return true;
            for(int edge  : graph.get(curr)){
                if(!visited[edge]){
                    visited[edge] = true;
                    q.add(edge);
                }
            }
        }
        return false;
    }
}




/*
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
         return dfs(graph,visited,source,destination);
        
    }
    public boolean dfs  (List<List<Integer>> graph,boolean[] visited ,int source,int destination){
        if(source == destination) return true;
            visited[source] = true;
            for(int g : graph.get(source)){
                if(!visited[g]){
                    if(dfs(graph,visited,g,destination)){
                        return true;
                    }
                }
            }
            return false;
        }
}
*/