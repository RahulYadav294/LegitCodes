class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        int low = 0;
        int high = sb.length()-1;
        while(low <= high){
            if(sb.charAt(low) != sb.charAt(high)){
                return false;
            }else{
                low++;
                high--;
            }
        }
        return true;
    }
}