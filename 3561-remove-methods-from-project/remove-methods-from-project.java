class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph  = new ArrayList<>();
        boolean[] suspicious = new boolean[n];
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : invocations){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        suspicious[k] = true;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            for(int edge : graph.get(node)){
                if(!suspicious[edge]){
                    suspicious[edge] = true;
                    q.offer(edge);
                }
            }
        }
        for(int[] edge : invocations){
            int u = edge[0];
            int v = edge[1];
            if(!suspicious[u] && suspicious[v]){
                for(int i = 0; i<n; i++){
                    list.add(i);
                }
                return list;
            }
        }
        for(int i = 0; i<n; i++){
            if(!suspicious[i]){
                list.add(i);
            }
        }
    return list;
    }
}