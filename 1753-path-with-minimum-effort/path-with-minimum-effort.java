class Solution {
    public int minimumEffortPath(int[][] heights) {
       int rows = heights.length;
       int cols = heights[0].length;
       int[][] effort = new int[rows][cols];
       for(int[] n : effort){
        Arrays.fill(n,Integer.MAX_VALUE);
       }
       effort[0][0] = 0;
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
       pq.offer(new int[]{0,0,0});
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},
            {0,-1}};
            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                int e = curr[0];
                int row = curr[1];
                int col = curr[2];
                if(row == rows-1 && col == cols-1){
                    return e;
                }
                if(e > effort[row][col]) continue;
                for(int[] direction : directions){
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if(newRow >= rows || newCol >=cols || newRow <0 || 
                        newCol <0){
                            continue;
                        }
                        int diff = Math.abs(heights[newRow][newCol] -heights[row][col]);
                        int newEffort = Math.max(effort[row][col],diff);
                        if(newEffort < effort[newRow][newCol]){
                            effort[newRow][newCol] = newEffort;
                            pq.offer(new int[]{newEffort,newRow,newCol});
                        }
                }
            }

  return effort[rows - 1][cols - 1];
    }
}