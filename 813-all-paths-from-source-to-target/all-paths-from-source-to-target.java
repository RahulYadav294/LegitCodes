class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> bigList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfsHelper(graph,bigList,list,0);
        return bigList;
       }
    
    public void dfsHelper(int[][] graph, List<List<Integer>> bigList,List<Integer> list,int source){
            list.add(source);
        if(source == graph.length-1){
            bigList.add(new ArrayList<>(list));
            return;
        }
        for(int neighbor : graph[source]){
            dfsHelper(graph,bigList,list,neighbor);
            list.remove(list.size()-1);
        }
    }
}