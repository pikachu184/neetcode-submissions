
class Solution {
    int prev = -1;
    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse left subtree
        inorder(root.left);

        // Process current node
        if (prev != -1) {
            minDiff = Math.min(minDiff, root.val - prev);
        }

        prev = root.val;

        // Traverse right subtree
        inorder(root.right);
    }
}
