class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int openBracket  =  0;
        int add = 0;
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                openBracket++;
            }else{
                if(openBracket > 0){
                openBracket--;
                }else{
                    add++;
                }
            }
        }
        return openBracket + add;
    }
}