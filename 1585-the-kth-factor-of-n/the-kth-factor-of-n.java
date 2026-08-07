class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i*i<=n; i++){
        if(n % i == 0){
            if(n/i == i){
                list.add(i);
            }else{
                list.add(i);
                list.add(n/i);
            }
        }
    }
    if (list.size() < k) return -1;
    Collections.sort(list);
    return list.get(k-1);
}
}