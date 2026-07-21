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