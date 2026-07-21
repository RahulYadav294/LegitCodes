class Solution {
    public boolean backspaceCompare(String s, String t) {
       String s1 = removeBackSpace(s);
       String s2 = removeBackSpace(t) ;
       return s1.equals(s2);
    }
String removeBackSpace(String s1){
    StringBuilder sb = new StringBuilder();
    for(char ch : s1.toCharArray()){
        if(ch != '#'){
            sb.append(ch);
        }else if(sb.length() > 0 && ch == '#'){
            sb.deleteCharAt(sb.length()-1);
        }
    }
    return sb.toString();
}
}