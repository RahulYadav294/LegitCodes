class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int m = image.length;
       int n = image[0].length;
       int orgColor = image[sr][sc];
        boolean[][] visited = new boolean[m][n];
        dfs(image,sr,sc,orgColor,color,visited,m,n);
        return image; 
    }
    public void dfs(int[][] image, int sr,int sc,int orgColor,int color,boolean[][] visited,int m,int n){
        if(sr >= m || sr < 0 || sc >= n|| sc < 0 || visited[sr][sc] || image[sr][sc] != orgColor  ){
            return;
        }
        visited[sr][sc] = true;
        image[sr][sc] = color;
        dfs(image,sr,sc+1,orgColor,color,visited,m,n);
        dfs(image,sr+1,sc,orgColor,color,visited,m,n);
        dfs(image,sr,sc-1,orgColor,color,visited,m,n);
        dfs(image,sr-1,sc,orgColor,color,visited,m,n);

    }
}