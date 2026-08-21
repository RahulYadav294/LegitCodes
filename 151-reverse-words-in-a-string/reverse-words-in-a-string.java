class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
       String[] words = s.split(" ");
       for(int j = words.length-1; j >=0; j--){
        sb.append(words[j]);
        if( j !=0){
            sb.append(" ");
        }

       }
       return sb.toString();
    }
}