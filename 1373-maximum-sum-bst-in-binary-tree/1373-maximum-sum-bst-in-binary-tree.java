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
class Solution {
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    /**
     * Performs a post-order traversal and returns an array containing info about the subtree.
     * 
     * @param node The current tree node.
     * @return An array of 4 integers:
     *         [0] = 1 if the subtree is a BST, 0 otherwise.
     *         [1] = minimum value in the subtree.
     *         [2] = maximum value in the subtree.
     *         [3] = sum of all nodes in the subtree.
     */
    private int[] dfs(TreeNode node) {
        // Base case: null node is considered a valid BST with sum 0.
        // Use Integer.MAX_VALUE for min and Integer.MIN_VALUE for max to simplify comparisons.
        if (node == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        // Recursively process the left and right subtrees [citation:2][citation:3].
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // Check if the current node forms a valid BST [citation:2].
        // Conditions:
        // 1. Both left and right subtrees are BSTs.
        // 2. Current node's value is greater than the maximum value in the left subtree.
        // 3. Current node's value is less than the minimum value in the right subtree.
        boolean isLeftBST = left[0] == 1;
        boolean isRightBST = right[0] == 1;
        boolean isValidBST = isLeftBST && isRightBST && 
                             node.val > left[2] && node.val < right[1];

        if (isValidBST) {
            // Calculate the sum of the current BST subtree [citation:2].
            int currentSum = left[3] + right[3] + node.val;
            // Update the global maximum sum.
            maxSum = Math.max(maxSum, currentSum);

            // Prepare the result for this valid BST: return its isBST status, min, max, and sum.
            int min = Math.min(left[1], node.val);
            int max = Math.max(right[2], node.val);
            return new int[]{1, min, max, currentSum};
        } else {
            // If the current subtree is not a BST, return 0 for isBST.
            // The other values are not meaningful for a non-BST subtree.
            return new int[]{0, 0, 0, 0};
        }
    }
}