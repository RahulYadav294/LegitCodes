class Solution {
    public int minCostConnectPoints(int[][] points) {
        int v = points.length;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i<v; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<v; i++){
            for(int j = i+1; j<v; j++){
                int cost = Math.abs(points[i][0] - points[j][0]) +
                            Math.abs(points[i][1] - points[j][1]);
                graph.get(i).add(new int[]{j,cost});
                 graph.get(j).add(new int[]{i,cost});
            }
        }
        int minCost = 0;
        boolean[] visited = new boolean[v];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int vertex = curr[0];
            int cost = curr[1];
            if(visited[vertex]) continue;
            visited[vertex] = true;
            minCost+=cost;
            for(int[] neighbor : graph.get(vertex)){
                int node = neighbor[0];
                int weight = neighbor[1];
                if(!visited[node]){
                    pq.offer(new int[]{node,weight});
                }
            }
        }
        return minCost;
    }
}