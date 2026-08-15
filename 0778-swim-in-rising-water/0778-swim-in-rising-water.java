class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // {maximum elevation so far, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int time = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (visited[r][c]) {
                continue;
            }

            visited[r][c] = true;

            // Reached the destination
            if (r == n - 1 && c == n - 1) {
                return time;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n
                        && !visited[nr][nc]) {

                    int newTime = Math.max(time, grid[nr][nc]);

                    pq.offer(new int[]{newTime, nr, nc});
                }
            }
        }

        return -1;
    }
}