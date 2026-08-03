class Solution {
    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid,i,j,row,col);
                }
            }
        }
        return count;
    }
    public static void bfs(char grid[][],int sr,int sc,int m,int n){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        grid[sr][sc] = '0';
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int rows = curr[0];
            int cols = curr[1];
            for(int[] direction : directions){
                int newRow = direction[0] + rows;
                int newCol = direction[1] + cols;
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == '1'){
                    grid[newRow][newCol] = '0';
                    q.offer(new int[]{newRow,newCol});
                    }
            }
        }
    }
}




/*
class Solution {
    public static int numIslands(char[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       boolean[][] visited = new boolean[m][n];
       int count = 0;
       for(int row = 0; row<m; row++){
        for(int col = 0; col<n; col++){
            if(!visited[row][col] && grid[row][col] == '1'){
                bfs(grid,row,col,visited,m,n);
                count++;
            }
        }
       }
       return count;
    }
    public static void bfs(char[][] grid,int row,int col,boolean[][] visited,int m,int n){
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col] == '0' ||visited[row][col]){
            return;
        }
        visited[row][col] = true;
    bfs(grid,row,col+1,visited,m,n);
    bfs(grid,row,col-1,visited,m,n);
    bfs(grid,row+1,col,visited,m,n);
    bfs(grid,row-1,col,visited,m,n);
    }
}
*/   