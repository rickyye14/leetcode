public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m == n) {
            return head;
        }
        ListNode token = new ListNode(0);
        token.next = head;
        head = token;
        ListNode first = head;
        for (int i = 0; i < m - 1; ++i) {
            first = first.next;
        }
        ListNode firstNext = first.next;
        ListNode last = firstNext;
        for (int i = 0; i < n - m; ++i) {
            last = last.next;
        }
        ListNode lastNext = last.next;
        last.next = null;
        token = null;
        while (firstNext != null) {
            ListNode temp = token;
            token = firstNext;
            firstNext = firstNext.next;
            token.next = temp;
        }
        first.next = token;
        ListNode tail = token;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = lastNext;
        return head.next;
    }
}
