class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        
        Collections.sort(list);
        int unique = map.size();
        for(int i : list){
            if(k >= i){
                k-=i;
                unique--;
            }else{
                break;
            }
        }
        return unique;
    }
}