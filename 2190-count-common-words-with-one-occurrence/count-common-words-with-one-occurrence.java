class Solution {
    public int countWords(String[] words1, String[] words2) {
      int m = words1.length;
      int n = words1.length;
      int counts = 0;
     for(int i = 0; i<words1.length; i++){
        int cnt1 = 0;
        int cnt2 = 0;
        for(int j = 0; j<words1.length; j++){
            if(words1[i].equals(words1[j])){
                cnt1++;
            }
        }
     for(int j = 0; j<words2.length; j++){
            if(words1[i].equals(words2[j])){
                cnt2++;
            }
        }
        if(cnt1 == 1 && cnt2 == 1){
            counts++;
        }
     }
     return counts;
    }
}