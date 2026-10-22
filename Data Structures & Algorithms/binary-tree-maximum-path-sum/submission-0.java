
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }

    int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, solve(root.left));
        int right = Math.max(0, solve(root.right));

        // Path jo current node se pass hota hai
        int currentSum = root.val + left + right;

        maxSum = Math.max(maxSum, currentSum);

        // Parent ko sirf ek side ka path return kar sakte hain
        return root.val + Math.max(left, right);
    }
}
