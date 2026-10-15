class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
            TreeNode rightside = null;
            int qlen = q.size();

            for(int i = 0; i<qlen; i++){
                TreeNode node = q.poll();
                if(node != null){
                    rightside = node;
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            if(rightside != null){
                res.add(rightside.val);
            }
        }
        return res;
        
    }
}
