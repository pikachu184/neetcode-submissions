
public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "null";

        return root.val + "," +
               serialize(root.left) + "," +
               serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue =
            new LinkedList<>(Arrays.asList(data.split(",")));

        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = buildTree(queue);
        root.right = buildTree(queue);

        return root;
    }
}
