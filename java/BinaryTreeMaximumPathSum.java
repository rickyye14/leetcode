public class BinaryTreeMaximumPathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxSum = Integer.MIN_VALUE;
        searchMax(root);
        return maxSum;
    }

    private int searchMax(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        int leftMax = Math.max(0, searchMax(curr.left));
        int rightMax = Math.max(0, searchMax(curr.right));
        maxSum = Math.max(maxSum, curr.val + leftMax + rightMax);
        return curr.val + Math.max(0, Math.max(leftMax, rightMax));
    }
}
