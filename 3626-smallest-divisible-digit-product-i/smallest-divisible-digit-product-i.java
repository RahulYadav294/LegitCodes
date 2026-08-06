class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;
        
        while(true){
            if(findProduct(num,t)){
                break;
            }
            num++;
        }
        return num;
    }
    public boolean findProduct(int num, int t){
        int sum = 1;
        while(num > 0){
            int digit = num % 10;
            sum*=digit;
            num/=10;
        }
        return sum % t == 0;
    }
}