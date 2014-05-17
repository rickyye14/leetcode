public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        ListNode start = head;
        ListNode end = head;
        while (true) {
            for (int i = 0; i < k; ++i) {
                end = end.next;
                if (end == null) {
                    break;
                }
            }
            if (end == null) {
                break;
            }
            ListNode token = end.next;
            end = start.next;
            ListNode reverseNode = null;
            for (ListNode ptr = start.next; ptr != token; ) {
                ListNode oldNode = reverseNode;
                reverseNode = ptr;
                ptr = ptr.next;
                reverseNode.next = oldNode;
            }
            start.next = reverseNode;
            end.next = token;
            start = end;
        }
        return head.next;
    }
}
