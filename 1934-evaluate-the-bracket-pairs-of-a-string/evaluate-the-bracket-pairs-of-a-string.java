class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String,String> map = new HashMap<>();
        for(List<String> lis : knowledge){
            String name = lis.get(0);
            String value = lis.get(1);
            map.put(name,value);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(c == '('){
                StringBuilder ss = new StringBuilder();
                int j = i + 1;
                while(s.charAt(j) != ')'){
                    ss.append(s.charAt(j));
                    j++;
                }
                i = j;
                if(map.containsKey(ss.toString())){
                    sb.append(map.get(ss.toString()));
                }else{
                    sb.append("?");
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}