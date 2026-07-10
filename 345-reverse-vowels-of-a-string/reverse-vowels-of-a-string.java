class Solution {
    public boolean vowel(char ch){
        ch = Character.toLowerCase(ch);
        if( ch == 'a' ||
            ch == 'e' ||
            ch == 'i' ||
            ch == 'o' ||
            ch == 'u'){
                return true;
            }
            return false;
    }
    public String reverseVowels(String s) {
       char[] ch = s.toCharArray();
       int low = 0;
       int high = s.length()-1;
       while(low < high){
        if(!vowel(ch[low])){
            low++;
        }else if(!vowel(ch[high])){
            high--;
        }else{
            char temp = ch[low];
            ch[low] = ch[high];
            ch[high] = temp;
            low++;
            high--;
        }
       } 
       return new String(ch);
    }
}