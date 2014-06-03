public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int val = root.val;
        if (root.left == null && root.right == null) {
            return val == sum;
        }
        return hasPathSum(root.left, sum - val) 
            || hasPathSum(root.right, sum - val);
    }
}
