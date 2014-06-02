import java.util.ArrayList;

public class UniqueBinarySearchTreesII {
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> token = new ArrayList<TreeNode>();
        ArrayList<ArrayList<TreeNode>> dp = new ArrayList<ArrayList<TreeNode>>();
        token.add(null);
        if (n <= 0) {
            return token;
        }
        dp.add(new ArrayList<TreeNode>(token));
        token = new ArrayList<TreeNode>();
        token.add(new TreeNode(1));
        dp.add(new ArrayList<TreeNode>(token));
        for (int i = 2; i <= n; ++i) {
            token = new ArrayList<TreeNode>();
            for (int j = 1; j <= i; ++j) {
                ArrayList<TreeNode> leftSet = dp.get(j - 1);
                ArrayList<TreeNode> rightSet = dp.get(i - j);
                for (int k = 0; k < leftSet.size(); ++k) {
                    for (int l = 0; l < rightSet.size(); ++l) {
                        TreeNode root = new TreeNode(j);
                        root.left = copyTree(leftSet.get(k));
                        root.right = copyTree(rightSet.get(l));
                        increaseTreeValues(root.right, j);
                        token.add(root);
                    }
                }
            }
            dp.add(new ArrayList<TreeNode>(token));
        }
        return dp.get(n);
    }

    private TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = new TreeNode(root.val);
        temp.left = copyTree(root.left);
        temp.right = copyTree(root.right);
        return temp;
    }

    private void increaseTreeValues(TreeNode root, int inc) {
        if (root == null) {
            return;
        }
        root.val += inc;
        increaseTreeValues(root.left, inc);
        increaseTreeValues(root.right, inc);
    }
}
