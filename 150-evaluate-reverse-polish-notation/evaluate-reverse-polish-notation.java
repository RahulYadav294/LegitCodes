class Solution {
    int computeIt(int first,int second,String token){
        if("+".equals(token)){
            return first + second;
        }else if("-".equals(token)){
            return first - second;
        }else if("*".equals(token)){
            return first * second;
        }else{
            return first / second;
        }
       
    }
    public int evalRPN(String[] tokens) {
     Stack<Integer> stack = new Stack<>();
     for(String token : tokens){
        if("+".equals(token) ||
            "-".equals(token) ||
            "*".equals(token)||
            "/".equals(token)){
                int second = stack.pop();
                int first = stack.pop();
                int result = computeIt(first,second,token);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
     }   
     return stack.peek();
    }
}