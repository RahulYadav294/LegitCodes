class Solution {
    public static int totalNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        boolean[] used = new boolean[digits.length];
        totalNumber(digits,used,0,0,set);
        return set.size();
        }
    public static void totalNumber(int[] digits,boolean[] used,int index,int sum,Set<Integer> set){
        if(index == 3){
            set.add(sum);
            return;
    }
    for(int i = 0; i<digits.length; i++){
        if(used[i]) continue;
        if(index == 0 && digits[i] == 0) continue;
        if(index == 2 && digits[i] % 2!=0) continue;
        used[i] = true;
        totalNumber(digits, used, index+1,sum*10+digits[i],set);
        used[i] = false;
    }
    

    }
   
}