public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int leftMax, int rightMin) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (val <= leftMax || val >= rightMin) {
            return false;
        }
        return isValidBST(root.left, leftMax, Math.min(rightMin, val)) 
            && isValidBST(root.right, Math.max(leftMax, val), rightMin);
    }
}
