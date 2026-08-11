class Solution {
    int[] parent;
    int[] rank;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        rank   = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
        Map<String,Integer> map = new HashMap<>();
       for(int i = 0; i<n; i++){
        String name = accounts.get(i).get(0);
        for(int j = 1; j<accounts.get(i).size(); j++){
            String oldEmails = accounts.get(i).get(j);
            if(map.containsKey(oldEmails)){
                int u = map.get(oldEmails);
                union(i,u);
            }else{
                map.put(oldEmails,i);
            }
       }
    }
        Map<Integer, List<String>> groups = new HashMap<>();
        for(String email : map.keySet()){
            int account = map.get(email);
            int root    = findP(account);
            groups.putIfAbsent(root,new ArrayList<>());
            groups.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();

for (int root : groups.keySet()) {

    List<String> emails = groups.get(root);

    Collections.sort(emails);

    List<String> account = new ArrayList<>();

    account.add(accounts.get(root).get(0)); // name
    account.addAll(emails);

    result.add(account);
}

return result;

       }
        

    public int findP(int x){
       if(parent[x] == x){
        return x;
       }
       return parent[x] = findP(parent[x]);
    }
    public void union(int u, int v){
        int pA = findP(u);
        int pB = findP(v);
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