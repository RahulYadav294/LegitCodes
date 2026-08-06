class Pair{
    int row;
    int col;
    int remK;
    Pair(int row,int col,int remK){
        this.row = row;
        this.col = col;
        this.remK = remK;
    }
}
class Solution {

    int steps = 0;
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k+1];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,k));
        visited[0][0][k] = true;
        int[][] directions ={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int ks  = curr.remK;
            if(row == m-1 && col == n-1){
                return steps;
            }
            for(int[] dir : directions){
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;
               if(newRow >=0 && newRow <m && newCol >=0 && newCol <n){

                if(!visited[newRow][newCol][ks] && grid[newRow][newCol] == 0){
                    visited[newRow][newCol][ks] = true;
                    q.offer(new Pair(newRow,newCol,ks));
                }
               else if (grid[newRow][newCol] == 1 &&
         ks > 0 &&
         !visited[newRow][newCol][ks - 1]) {

                    visited[newRow][newCol][ks-1] = true;
                     q.offer(new Pair(newRow,newCol,ks-1));
                }
               }
            }
        }
         steps++;

        }
        return -1;
        
    }
}