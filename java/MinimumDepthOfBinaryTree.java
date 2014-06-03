public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = minDepth(root.left);
        int rh = minDepth(root.right);
        if (lh == 0) {
            return 1 + rh;
        }
        if (rh == 0) {
            return 1 + lh;
        }
        return 1 + Math.min(lh, rh);
    }
}
