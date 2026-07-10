class Solution {
    public boolean palindrome(String part){
        int low = 0;
        int high = part.length()-1;
        while( low <= high){
            if(part.charAt(low) != part.charAt(high)){
                return false;
            }else{
                low++;
                high--;
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
       List<List<String>> list = new ArrayList<>();
       if(s.length() == 0) return list;
       List<String> current = new ArrayList<>();
       helper(s,0,list,current);
       return list; 
    }
    public void helper(String s,int index,List<List<String>> list,List<String> current){
        if(index == s.length()){
            list.add(new ArrayList<>(current));
            return;
        }
        for(int i = index; i< s.length(); i++){
            String part = s.substring(index,i+1);
            if(palindrome(part)){
                current.add(part);
                helper(s,i+1,list,current);
                current.remove(current.size()-1);
            }
        }
    }
}