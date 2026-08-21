class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int max = Integer.MIN_VALUE;
        for(int h = 0; h<=n; h++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if(citations[j] >= h){
                   count++;
                }
            }
            if(count >= h){
             max = Math.max(max, h);
            }
        }
        return max;
    }
}