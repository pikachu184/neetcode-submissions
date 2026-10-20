class Solution {
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        return construct(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] inorder,
                               int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = inStart;
        while (inorder[mid] != rootVal) {
            mid++;
        }

        root.left = construct(preorder, inorder, inStart, mid - 1);
        root.right = construct(preorder, inorder, mid + 1, inEnd);

        return root;
    }
}