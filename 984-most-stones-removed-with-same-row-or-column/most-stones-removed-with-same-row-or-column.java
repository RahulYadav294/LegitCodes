class Solution {
    public int removeStones(int[][] stones) {
        int row = stones.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<row; i++){
            graph.add(new ArrayList());
        }
        for(int i = 0; i<row; i++){
            for(int j = i+1; j<row; j++){
                if(stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]){
                graph.get(i).add(j);
                graph.get(j).add(i);
                    }
            }
        }
        boolean[] visited = new boolean[row];
        int comp = 0;
        for(int i = 0; i<row; i++){
            if(!visited[i]){
                comp++;
                bfs(graph,i,visited);
            }
        }
        return stones.length - comp;
    }
    public void bfs(List<List<Integer>> graph,int vertex,boolean[] visited){
         Queue<Integer> q = new LinkedList<>();
         q.offer(vertex);
        visited[vertex] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neighbor : graph.get(curr)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }
}