class Solution {
    int steps = 0;
    class Pair{
        int node;
        int mask;
        Pair(int node, int mask){
            this.node = node;
            this.mask = mask;
        }
    }
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int finalMask = (1<<n)-1;
        boolean[][] visited = new boolean[n][1<<n];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            int mask = (1<<i);
            q.offer(new Pair(i,mask));
            visited[i][mask] = true;
        }
    while(!q.isEmpty()){
        int size = q.size();
        for(int i = 0; i<size; i++){
            Pair curr = q.poll();
            int vertex = curr.node;
            int mask = curr.mask;
            if(mask == finalMask) return steps;
            for(int neighbor : graph[vertex]){
                int newMask = mask |(1<<neighbor);

                if(!visited[neighbor][newMask]){
                    visited[neighbor][newMask] = true;
                    q.offer(new Pair(neighbor,newMask));
                }
            }
        }
        steps++;
    }
return -1;
        }
   }
