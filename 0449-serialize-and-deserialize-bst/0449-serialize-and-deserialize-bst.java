class Codec {

    // Serialize (Preorder traversal)
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Deserialize
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] values = data.split(",");
        int[] index = new int[1];  // pointer for array

        return buildTree(values, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(String[] values, int[] index, int min, int max) {
        if (index[0] >= values.length) return null;

        int val = Integer.parseInt(values[index[0]]);

        if (val < min || val > max) return null;

        TreeNode root = new TreeNode(val);
        index[0]++;

        root.left = buildTree(values, index, min, val);
        root.right = buildTree(values, index, val, max);

        return root;
    }
}