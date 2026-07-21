class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
       Stack<Integer> stack = new Stack<>();
       int[] res = new int[n];
       for(int day = 0; day<n; day++){
        while(!stack.isEmpty() && temperatures[day] > temperatures[stack.peek()]){
           int currDay = day;
           int prevDay = stack.peek();
           int diff = currDay - prevDay;
           res[prevDay] = diff;
           stack.pop();
        }
        stack.push(day);
       }
       return res; 
    }
}