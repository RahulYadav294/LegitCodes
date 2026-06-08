class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map1 = new HashMap<>();
         Map<Character,Character> map2 = new HashMap<>();

         for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            char c = t.charAt(i);
            if(map1.containsKey(ch) && map1.get(ch) != c){
                return false;
            }
              if(map2.containsKey(c) && map2.get(c) != ch){
                return false;
            }
            map1.put(ch,c);
            map2.put(c,ch);
         }
         return true;
    }
}