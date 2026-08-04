class Q{
    int node;
    Q(int node){
        this.node = node;
    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int v = rooms.size();
        boolean[] visited = new boolean[v];
        Queue<Q> q = new LinkedList<>();
        q.add(new Q(0));
        visited[0] = true;
        int count = 0;
        while(!q.isEmpty()){
            Q curr = q.poll();
                count++;
            for(int node : rooms.get(curr.node)){
                if(!visited[node]){
                    visited[node] = true;
                    q.offer(new Q(node));
                }
            }
        }
        return count == v ;
    }
}