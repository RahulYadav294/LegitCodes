class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
         if(pattern.length() != ss.length) return false;
        Map<Character,String> map1 = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();
        for(int i = 0; i<pattern.length(); i++){
            char  ch = pattern.charAt(i);
            String str = ss[i];
            if(map1.containsKey(ch)){
                if(!map1.get(ch).equals(str)){
                    return false;
            }
            }else{
                map1.put(ch,str);
            }
            if(map2.containsKey(str)){
                if(!map2.get(str).equals(ch)){
                    return false;
                }
            }else{
                map2.put(str,ch);
            }
        }
        return true;
    }
}