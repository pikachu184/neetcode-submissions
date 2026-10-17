class Solution {
    public int minimumOperations(TreeNode root) {
        int answer = 0;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<int[]> order = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                TreeNode node = nodes.get(i);
                order.add(new int[] { node.val, i });
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            order.sort(Comparator.comparingInt(a -> a[0]));
            boolean[] seen = new boolean[order.size()];
            for (int i = 0; i < order.size(); i++) {
                int length = 0, j = i;
                while (!seen[j]) {
                    seen[j] = true;
                    length++;
                    j = order.get(j)[1];
                }
                answer += Math.max(0, length - 1);
            }
            nodes = next;
        }
        return answer;
    }
}