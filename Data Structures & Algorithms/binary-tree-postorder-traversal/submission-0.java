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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        if(root == null){
            return res;
        }
        while(node!=null||!stack.isEmpty()){
            //move to the left
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            //move to the right
            if(stack.peek().right!=null){
                node =stack.peek().right;
            }else{
                TreeNode temp = stack.pop();
                res.add(temp.val);
                while(!stack.isEmpty() && temp==stack.peek().right){
                    temp = stack.pop();
                    res.add(temp.val);

                }
            }
            //print root

        }return res;
    }
}