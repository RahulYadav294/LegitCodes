class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int s1 = str1.length();
        int s2 = str2.length();
        while(s2!=0){
            int rem = s1 % s2;
            s1 = s2;
            s2 = rem;
        }
        int gcd = s1;
        String s3 = str1.substring(0,gcd);
        for(int i = 0; i<str1.length();i+=gcd){
            if(!str1.substring(i,i+gcd).equals(s3)){
                return "";
            }
        }
        for(int i = 0; i<str2.length();i+=gcd){
            if(!str2.substring(i,i+gcd).equals(s3)){
                return "";
            }
        }
        return s3;
    }
}