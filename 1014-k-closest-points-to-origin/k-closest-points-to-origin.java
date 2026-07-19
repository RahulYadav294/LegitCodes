class Solution {
    public int[][] kClosest(int[][] points, int k) { 
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[2],a[2]));
        for(int[] point : points){ 
        double dist = Math.sqrt(point[0] * point[0] +
                                        point[1] * point[1]);

            pq.offer(new double[]{point[0],point[1],dist});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
     for (int i = 0; i < k; i++) {
            double[] p = pq.poll();
            ans[i][0] = (int) p[0];
            ans[i][1] = (int) p[1];
        }
        return ans;
    }
}