import java.util.*;

class Solution {
    public int checkWays(int[][] pairs) {

        // adjacency list
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] pair : pairs) {
            int u = pair[0];
            int v = pair[1];

            graph.putIfAbsent(u, new HashSet<>());
            graph.putIfAbsent(v, new HashSet<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Find the root.
        // Root must be connected to every other node.
        int root = -1;

        for (int node : graph.keySet()) {
            if (graph.get(node).size() == graph.size() - 1) {
                root = node;
                break;
            }
        }

        // No possible root => impossible
        if (root == -1) {
            return 0;
        }

        int result = 1;

        // Process every node except root
        for (int node : graph.keySet()) {

            if (node == root) {
                continue;
            }

            Set<Integer> neighbors = graph.get(node);

            int parent = -1;
            int parentDegree = Integer.MAX_VALUE;

            // Find the smallest-degree neighbor that contains
            // all neighbors of 'node'.
            for (int neighbor : neighbors) {

                if (graph.get(neighbor).size() >= neighbors.size()
                        && graph.get(neighbor).size() < parentDegree) {

                    parent = neighbor;
                    parentDegree = graph.get(neighbor).size();
                }
            }

            // No valid parent
            if (parent == -1) {
                return 0;
            }

            // Every neighbor of node must also be a neighbor of parent
            for (int neighbor : neighbors) {
                if (neighbor == parent) {
                    continue;
                }

                if (!graph.get(parent).contains(neighbor)) {
                    return 0;
                }
            }

            // If node and parent have the same degree,
            // either one can be the parent.
            if (graph.get(parent).size() == neighbors.size()) {
                result = 2;
            }
        }

        return result;
    }
}