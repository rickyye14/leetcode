public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode token = new ListNode(0);
        token.next = head;
        head = token;
        int n = 0;
        ListNode end = head;
        for ( ; end.next != null; end = end.next) {
            ++n;
        }
        k %= n;
        if (k == 0) {
            return head.next;
        }
        ListNode start = head;
        for (int i = 0; i < n - k; ++i) {
            start = start.next;
        }
        token = head.next;
        head.next = start.next;
        end.next = token;
        start.next = null;
        return head.next;
    }
}
