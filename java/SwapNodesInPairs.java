public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        head = temp;
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        while (ptr2 != null && ptr2.next != null) {
            ListNode token = ptr2.next.next;
            ptr1.next = ptr2.next;
            ptr2.next.next = ptr2;
            ptr2.next = token;
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
        return head.next;
    }
}
