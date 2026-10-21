class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) return root;
        //post order 
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        //process the parent
        if(root.left == null && root.right ==null && root.val == target){
            return null;
        }
        return root;
    }
}