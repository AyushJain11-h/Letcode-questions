import java.util.*;

class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];

            graph[u].add(new int[]{v, cnt});
            graph[v].add(new int[]{u, cnt});
        }

        // dist[i] = minimum number of moves needed to reach node i
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        pq.offer(new int[]{0, 0}); // {node, distance}

        int answer = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int node = curr[0];
            int distance = curr[1];

            if (distance > dist[node]) {
                continue;
            }

            if (distance > maxMoves) {
                continue;
            }

            // Original node is reachable
            answer++;

            for (int[] edge : graph[node]) {
                int next = edge[0];
                int subdivisions = edge[1];

                int newDistance = distance + subdivisions + 1;

                if (newDistance < dist[next] && newDistance <= maxMoves) {
                    dist[next] = newDistance;
                    pq.offer(new int[]{next, newDistance});
                }
            }
        }

        // Count reachable subdivided nodes on every edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int subdivisions = edge[2];

            int fromU = Math.max(0, maxMoves - dist[u]);
            int fromV = Math.max(0, maxMoves - dist[v]);

            answer += Math.min(
                subdivisions,
                fromU + fromV
            );
        }

        return answer;
    }
}