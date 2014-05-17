public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < n; ++i, end = end.next) {
            if (end.next == null) {
                return head.next;
            }
        }

        for ( ; end.next != null; start = start.next, end = end.next) {
            ;
        }
        start.next = start.next.next;
        return head.next;
    }
}
