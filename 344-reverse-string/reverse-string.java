class Solution {
    public void reverseString(char[] s) {
        int high = s.length-1;
        int low = 0;
        while(low <= high){
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}