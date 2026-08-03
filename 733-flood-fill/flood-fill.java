class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;
        int orgColor = image[sr][sc];
        if (orgColor == color) {
            return image;
        }
        helper(image,sr,sc,row,col,orgColor,color);
        return image;
    }
    public void helper(int[][] image,int sr,int sc,int row,int col,int orgColor,int color){
        if(sr < 0 || sr >= row || sc < 0 || sc >= col || image[sr][sc] != orgColor){
            return;
        }
        image[sr][sc] = color;
        helper(image,sr+1,sc,row,col,orgColor,color);
        helper(image,sr,sc+1,row,col,orgColor,color);
        helper(image,sr-1,sc,row,col,orgColor,color);
        helper(image,sr,sc-1,row,col,orgColor,color);
    }
}


/*
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
*/