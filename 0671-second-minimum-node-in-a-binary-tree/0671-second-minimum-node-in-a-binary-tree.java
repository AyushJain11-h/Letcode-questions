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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int min = root.val;
        return findSecond(root, min);
    }

    private int findSecond(TreeNode root, int min) {
        if (root == null) {
            return -1;
        }

        if (root.val > min) {
            return root.val;
        }

        int left = findSecond(root.left, min);
        int right = findSecond(root.right, min);

        if (left == -1) {
            return right;
        }

        if (right == -1) {
            return left;
        }

        return Math.min(left, right);
    }
}
