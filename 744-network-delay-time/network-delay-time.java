class Edge{
    int to;
    int weight;
    Edge(int to,int weight){
        this.to = to;
        this.weight = weight;
    }
}
class Pair{
    int node;
    int distance;
    Pair(int node,int distance){
        this.node = node;
        this.distance = distance;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new Edge(v,w));
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.distance,b.distance));
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int vertex = curr.node;
            int weight = curr.distance;
            if(weight > distance[vertex]) continue;
            for(Edge edge : graph.get(vertex)){
                int next = edge.to;
                int wt = edge.weight;
                if(weight + wt < distance[next]){
                    distance[next] = weight + wt;
                     pq.offer(new Pair(next, wt + weight));
                }
            }
        }
        int ans = 0;
        for(int i = 1; i<=n; i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans,distance[i]);
        }
        return ans;
    }
}