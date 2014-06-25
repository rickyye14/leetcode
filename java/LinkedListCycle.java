public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode token = new ListNode(0);
        token.next = head;
        head = token;
        for (ListNode ptr1 = head, ptr2 = head.next; 
                ptr2 != null && ptr2.next != null; 
                ptr1 = ptr1.next, ptr2 = ptr2.next.next) {
            if (ptr1 == ptr2) {
                return true;
            }
        }
        return false;
    }
}
