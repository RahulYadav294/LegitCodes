class Solution {
   static  String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if(digits.length() == 0) return result;
     helper(digits,map,result,"");
    return result;
    }
    public static void helper(String digits,String[] map,List<String> result,String curr){
        if(digits.length() == 0){
            result.add(curr);
            return;
        }
        int digit = digits.charAt(0) - '0';
        String letters = map[digit];
        for(int i = 0; i < letters.length(); i++){
            char firstChar = letters.charAt(i);
            helper(digits.substring(1),map,result,curr + firstChar);
        }
    }
    
  
}