class Solution {
    public static boolean isPowerOfTwo(int n) {
        int count = Integer.bitCount(n);
        return n > 0 && count == 1;
    }
}

/*
class Solution {
    public static boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        if(n<=0 || n%2!=0){
            return false;
        }
        return isPowerOfTwo(n/2);
    }
}
*/