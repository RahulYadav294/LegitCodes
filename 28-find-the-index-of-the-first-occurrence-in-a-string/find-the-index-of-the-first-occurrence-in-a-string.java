class Solution {
    public int strStr(String haystack, String needle) {
        int i = haystack.length();
        int j = needle.length();
        
        for(int start = 0; start<=i-j; start++){
            int m = 0;
            while(m < j && haystack.charAt(start + m) == needle.charAt(m) ){
                m++;
            }
            if(j == m){
                return start;
            }
        }
        return -1;
        
    }
}