class Solution {
    public int balancedStringSplit(String s) {
        int n = s.length();
        int bal = 0;
        int split = 0;
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == 'R'){
                bal++;
            }else{
                bal--;
            }
            if(bal == 0){
                split++;
            }
        }
        return split;
    }
}