class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int vertex = 0; vertex<n; vertex++){
            if(colors[vertex] == 0){
                if(!dfsHelper(vertex,1,colors,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfsHelper(int vertex,int color,int[] colors,int[][] graph){
        colors[vertex] = color;
        for(int neighbor : graph[vertex]){
            if(colors[neighbor] == 0){
                int oppositeColor = colors[vertex] == 1?2:1;
                if(!dfsHelper(neighbor,oppositeColor,colors,graph)){
                    return false;
                }
            }else if(colors[neighbor] == color){
                return false;
            }
        }
        return true;
    }
}