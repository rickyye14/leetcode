public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left);
        if (lh == -1) {
            return -1;
        }
        int rh = height(node.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return 1 + Math.max(lh, rh);
    }
}
