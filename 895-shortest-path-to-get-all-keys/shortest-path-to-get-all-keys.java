class Solution {

    class Pair {
        int row;
        int col;
        int mask;

        Pair(int row, int col, int mask) {
            this.row = row;
            this.col = col;
            this.mask = mask;
        }
    }

    public int shortestPathAllKeys(String[] grid) {

        int m = grid.length;
        int n = grid[0].length();

        int startRow = 0;
        int startCol = 0;
        int keys = 0;

        // Find start position and count keys
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = grid[i].charAt(j);

                if (Character.isLowerCase(ch)) {
                    keys++;
                } else if (ch == '@') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int finalMask = (1 << keys) - 1;

        boolean[][][] visited = new boolean[m][n][1 << keys];

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(startRow, startCol, 0));
        visited[startRow][startCol][0] = true;

        int steps = 0;

        int[][] directions = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                Pair curr = q.poll();

                int row = curr.row;
                int col = curr.col;
                int mask = curr.mask;

                // All keys collected
                if (mask == finalMask)
                    return steps;

                for (int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                        continue;

                    char ch = grid[newRow].charAt(newCol);

                    if (ch == '#')
                        continue;

                    int newMask = mask;

                    // Key
                    if (Character.isLowerCase(ch)) {
                        int index = ch - 'a';
                        newMask = mask | (1 << index);
                    }

                    // Lock
                    if (Character.isUpperCase(ch)) {
                        int index = ch - 'A';

                        if ((mask & (1 << index)) == 0)
                            continue;
                    }

                    if (!visited[newRow][newCol][newMask]) {
                        visited[newRow][newCol][newMask] = true;
                        q.offer(new Pair(newRow, newCol, newMask));
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}