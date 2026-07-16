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
    