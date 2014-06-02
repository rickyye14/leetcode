import java.util.ArrayList;

public class BinaryTreeZigzagLevelOrderTraversal {
    ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> token = new ArrayList<Integer>();
        ArrayList<TreeNode> upNodes = new ArrayList<TreeNode>();
        ArrayList<TreeNode> downNodes = new ArrayList<TreeNode>();
        upNodes.add(root);
        for (int k = 0; upNodes.size() != 0; ++k) {
            token = new ArrayList<Integer>();
            downNodes = new ArrayList<TreeNode>();
            for (int i = 0; i < upNodes.size(); ++i) {
                TreeNode node = upNodes.get(i);
                token.add(node.val);
            }
            for (int i = upNodes.size() - 1; i >= 0; --i) {
                TreeNode node = upNodes.get(i);
                if (k % 2 == 0) {
                    if (node.right != null) {
                        downNodes.add(node.right);
                    }
                    if (node.left != null) {
                        downNodes.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        downNodes.add(node.left);
                    }
                    if (node.right != null) {
                        downNodes.add(node.right);
                    }
                }
            }
            res.add(token);
            upNodes = downNodes;
        }
        return res;
    }
}
