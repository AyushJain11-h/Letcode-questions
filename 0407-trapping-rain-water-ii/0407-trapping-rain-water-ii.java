import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );

        // Add boundary cells
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int water = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();

            for (int[] d : dirs) {
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];

                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y])
                    continue;

                visited[x][y] = true;
                water += Math.max(0, cell[2] - heightMap[x][y]);
                pq.offer(new int[]{
                    x,
                    y,
                    Math.max(cell[2], heightMap[x][y])
                });
            }
        }

        return water;
    }
}
