public class RecoverBinarySearchTree {
    private TreeNode previous;
    private TreeNode first;
    private TreeNode second;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        previous = null;
        first = null;
        second = null;
        searchTree(root);
        if (first != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void searchTree(TreeNode current) {
        if (current == null) {
            return;
        }
        searchTree(current.left);
        if (previous != null) {
            if (current.val < previous.val) {
                if (first == null) {
                    first = previous;
                }
                second = current;
            }
        }
        previous = current;
        searchTree(current.right);
    }
}
