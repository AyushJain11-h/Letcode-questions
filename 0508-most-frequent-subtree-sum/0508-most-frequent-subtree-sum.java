/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    private Map<Integer, Integer> freqMap = new HashMap<>();
    private int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        dfs(root);

        List<Integer> result = new ArrayList<>();
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) == maxFreq) {
                result.add(key);
            }
        }

        // Convert list to array
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        int sum = node.val + leftSum + rightSum;

        freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
        maxFreq = Math.max(maxFreq, freqMap.get(sum));

        return sum;
    }
}