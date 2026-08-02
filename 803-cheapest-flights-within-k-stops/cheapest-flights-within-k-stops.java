class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // {node, cost, stops}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int vertex = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (stops > k)
                continue;

            for (int[] edge : graph.get(vertex)) {

                int neighbor = edge[0];
                int price = edge[1];

                if (cost + price < dist[neighbor]) {

                    dist[neighbor] = cost + price;

                    q.offer(new int[]{neighbor, cost + price, stops + 1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
