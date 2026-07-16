class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] neighbor : prerequisites){
            int u = neighbor[0];
            int v = neighbor[1];
            graph.get(v).add(u);
            inDegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int courseComplete = 0;
        while(!q.isEmpty()){
            int nextCourse = q.poll();
            courseComplete++;
            for(int neighbor : graph.get(nextCourse)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        if(courseComplete == numCourses) return true;
        return false;
    }
}