class Solution {
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        pq.offer(1L);
        set.add(1L);

        long ugly = 1;

        for (int i = 0; i < n; i++) {

            ugly = pq.poll();

            long x = ugly * 2;
            long y = ugly * 3;
            long z = ugly * 5;

            if (set.add(x))
                pq.offer(x);

            if (set.add(y))
                pq.offer(y);

            if (set.add(z))
                pq.offer(z);
        }

        return (int) ugly;
    }
}