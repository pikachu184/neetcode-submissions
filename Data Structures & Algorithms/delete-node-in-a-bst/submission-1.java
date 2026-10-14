class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode predecessor = findPredecessor(root.left);
            root.val = predecessor.val;
            root.left = deleteNode(root.left, predecessor.val);
        }

        return root;
    }

    public TreeNode findPredecessor(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}