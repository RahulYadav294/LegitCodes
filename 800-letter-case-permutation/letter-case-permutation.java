class Solution {
    public List<String> letterCasePermutation(String s) {
       List<String> result = new ArrayList<>();
       if(s.length() == 0) return result;
       helper(s,result,"");
       return result; 
    }
    public void helper(String s,List<String> result, String ans){
        if(s.length() == 0){
            result.add(ans);
            return;
        }
        char firstChar = s.charAt(0);
        if(Character.isLetter(s.charAt(0))){
            helper(s.substring(1),result,ans + Character.toUpperCase(firstChar));
            helper(s.substring(1),result,ans + Character.toLowerCase(firstChar));
        }else{
            helper(s.substring(1),result,ans + firstChar);
        }
    }
}