import java.util.ArrayList;

public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeLinkNode> current = null;
        ArrayList<TreeLinkNode> post = new ArrayList<TreeLinkNode>();
        post.add(root);
        while (post.size() != 0) {
            current = post;
            post = new ArrayList<TreeLinkNode>();
            int n = current.size();
            for (int i = 0; i < n - 1; ++i) {
                TreeLinkNode node = current.get(i);
                node.next = current.get(i + 1);
            }
            for (int i = 0; i < n; ++i) {
                TreeLinkNode node = current.get(i);
                if (node.left != null) {
                    post.add(node.left);
                }
                if (node.right != null) {
                    post.add(node.right);
                }
            }
        }
    }
}
