import java.util.*;

class Solution {
    int[] nums;
    List<Integer>[] graph;
    int[] xor;
    int[] parent;
    int n;
    int totalXor;
    int answer = Integer.MAX_VALUE;

    public int minimumScore(int[] nums, int[][] edges) {
        this.nums = nums;
        n = nums.length;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        xor = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);

        dfs(0, -1);
        totalXor = xor[0];

        // Try removing two edges
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = i, b = j;

                int x1, x2, x3;

                if (isAncestor(a, b)) {
                    x1 = xor[b];
                    x2 = xor[a] ^ xor[b];
                    x3 = totalXor ^ xor[a];
                } else if (isAncestor(b, a)) {
                    x1 = xor[a];
                    x2 = xor[b] ^ xor[a];
                    x3 = totalXor ^ xor[b];
                } else {
                    x1 = xor[a];
                    x2 = xor[b];
                    x3 = totalXor ^ xor[a] ^ xor[b];
                }

                int max = Math.max(x1, Math.max(x2, x3));
                int min = Math.min(x1, Math.min(x2, x3));
                answer = Math.min(answer, max - min);
            }
        }

        return answer;
    }

    private void dfs(int node, int par) {
        parent[node] = par;
        xor[node] = nums[node];

        for (int nei : graph[node]) {
            if (nei == par) continue;
            dfs(nei, node);
            xor[node] ^= xor[nei];
        }
    }

    private boolean isAncestor(int u, int v) {
        while (v != -1) {
            if (v == u) return true;
            v = parent[v];
        }
        return false;
    }
}