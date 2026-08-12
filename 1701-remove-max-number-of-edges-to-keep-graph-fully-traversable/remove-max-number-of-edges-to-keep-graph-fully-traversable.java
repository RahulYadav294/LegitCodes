class Solution {

    class Dsu {

        int[] parent;
        int[] rank;

        Dsu(int n) {

            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int findP(int x) {

            if (parent[x] == x) {
                return x;
            }

            return parent[x] = findP(parent[x]);
        }

        boolean union(int a, int b) {

            int pA = findP(a);
            int pB = findP(b);

            if (pA == pB) {
                return false;
            }

            if (rank[pA] < rank[pB]) {

                parent[pA] = pB;

            } else if (rank[pB] < rank[pA]) {

                parent[pB] = pA;

            } else {

                parent[pA] = pB;
                rank[pB]++;
            }

            return true;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        Dsu alice = new Dsu(n);
        Dsu bob = new Dsu(n);

        int aliceComp = n;
        int bobComp = n;

        int removed = 0;

        // 1. Process Type 3 first
        for (int[] edge : edges) {

            if (edge[0] != 3) {
                continue;
            }

            int u = edge[1];
            int v = edge[2];

            boolean aliceUsed = alice.union(u, v);
            boolean bobUsed = bob.union(u, v);

            if (aliceUsed) {
                aliceComp--;
            }

            if (bobUsed) {
                bobComp--;
            }

            // Both already connected → useless edge
            if (!aliceUsed && !bobUsed) {
                removed++;
            }
        }

        // 2. Type 1 → Alice
        for (int[] edge : edges) {

            if (edge[0] != 1) {
                continue;
            }

            int u = edge[1];
            int v = edge[2];

            if (alice.union(u, v)) {
                aliceComp--;
            } else {
                removed++;
            }
        }

        // 3. Type 2 → Bob
        for (int[] edge : edges) {

            if (edge[0] != 2) {
                continue;
            }

            int u = edge[1];
            int v = edge[2];

            if (bob.union(u, v)) {
                bobComp--;
            } else {
                removed++;
            }
        }

        // Both Alice and Bob must be fully connected
        if (aliceComp == 1 && bobComp == 1) {
            return removed;
        }

        return -1;
    }
}