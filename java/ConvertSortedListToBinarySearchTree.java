public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode token = new ListNode(0);
        token.next = head;
        head = token;
        ListNode ptr = head.next;
        int n = 0;
        for ( ; ptr != null; ++n, ptr = ptr.next) {
            ;
        }
        return sortedListToBST(head, n);
    }

    private TreeNode sortedListToBST(ListNode head, int n) {
        if (n == 0) {
            return null;
        }
        ListNode ptr = head;
        for (int i = 0; i <= n / 2; ++i) {
            ptr = ptr.next;
        }
        TreeNode node = new TreeNode(ptr.val);
        node.left = sortedListToBST(head, n / 2);
        node.right = sortedListToBST(ptr, n - n / 2 - 1);
        return node;
    }
}
