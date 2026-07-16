class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int row = 0; row<m; row++){
            for(int col = 0; col<n; col++){
                if(grid[row][col] == 2){
                   q.add(new int[]{row,col});
                }
                else if(grid[row][col] == 1){
                  fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int minute = 0;
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            minute++;
            for(int i = 0; i<size; i++){
                int[] curr = q.poll();
                for(int[] direction : directions){
                    int newRow = curr[0] + direction[0];
                    int newCol = curr[1] + direction[1];
                    if(newRow < m && newRow >=0 && newCol < n && newCol >=0 && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        fresh--;
                        q.offer(new int[] {newRow,newCol});
                    }
                }
            }
        }
        if(fresh != 0) return -1;
    return minute-1;
    }
   
}