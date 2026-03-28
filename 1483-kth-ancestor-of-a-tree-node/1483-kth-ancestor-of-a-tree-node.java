class TreeAncestor {
    private int[][] up;
    private int LOG;

    public TreeAncestor(int n, int[] parent) {
        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        up = new int[n][LOG];

        // 2^0 ancestor = direct parent
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        // Build binary lifting table
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                int prev = up[i][j - 1];
                up[i][j] = (prev == -1) ? -1 : up[prev][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if (((k >> j) & 1) == 1) {
                node = up[node][j];
                if (node == -1) return -1;
            }
        }
        return node;
    }
}