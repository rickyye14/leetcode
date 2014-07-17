import java.util.ArrayList;

public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode prev = null;
        TreeLinkNode post = null;
        TreeLinkNode curr = root;
        for ( ; curr != null; ) {
            prev = null;
            post = null;
            for ( ; curr != null; curr = curr.next) {
                if (curr.left == null && curr.right == null) {
                    continue;
                }
                if (post == null) {
                    if (curr.left != null) {
                        post = curr.left;
                    } else {
                        post = curr.right;
                    }
                }
                if (curr.left != null) {
                    if (prev != null) {
                        prev.next = curr.left;
                    }
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right;
                    }
                    prev = curr.right;
                }
            }
        }
    }
}
