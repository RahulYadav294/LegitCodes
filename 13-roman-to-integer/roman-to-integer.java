class Solution {
    public static int romanToInt(String s) {
        int[] value = {1000,500,100,50,10,5,1};
        char[] symbol = {'M','D','C','L','X','V','I'};
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<symbol.length; i++){
            map.put(symbol[i],value[i]);
        }
        int numeric = 0;
        for(int i = 0; i<s.length(); i++){
            int curr = map.get(s.charAt(i));
            if(i+1<s.length() && curr< map.get(s.charAt(i+1))){
                numeric-=curr;
            }
            else{
                numeric+= curr;
            }
        }
        return numeric;
    }
}