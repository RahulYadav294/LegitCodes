class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);
        for(int i = 0; i<n; i++){
           pq.offer(nums[i]);
           if(pq.size() > k){
            pq.poll();
           }

        }
        return pq.peek();
    }
}