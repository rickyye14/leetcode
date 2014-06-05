public class FlattenBinaryTreeToLinkedList {
    private TreeNode top;
    private TreeNode rightmost;

    // java pass the copy of object reference in function parameter
    public void flatten(TreeNode root) {
        top = new TreeNode(0);
        rightmost = top;
        preorderTraversal(root);
        TreeNode token = new TreeNode(0);
        token.right = root;
        root = token;
        copyTree(root, top);
    }

    private void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        rightmost.right = new TreeNode(node.val);
        rightmost = rightmost.right;
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    private void copyTree(TreeNode t1, TreeNode t2) {
        while (t2 != null) {
            t1.left = null;
            t1.val = t2.val;
            if (t1.right == null && t2.right != null) {
                t1.right = new TreeNode(0);
            }
            t1 = t1.right;
            t2 = t2.right;
        }
    }

    public void display(TreeNode root) {
        if (root == null) {
            System.out.println('#');
            return;
        }
        System.out.println(root.val);
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList solver = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        solver.flatten(root);
        solver.display(root);
    }
}
