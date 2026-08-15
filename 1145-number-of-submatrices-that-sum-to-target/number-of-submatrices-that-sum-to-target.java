class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for(int top = 0; top<m; top++){
            int[] cols = new int[n];
            for(int bottom = top; bottom<m; bottom++){
                for(int i = 0; i<n; i++){
                    cols[i]+=matrix[bottom][i];
                }
                Map<Integer,Integer> map = new HashMap<>();
                map.put(0,1);
                int sum = 0;
                for(int i = 0; i<cols.length; i++){
                    sum+=cols[i];
                    int prev = sum-target;
                    if(map.containsKey(prev)){
                        count+=map.get(prev);
                    }
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return count;
    }
}




/*
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for(int top = 0; top<m; top++){
            for(int bottom = top; bottom<m; bottom++){
                for(int left = 0; left<n; left++){
                    for(int right = left; right<n; right++){
                        int sum = 0;
                        for(int i = top; i<=bottom; i++){
                            for(int j = left; j<=right; j++){
                                sum+=matrix[i][j];
                            }
                        }
                         if(sum == target) count++;
                    }
                }
            }
        }
        return count;
    }
}
*/