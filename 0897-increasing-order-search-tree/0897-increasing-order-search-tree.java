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
    
    TreeNode current = null;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        current = dummy;

        inorder(root);

        return dummy.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse left subtree
        inorder(root.left);

        // Add current node to the right
        current.right = root;
        root.left = null;
        current = root;

        // Traverse right subtree
        inorder(root.right);
    }
}