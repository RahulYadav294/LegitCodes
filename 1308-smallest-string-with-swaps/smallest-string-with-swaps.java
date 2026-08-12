class Solution {
    int[] parent;
    int[] rank;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        rank   = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
            for(List<Integer> lis : pairs){
                int u = lis.get(0);
                int v = lis.get(1);
                union(u,v);
            }
        Map<Integer, List<Character>> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            int root = findP(i);
            map.putIfAbsent(root, new ArrayList<>());
            map.get(root).add(s.charAt(i));
        }
        for(List<Character> res : map.values()){
            Collections.sort(res);
        }
        char[] arr = new char[n];

        Map<Integer, Integer> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = findP(i);

            int p = pos.getOrDefault(root, 0);

            arr[i] = map.get(root).get(p);

            pos.put(root, p + 1);
        }
        return new String(arr);

    }
    public int findP(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = findP(parent[x]);
    }
    public void union(int a, int b){
        int pA = findP(a);
        int pB = findP(b);
        if(rank[pA] < rank[pB]){
            parent[pA] = pB;
        }else if(rank[pB] < rank[pA]){
            parent[pB] = pA;
        }else{
            parent[pA] = pB;
            rank[pB]++;
        }
    }
}