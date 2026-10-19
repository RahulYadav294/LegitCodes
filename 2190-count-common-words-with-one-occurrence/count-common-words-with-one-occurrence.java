class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(int i = 0; i<words1.length; i++){
            map1.put(words1[i],map1.getOrDefault(words1[i],0) + 1);
        }
        for(int i = 0; i<words2.length; i++){
            map2.put(words2[i],map2.getOrDefault(words2[i],0) + 1);
        }
        int count = 0;
        
        for (String word : map1.keySet()) {
            if (map1.get(word) == 1 &&
                map2.getOrDefault(word, 0) == 1) {
                count++;
            }
        }
        return count;
    }
}

/*
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
*/