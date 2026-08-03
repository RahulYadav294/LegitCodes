class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int v = rooms.size();
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
                count++;
            for(int node : rooms.get(curr)){
                if(!visited[node]){
                    visited[node] = true;
                    q.offer(node);
                }
            }
        }
        return count == v ;
    }
}