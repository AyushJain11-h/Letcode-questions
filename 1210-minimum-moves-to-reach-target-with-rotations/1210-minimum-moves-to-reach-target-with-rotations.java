import java.util.*;

class Solution {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        boolean[][][] visited = new boolean[n][n][2];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 0, 0}); // row, col, orientation, moves
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dir = cur[2], moves = cur[3];

            if (r == n - 1 && c == n - 2 && dir == 0) {
                return moves;
            }

            if (dir == 0) { // Horizontal
                // Move Right
                if (c + 2 < n && grid[r][c + 2] == 0 && !visited[r][c + 1][0]) {
                    visited[r][c + 1][0] = true;
                    queue.offer(new int[]{r, c + 1, 0, moves + 1});
                }

                // Move Down
                if (r + 1 < n &&
                    grid[r + 1][c] == 0 &&
                    grid[r + 1][c + 1] == 0) {

                    if (!visited[r + 1][c][0]) {
                        visited[r + 1][c][0] = true;
                        queue.offer(new int[]{r + 1, c, 0, moves + 1});
                    }

                    // Rotate Clockwise
                    if (!visited[r][c][1]) {
                        visited[r][c][1] = true;
                        queue.offer(new int[]{r, c, 1, moves + 1});
                    }
                }

            } else { // Vertical
                // Move Down
                if (r + 2 < n && grid[r + 2][c] == 0 && !visited[r + 1][c][1]) {
                    visited[r + 1][c][1] = true;
                    queue.offer(new int[]{r + 1, c, 1, moves + 1});
                }

                // Move Right
                if (c + 1 < n &&
                    grid[r][c + 1] == 0 &&
                    grid[r + 1][c + 1] == 0) {

                    if (!visited[r][c + 1][1]) {
                        visited[r][c + 1][1] = true;
                        queue.offer(new int[]{r, c + 1, 1, moves + 1});
                    }

                    // Rotate Counterclockwise
                    if (!visited[r][c][0]) {
                        visited[r][c][0] = true;
                        queue.offer(new int[]{r, c, 0, moves + 1});
                    }
                }
            }
        }

        return -1;
    }
}