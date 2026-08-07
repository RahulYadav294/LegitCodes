class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 1) return false;
     int sum = 0;
     for(int i = 1; i*i<=num; i++){
            if(num % i == 0){
                if(num/i == i ){
                    sum+=i;
                }else{
                    if(num/i == num){
                        sum+=i;
                    }else{
                        sum+=i;
                        sum+=num/i;;
                    }
                }
                
            }
        }

    
     return sum == num;

    }
}