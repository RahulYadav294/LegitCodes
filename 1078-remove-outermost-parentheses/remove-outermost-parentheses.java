class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int bal = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                if(bal > 0 ){
                    sb.append(ch);
                }
                bal++;
            }else{
                bal--;
                if(bal > 0){
                sb.append(ch);
                }
            } 
        }
        return sb.toString();
    }
}