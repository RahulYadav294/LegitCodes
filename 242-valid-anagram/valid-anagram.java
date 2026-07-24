//Approach_2
class Solution {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
           char ch = s.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)+1); 
        }

         for(int i = 0; i<t.length(); i++){
           char ch = t.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)-1); 
        }
        for(int num : map.values()){
            if(num != 0)
            return false;
        }
        return true;
}
}
// Approach_1
/*
class Solution {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] isValid = new int[26];
        for(int i = 0; i<s.length(); i++){
            isValid[s.charAt(i) - 'a']++;
            isValid[t.charAt(i) - 'a']--;
        }
        for(int num : isValid){
            if(num!=0){
                return false;
            }
        }
        return true;
    }
}
*/