// Approach_2 using stringBuilder as stack
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(sb.length() >0 && ch == sb.charAt(sb.length()-1)){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
 //Approach_1 using stack
 /*
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if( !stack.isEmpty() && ch == stack.peek()){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        if(stack.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char ch = stack.peek();
            sb.append(ch);
            stack.pop();
        }
        return  sb.reverse().toString();
    }
}
*/