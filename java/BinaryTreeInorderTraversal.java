import java.util.ArrayList;

public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }
}
