
/*
class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int start = 0; start<n; start++){
            int fuel = 0;
            boolean possible = true;
            for(int count = 0; count<n; count++){
                int i = (start + count) % n;
                fuel+=gas[i];
                fuel-=cost[i];
                if(fuel < 0){
                    possible = false;
                    break;
                }
            }
            if(possible) return start;
        }
        return -1;
    }
}
*/


class Solution {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;    
        int start = 0;    
        int total = 0;   

        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            tank += gain;
            total += gain;
            if (tank < 0) {
                start = i + 1; 
                tank = 0;      
            }
        }
        return total>= 0 ? start : -1;
    }
}

