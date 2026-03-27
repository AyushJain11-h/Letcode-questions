/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (distance == k) {
                while (!queue.isEmpty()) {
                    result.add(queue.poll().val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                for (TreeNode neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            distance++;
        }

        return result;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;

        graph.putIfAbsent(node, new ArrayList<>());

        if (parent != null) {
            graph.get(node).add(parent);
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(parent).add(node);
        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}